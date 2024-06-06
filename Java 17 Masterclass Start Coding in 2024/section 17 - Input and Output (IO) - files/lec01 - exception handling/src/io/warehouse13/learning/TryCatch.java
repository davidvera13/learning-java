package io.warehouse13.learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TryCatch {
	public static void main(String[] args) {
		String fileName = "testing.csv";

		File file = new File(fileName);
		testFile(fileName);

		// LBYL: look before you leap: checking for errors before performing operation
		// EAFP: easier to ask forgiveness than permission : operation should succeed... but we wil handle errors
		// that could occurs, if they occur
		if(!file.exists()) {
			System.out.println("Application can't run unless file exists");
			return;
		}

		System.out.println("Application will run ...");
	}

	private static void testFile(String fileName) {
		Path path = Paths.get(fileName);
		File file = new File(fileName);
		try {
			List<String> lines = Files.readAllLines(path);
			// do something ...
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("I'm logging that we had an exception ... ");
		}
		System.out.println("File exists, ready to go");
	}
}
