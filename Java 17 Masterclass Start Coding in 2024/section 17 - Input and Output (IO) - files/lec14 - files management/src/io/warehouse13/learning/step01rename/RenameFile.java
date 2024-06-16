package io.warehouse13.learning.step01rename;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RenameFile {
	public static void main(String[] args) {

        // note: create students.json in project root
        // IO way : output result is not used ...
        File oldFile = new File("students.json");
        File newFile = new File("student-activity.json");
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
            System.out.println("File renamed successfully!");
        } else {
            System.out.println("File does not exist!");
        }


        // Using NIO : exception is thrown
        Path oldPath = oldFile.toPath();
        Path newPath = newFile.toPath();
        try {
            Files.move(newPath, oldPath);
            System.out.println(oldPath + " moved (renamed to) --> " + newPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

	}
}

