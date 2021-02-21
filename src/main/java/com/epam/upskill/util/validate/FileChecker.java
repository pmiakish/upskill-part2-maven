package com.epam.upskill.util.validate;

import com.epam.upskill.start.FileController;
import java.nio.file.Files;

public class FileChecker {
    public static boolean checkFilesExisting(String[] fileNames) {
        for (String fileName : fileNames) {
            if (Files.notExists(FileController.getDIRECTORY().resolve(fileName))) {
                return false;
            }
        }
        return true;
    }
}
