package io.warehouse13.learning;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class MainStream {
	// summarize the number of Files in a directory.
	// For a bonus, include the summary of the number of subfolders.
	// These numbers should include nested files or folders.

	// less performant ...
	public static void main(String[] args) {
		Path startingPath = Path.of(".");
		int index = startingPath.getNameCount();
		try (var paths = Files.walk(startingPath, Integer.MAX_VALUE)) {
			paths
					.filter(Files::isRegularFile)
					.collect(Collectors
							.groupingBy(
									p -> p.subpath(index, index+1),
									Collectors.summarizingLong((p) -> //{
											p.toFile().length()
										//try {
										//	return Files.size(p);
										//} catch (IOException e) {
										//	throw  new RuntimeException(e);
										//}
									//}
									)))
					.entrySet()
					.stream()
					.sorted(Comparator.comparing(e -> e.getKey().toString()))
					//.filter(e -> e.getValue().getSum() > 50_000)
					.forEach((entry) -> {
						System.out.printf("[%s] %,d bytes, %d files %n",
								entry.getKey(),
								entry.getValue().getSum(),
								entry.getValue().getCount());
					});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}