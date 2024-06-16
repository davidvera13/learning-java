package io.warehouse13.learning.step02copy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFilesAndDeleteV2 {
	public static void main(String[] args) {
        // handling subdirectories
        Path fileDir = Path.of("files");
        Path resourceDir = Path.of("resources");

        try {
            // Not deleting recursively
            // Files.deleteIfExists(resourceDir);
            //if (Files.exists(resourceDir))
            //    Files.delete(resourceDir);
            //Files.copy(fileDir, resourceDir);
            recursiveDelete(resourceDir);
            recursiveCopy(fileDir, resourceDir);
            System.out.println("Directory copied to " + resourceDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // transfer to
        try (
                BufferedReader reader = new BufferedReader(new FileReader("files/student-activity.json"));
                PrintWriter writer = new PrintWriter("students-backup.json")){
            reader.transferTo(writer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void recursiveCopy(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        if (Files.isDirectory(source)) {
            try (var children = Files.list(source)) {
                children.toList().forEach(
                        p -> {
                            try {
                                CopyFilesAndDeleteV2.recursiveCopy(
                                        p, target.resolve(p.getFileName()));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
            }
        }
    }

    public static void recursiveDelete(Path target) throws IOException {

        if (Files.isDirectory(target)) {
            try (var children = Files.list(target)) {
                children.toList().forEach(child -> {
                    try {
                        CopyFilesAndDeleteV2.recursiveDelete(child);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
        Files.delete(target);
    }
}

