package com.epam.upskill.service.file;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileWorker {

    private static final Logger logger = LogManager.getLogger(FileWorker.class);

    public static void renameFile(Path currentName, Path targetName) throws IOException {
        Files.move(currentName, targetName, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(currentName + " -> " + targetName);
        logger.log(Level.INFO, "{} renamed to {}", currentName, targetName);
    }
}
