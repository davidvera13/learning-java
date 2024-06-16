package io.warehouse13.learning.step01rename;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RenameFileV2 {
	public static void main(String[] args) {
        Path oldPath = Path.of("students.json");
        Path newPath = Path.of("files/student-activity.json");
        try {
            Files.createDirectories(newPath.subpath(0, newPath.getNameCount() - 1));
            Files.move(oldPath, newPath);
            System.out.println(oldPath + " moved (renamed to) --> " + newPath);
        } catch (IOException e) {
            // If directory doesnt exist:
            // Caused by: java.nio.file.NoSuchFileException: students.json -> files\student-activity.json
            throw new RuntimeException(e);
        }

	}
}

