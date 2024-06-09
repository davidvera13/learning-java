package io.warehouse13.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File("file.txt"))) {
			//while (scanner.hasNextLine())
			//	System.out.println(scanner.nextLine());
			//System.out.println(scanner.delimiter()); // \p{javaWhitespace}+
			//scanner.useDelimiter("$");
			//System.out.println(scanner.delimiter());
			//System.out.println("********************");
			//scanner.tokens().forEach(System.out::println);

			// find all words containing 10 chars or more
			scanner.findAll("[A-Za-z]{10,}")
					.map(MatchResult::group)
					.distinct()
					.sorted()
					.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
