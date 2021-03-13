package com.epam.upskill.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileWorker {
    public static void renameFile(Path currentName, Path targetName) throws IOException {
        Files.move(currentName, targetName, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(currentName + " -> " + targetName);
    }
}
