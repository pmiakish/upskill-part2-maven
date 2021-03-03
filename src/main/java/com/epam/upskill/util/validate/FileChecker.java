package com.epam.upskill.util.validate;

import com.epam.upskill.start.FileController;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Files;

public class FileChecker {

    private static final Logger logger = LogManager.getLogger(FileChecker.class);

    public static boolean checkFilesExisting(String[] fileNames) {
        logger.log(Level.TRACE, "FileChecker.checkFilesExisting() is running");
        for (String fileName : fileNames) {
            if (Files.notExists(FileController.getDIRECTORY().resolve(fileName))) {
                logger.log(Level.WARN, "{} do not exist!", FileController.getDIRECTORY().resolve(fileName));
                return false;
            }
        }
        logger.log(Level.DEBUG, "All specified files exist");
        return true;
    }
}
