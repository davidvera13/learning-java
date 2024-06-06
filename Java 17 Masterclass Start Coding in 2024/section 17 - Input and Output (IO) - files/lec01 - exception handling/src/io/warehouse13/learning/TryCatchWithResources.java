 package io.warehouse13.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TryCatchWithResources {
	public static void main(String[] args) {
		String fileName = "testing.csv";

		File file = new File(fileName);
		//testFile(fileName);
//		testFile(fileName);
//		testFile2(fileName);
		testFile3(fileName);

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
		FileReader  reader = null;
		try {
			reader = new FileReader(fileName);
			List<String> lines = Files.readAllLines(path);
			// do something ...
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			// very dirty way to close the reader ...
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			System.out.println("I'm logging that we had an exception ... ");
		}
		System.out.println("File exists, ready to go");
	}

	private static void testFile2(String fileName) {
		try (FileReader reader = new FileReader(fileName)){
			// do something..
			System.out.println("Reading ongoing...");
		} catch (FileNotFoundException e) {
			System.out.println("Ooops, file was not found");
			throw new RuntimeException(e);
		} catch (IOException e) {
			System.out.println("Ooops, an IO exception occured");
			throw new RuntimeException(e);
		} finally {
			System.out.println("I'm logging that we had an exception ... ");
		}
		System.out.println("File exists, ready to go");
	}


	private static void testFile3(String fileName) {

		try (FileReader reader = new FileReader(fileName)) {
			System.out.println("Reading ongoing...");
		} catch (FileNotFoundException e) {
			System.out.println("File '" + fileName + "' does not exist");
			throw new RuntimeException(e);
		} catch (NullPointerException | IllegalArgumentException badData) {
			System.out.println("User has added bad data " + badData.getMessage());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			System.out.println("Something unrelated and unexpected happened");
		} finally {
			System.out.println("Maybe I'd log something either way...");
		}
		System.out.println("File exists and able to use as a resource");
	}



}
