package io.warehouse13.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {

		System.out.println("Current Working Directory (cwd) = " +
				new File("").getAbsolutePath());

		// relative path ...
		String filename = "files/testing.csv";
		// retieve absolute path
		File file = new File(new File("").getAbsolutePath(), filename);
		System.out.println("file path " + file.getAbsolutePath());
		if (!file.exists()) {
			System.out.println("I can't run unless this file exists");
			return;
		}
		System.out.println("I'm good to go.");

		// we list root "files", here hard drives
		System.out.println("---------------");
		for (File f : File.listRoots()) {
			System.out.println(f);
		}
		System.out.println("---------------");
		Path path = Paths.get("files/testing.csv");
		System.out.println("Current path: ");
		System.out.println(file.getAbsolutePath());
		if (!Files.exists(path)) {
			System.out.println("2. I can't run unless this file exists");
			return;
		}
		System.out.println("2. I'm good to go.");

	}
}
