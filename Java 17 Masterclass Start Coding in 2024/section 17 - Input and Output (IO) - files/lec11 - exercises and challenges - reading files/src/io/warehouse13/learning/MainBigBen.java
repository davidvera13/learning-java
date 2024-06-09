package io.warehouse13.learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainBigBen {
	// In this challenge, I want you to pick some text from a document, or an online article, or some wiki page.
	//You'll create a program to read the text document, with one of the methods we talked about in the last couple of lectures.
	//You can pick any method you want to use, but whichever you use, your program should do the following.
	//Tokenize the text into words, remove any punctuation.
	//Ignore words with 5 characters or less.
	//Count the occurrences of each word.
	//Display the top 10 most used words.
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("BigBen.txt"))) {
			//System.out.printf("%,d lines in file%n", reader.lines().count());
			//System.out.printf("%,d lines in file%n", reader.lines().count()); // terminal operation... returns 0
			Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");

			var result = reader.lines()
					.flatMap(pattern::splitAsStream)
					.map(w -> w.replaceAll("\\p{Punct}", ""))
					.filter(w -> w.length() > 4)
					.map(String::toLowerCase)
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

		System.out.println("Using steam ");
		System.out.println("***************");
		String input;
		try {
			input = Files.readString(Path.of("BigBen.txt"));
			input = input.replaceAll("\\p{Punct}", "");
			// Pattern pattern = Pattern.compile("\\w+");
			Pattern pattern = Pattern.compile("\\w{5,}");
			Matcher matcher = pattern.matcher(input);
			Map<String, Long> results = new HashMap<>();
			while (matcher.find()) {
				String word = matcher.group().toLowerCase();
				results.merge(word, 1L, Long::sum);
				//if(word.length() > 4) {
				//	results.merge(word, 1L, Long::sum);
				//	//results.merge(word, 1L, (o,n) -> o+n)
				//}
			}
			var sortedEntries = new ArrayList<>(results.entrySet());
			//sortedEntries.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder() ));
			sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
			for (int i = 0; i < Math.min(10, sortedEntries.size()); i++) {
				var entry = sortedEntries.get(i);
				System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}
}
