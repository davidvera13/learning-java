package io.warehouse13.learning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class MainFixedWidth {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File("fixedWidth.txt"))) {
			// we read a file: first columns (Name) has 15 characters, second column (Age) has 3 characters,
			// third columns (Dept) has 12 chars, fourth (Salary) column has 8 chars, fifth (state) has 5 chars
			var results = scanner
					.findAll("(.{15})(.{3})(.{12})(.{8})(.{2}).*")
					// we want the fifth column
					.map(m -> m.group(5))
					.distinct()
					.sorted()
					.toArray(String[]::new);
			System.out.println(Arrays.toString(results));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("fixedWidth.txt")))) {
		//try (Scanner scanner = new Scanner(new FileReader("fixedWidth.txt"))) {
		//try (Scanner scanner = new Scanner(new File("fixedWidth.txt"))) {
			// we return values with spaces
			var results = scanner
					.findAll("(.{15})(.{3})(.{12})(.{8})(.{2}).*")
					.skip(1) // skipping header
					// we want the fifth column
					.map(m -> m.group(3))
					.distinct()
					.sorted()
					.toArray(String[]::new);
			System.out.println(Arrays.toString(results));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}


	}
}
