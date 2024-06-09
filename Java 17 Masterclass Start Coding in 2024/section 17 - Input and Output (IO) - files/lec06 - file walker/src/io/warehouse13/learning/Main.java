package io.warehouse13.learning;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
	public static void main(String[] args) {
		//Path startingPath = Path.of("..");
		Path startingPath = Path.of(".");

//		StatsVisitor statsVisitor = new StatsVisitor();
//		try {
//			Files.walkFileTree(startingPath, statsVisitor);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}

		StatsVisitorUpdated statsVisitorUpdated = new StatsVisitorUpdated(1);
		try {
			Files.walkFileTree(startingPath, statsVisitorUpdated);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// get the total number of bytes of a folder
	private static class StatsVisitorUpdated extends SimpleFileVisitor<Path> {

		private Path initialPath = null;
		private final Map<Path, Long> folderSizes = new LinkedHashMap<>();
		private int initialCount;

		private int printLevel;

		public StatsVisitorUpdated(int printLevel) {
			this.printLevel = printLevel;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {

			Objects.requireNonNull(file);
			Objects.requireNonNull(attrs);
			folderSizes.merge(file.getParent(), 0L, (o, n) -> o += attrs.size());
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
				throws IOException {

			Objects.requireNonNull(dir);
			Objects.requireNonNull(attrs);

			if (initialPath == null) {
				initialPath = dir;
				initialCount = dir.getNameCount();
			} else {
				int relativeLevel = dir.getNameCount() - initialCount;
				if (relativeLevel == 1) {
					folderSizes.clear();
				}
				folderSizes.put(dir, 0L);
			}
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {

			Objects.requireNonNull(dir);
			if (dir.equals(initialPath)) {
				return FileVisitResult.TERMINATE;
			}

			int relativeLevel = dir.getNameCount() - initialCount;
			if (relativeLevel == 1) {
				folderSizes.forEach((key, value) -> {

					int level = key.getNameCount() - initialCount - 1;
					if (level < printLevel) {
						System.out.printf("%s[%s] - %,d bytes %n",
								"\t".repeat(level), key.getFileName(), value);
					}
				});

			} else {
				long folderSize = folderSizes.get(dir);
				folderSizes.merge(dir.getParent(), 0L, (o, n) -> o += folderSize);
			}
			return FileVisitResult.CONTINUE;
		}
	}

	private static class StatsVisitor extends SimpleFileVisitor<Path> {
		private int level;  // initialized to 0 by default

		@Override
		public FileVisitResult visitFile(
				Path file,
				BasicFileAttributes attrs) {
			//return super.visitFile(file, attrs);
			Objects.requireNonNull(file);
			Objects.requireNonNull(attrs);
			System.out.println("\t".repeat(level + 1) + file.getFileName());
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult preVisitDirectory(
				Path dir,
				BasicFileAttributes attrs) {
			//return super.preVisitDirectory(dir, attrs);
			Objects.requireNonNull(dir);
			Objects.requireNonNull(attrs);
			level++;
			System.out.println("\t".repeat(level) + dir.getFileName());
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(
				Path dir,
				IOException exc) throws IOException {
			//return super.postVisitDirectory(dir, exc);
			Objects.requireNonNull(dir);
			//if (exc != null)
			//	throw exc;
			level--;
			return FileVisitResult.CONTINUE;
		}
	}
}
