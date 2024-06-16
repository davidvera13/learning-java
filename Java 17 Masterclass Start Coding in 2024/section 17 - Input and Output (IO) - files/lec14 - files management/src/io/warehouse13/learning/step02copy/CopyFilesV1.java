package io.warehouse13.learning.step02copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFilesV1 {
	public static void main(String[] args) {
        // not copying subfolders
        Path fileDir = Path.of("files");
        Path resourceDir = Path.of("resources");

        try {
            //Files.move(fileDir, resourceDir);
            Files.copy(fileDir, resourceDir);
            System.out.println("Directory copied to " + resourceDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

