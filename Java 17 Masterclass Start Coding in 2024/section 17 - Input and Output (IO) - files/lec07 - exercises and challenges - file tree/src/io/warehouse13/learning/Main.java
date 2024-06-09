package io.warehouse13.learning;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
	// summarize the number of Files in a directory.
	// For a bonus, include the summary of the number of subfolders.
	// These numbers should include nested files or folders.

	public static void main(String[] args) {
		Path startingPath = Path.of(".");
		StatsVisitor fileVisitor = new StatsVisitor(Integer.MAX_VALUE);
		try {
			Files.walkFileTree(startingPath, fileVisitor);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}

	public static class StatsVisitor implements FileVisitor<Path> {
	//public static class StatsVisitor extends SimpleFileVisitor<Path> {

		private Path initialPath = null;
		private final Map<Path, Map<String, Long>> folderSizes = new LinkedHashMap<>();
		private int initialCount;

		private int printLevel;

		public static final String DIR_COUNT = "DirCount";
		public static final String FILE_SIZE = "fileSize";
		public static final String FILES_COUNT = "filesCount";

		public StatsVisitor(int printLevel) {
			this.printLevel = printLevel;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {

			Objects.requireNonNull(file);
			Objects.requireNonNull(attrs);
			var parentMap = folderSizes.get(file.getParent());
			if(parentMap != null) {
				long fileSize = attrs.size();
				parentMap.merge(FILE_SIZE, fileSize, Long::sum); // (o, n) -> o+n
				parentMap.merge(FILES_COUNT, 1L, Math::addExact);
			}
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
				folderSizes.put(dir, new HashMap<>());
			}
			return FileVisitResult.CONTINUE;
		}


		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			//return super.visitFileFailed(file, exc);
			Objects.requireNonNull(file);
			if(exc != null)
				System.out.println(exc.getClass().getSimpleName() + " " + file);
			//throw exc;
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
						long size = value.getOrDefault(FILE_SIZE, 0L);
						System.out.printf("%s[%s] - %,d bytes, %d files %d folders %n",
								"\t".repeat(level),
								key.getFileName(),
								size,
								value.getOrDefault(FILES_COUNT, 0L),
								value.getOrDefault(DIR_COUNT, 0L));
					}
				});

			} else {
				var parentMap = folderSizes.get(dir.getParent());
				var childMap = folderSizes.get(dir);
				long folderCount = childMap.getOrDefault(DIR_COUNT, 0L);
				long fileSize = childMap.getOrDefault(FILE_SIZE, 0L);
				long fileCount = childMap.getOrDefault(FILES_COUNT, 0L);
				parentMap.merge(DIR_COUNT, folderCount +1 , Long::sum);
				parentMap.merge(FILE_SIZE, fileSize, Math::addExact);
				parentMap.merge(FILES_COUNT, fileCount, Math::addExact);
			}
			return FileVisitResult.CONTINUE;
		}
	}
}
