package io.warehouse13.learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		// using file reader
		try (FileReader reader = new FileReader("file.txt")) {
			int data;
			char[] buff = new char[1000];
			//while ((data = reader.read()) != -1)
			//	System.out.println((char) data);
			while ((data = reader.read(buff)) != -1) {
				String content = new String(buff, 0, data);
				System.out.printf("[%d chars] %s %n", data, content);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println("--------------------------");
		// using buffered reader
		try (BufferedReader reader = new BufferedReader(new FileReader("file2.txt"))){
			reader.lines().forEach(System.out::println);
			//String line;
			//while (((line = reader.readLine()) != null))
			//	System.out.println(line);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
