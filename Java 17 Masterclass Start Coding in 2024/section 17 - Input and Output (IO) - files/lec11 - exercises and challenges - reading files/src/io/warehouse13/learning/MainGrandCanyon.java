package io.warehouse13.learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainGrandCanyon {
	// In this challenge, I want you to pick some text from a document, or an online article, or some wiki page.
	//You'll create a program to read the text document, with one of the methods we talked about in the last couple of lectures.
	//You can pick any method you want to use, but whichever you use, your program should do the following.
	//Tokenize the text into words, remove any punctuation.
	//Ignore words with 5 characters or less.
	//Count the occurrences of each word.
	//Display the top 10 most used words.
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("GrandCanyon.txt"))) {
			//System.out.printf("%,d lines in file%n", reader.lines().count());
			//System.out.printf("%,d lines in file%n", reader.lines().count()); // terminal operation... returns 0
			Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");

			// solution 1:
			//System.out.printf("%,d words in file%n",
			//		reader.lines()
			//				// .flatMap(pattern::splitAsStream).count());
			//				.flatMap(l -> Arrays.stream(l.split(pattern.toString()))).count());

			// solution 2:
			//System.out.printf("%,d words in file%n",
			//		reader.lines()
			//				.mapToLong(l -> l.split(pattern.toString()).length)
			//				.sum());
			List<String> excluded = List.of(
					"grand",
					"canyon",
					"retrieved",
					"archived",
					"service",
					"original");

			var result = reader.lines()
					.flatMap(pattern::splitAsStream)
					.map(w -> w.replaceAll("\\p{Punct}", ""))
					.filter(w -> w.length() > 4)
					.map(String::toLowerCase)
					.filter(w -> !excluded.contains(w))
					.collect(Collectors.groupingBy(w -> w, Collectors.counting()));

			result.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					//.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
					.limit(10)
					.forEach(e -> System.out.println(
							e.getKey() + " - " + e.getValue() + " times"));


		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
