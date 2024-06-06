package io.warehouse13.learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
	public static void main(String[] args) {
		useFile("testFile.txt");
		System.out.println("******************");
		usePath("testPath.txt");
	}

	private static void useFile(String fileName) {
		File file = new File(fileName);
		boolean fileExists = file.exists();

		System.out.printf("File %s %s%n", fileName, fileExists ? "exists" : "does not exist");
		if (fileExists) {
			System.out.println("Deleting file: " + fileName);
			fileExists = !file.delete();
		}
		if (!fileExists) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Something went wrong");
				throw new RuntimeException(e);
			}
			System.out.println("created file: " + fileName);
			if (file.canWrite())
				System.out.println("Writing file !");
		}
		System.out.println(fileExists);
	}

	private static void usePath(String fileName) {
		Path path = Path.of(fileName);
		boolean fileExists = Files.exists(path);

		System.out.printf("File %s %s%n", fileName, fileExists ? "exists" : "does not exist");
		if (fileExists) {
			System.out.println("Deleting file: " + fileName);
			try {
				Files.delete(path);
				fileExists = false;
			} catch (IOException e) {
				e.printStackTrace();
				//throw new RuntimeException(e);
			}
		}
		if (!fileExists) {
			try {
				Files.createFile(path);
				System.out.println("created file: " + fileName);
				if (Files.isWritable(path)) {
					System.out.println("Writing file !");
					String content = """
													Hello world
													I writing some data
													writing file using path and Files
							""";
					Files.writeString(path, content);
					System.out.println("I can read too ... ");
					System.out.println("******************");
					Files.readAllLines(path).forEach(System.out::println);
				}
			} catch (IOException e) {
				System.out.println("Something went wrong");
				throw new RuntimeException(e);
			}

		}
	}
}
