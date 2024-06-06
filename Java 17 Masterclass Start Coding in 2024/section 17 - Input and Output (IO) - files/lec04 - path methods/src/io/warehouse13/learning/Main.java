package io.warehouse13.learning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Path path = Path.of("files/testing.txt");
		printPathInfo(path);
		logStatements(path);
		System.out.println("****************");
		extraInfo(path);
	}

	private static void printPathInfo(Path path) {
		System.out.println("Path " + path);
		System.out.println("File name " + path.getFileName());
		System.out.println("Parent " + path.getParent());
		Path absolutePath = path.toAbsolutePath();
		System.out.println("Absolute Path " + absolutePath);
		System.out.println("Absolute Path root:  " + absolutePath.getRoot());
		System.out.println("Root: " + path.getRoot());
		System.out.println("isAbsolute : " + path.isAbsolute());

		System.out.println("****************");
		System.out.println("Absolute Path root:  " + absolutePath.getRoot());
		int count = 1;
		var it = path.toAbsolutePath().iterator();
		while (it.hasNext())
			System.out.println(".".repeat(count++) + " " + it.next());

		System.out.println("****************");
		int pathParts = absolutePath.getNameCount();
		for(int i = 0; i < pathParts; i++)
			System.out.println(".".repeat(i + 11) + " " + absolutePath.getName(i));
		System.out.println("****************");
	}

	private static void logStatements (Path path) {
		try {
			Path parent = path.getParent();
			if(!Files.exists(parent))
				Files.createDirectory(parent);
			Files.writeString(path, Instant.now() +
					": fake log generated saying 'Hello world'\n,",
					StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void	 extraInfo(Path path) {
		try {
			Map<String, Object> attrs = Files.readAttributes(path, "*");
			attrs.entrySet().forEach(System.out::println);
			System.out.println("probeContentType: " + Files.probeContentType(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
