package io.warehouse13.learning.step03streamingnetwork;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFromHttp {
	public static void main(String[] args) {
        // call http api
        String urlString = "https://api.census.gov/data/2019/pep/charagegroups?get=NAME,POP&for=state:*";
        URI uri = URI.create(urlString);
        try (
                var urlInputStream = uri.toURL().openStream();) {
            urlInputStream.transferTo(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path jsonPath = Path.of("USPopulationByState.txt");
        try (var reader = new InputStreamReader(uri.toURL().openStream());
             var writer = Files.newBufferedWriter(jsonPath)) {
            reader.transferTo(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var reader = new InputStreamReader(uri.toURL().openStream());
             PrintWriter writer = new PrintWriter("USPopulationByState.csv")) {
            reader.transferTo(new Writer() {
                @Override
                public void write(char[] cbuf, int off, int len) throws IOException {

                    String jsonString = new String(cbuf, off, len).trim();
                    jsonString = jsonString.replace('[', ' ').trim();
                    jsonString = jsonString.replaceAll("\\]", "");
                    writer.write(jsonString);
                }

                @Override
                public void flush() throws IOException {
                    writer.flush();
                }

                @Override
                public void close() throws IOException {
                    writer.close();
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

