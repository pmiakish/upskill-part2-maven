package com.epam.upskill.util.validate;

import com.epam.upskill.start.FileController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Files;

public class FileChecker {

    private static final Logger LOGGER = LogManager.getLogger(FileChecker.class);

    public static boolean checkFilesExisting(String[] fileNames) {
        LOGGER.trace("FileChecker.checkFilesExisting() is running");
        for (String fileName : fileNames) {
            if (Files.notExists(FileController.getDIRECTORY().resolve(fileName))) {
                LOGGER.warn("{} do not exist!", FileController.getDIRECTORY().resolve(fileName));
                return false;
            }
        }
        LOGGER.debug("All specified files exist");
        return true;
    }
}
