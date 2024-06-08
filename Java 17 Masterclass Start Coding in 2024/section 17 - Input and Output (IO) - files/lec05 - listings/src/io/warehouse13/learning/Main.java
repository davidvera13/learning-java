package io.warehouse13.learning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Path path = Path.of("");
		System.out.println("pwd: " + path.toAbsolutePath());
		System.out.println("Using list ....");
		try (Stream<Path> pathStream = Files.list(path)) {
			pathStream
					.map(Main::listDir)
					.forEach(System.out::println);
		} catch (IOException e){
			throw new RuntimeException(e);
		}

		System.out.println("********************************");
		System.out.println("Using walk ....");
		// walk is recursive
		try (Stream<Path> pathStream = Files.walk(path, 5)) {
			pathStream
					.filter(Files::isRegularFile) // we can output only files
					.map(Main::listDir)
					.forEach(System.out::println);
		} catch (IOException e){
			throw new RuntimeException(e);
		}

		System.out.println("********************************");
		System.out.println("Using find ....");
		// find is more effichient for finding files
		try (Stream<Path> pathStream = Files.find(path, 5,
				(p, attributes) -> Files.isRegularFile(p))) {
			pathStream
					//.filter(Files::isRegularFile) // we can output only files
					.map(Main::listDir)
					.forEach(System.out::println);
		} catch (IOException e){
			throw new RuntimeException(e);
		}

		System.out.println("********************************");
		System.out.println("Using find ....");
		// find is more effichient for finding files
		try (Stream<Path> pathStream = Files.find(path, Integer.MAX_VALUE,
				(p, attributes) -> attributes.isRegularFile() && attributes.size() > 300)) {
			pathStream
					//.filter(Files::isRegularFile) // we can output only files
					.map(Main::listDir)
					.forEach(System.out::println);
		} catch (IOException e){
			throw new RuntimeException(e);
		}
		System.out.println("********************************");
		System.out.println("****** Directory Stream ********");
		System.out.println("********************************");
		// better for finding diles
		try (var dirs = Files.newDirectoryStream(path)){
			dirs.forEach(d -> System.out.println(Main.listDir(d)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("********************************");
		System.out.println("Using glob");
		path = path.resolve(".idea");
		try (var dirs = Files.newDirectoryStream(path, "*.xml")){
			dirs.forEach(d -> System.out.println(Main.listDir(d)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println("********************************");
		System.out.println("using lambda");
		try (var dirs = Files.newDirectoryStream(path,
				p -> p.getFileName().toString().endsWith(".xml"))){
			dirs.forEach(d -> System.out.println(Main.listDir(d)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println("********************************");
		System.out.println("using lambda & filters");
		try (var dirs = Files.newDirectoryStream(path,
				p -> p.getFileName().toString().endsWith(".xml") && Files.size(p) > 1000)) {
			dirs.forEach(d -> System.out.println(Main.listDir(d)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	private static String listDir(Path path) {
		try {
			boolean isDirectory = Files.isDirectory(path);
			FileTime dateField = Files.getLastModifiedTime(path);
			LocalDateTime modificationDt = LocalDateTime.ofInstant(
					dateField.toInstant(),
					ZoneId.systemDefault());
			//System.out.println(path + " is directory ? " + isDirectory);

			//return "%s %-15s %s".formatted(modificationDt, isDirectory ? "<DIR>": "", path);
			return "%tD %tT %-5s %12s %s".formatted(
					modificationDt,
					modificationDt,
					isDirectory ? "<DIR>": "",
					isDirectory ? "" :  Files.size(path),
					path);
		} catch (IOException e) {
			System.out.println("Something went wrong with " + path);
			return path.toString();
		}
	}
}
