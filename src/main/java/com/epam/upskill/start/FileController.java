package com.epam.upskill.start;

import com.epam.upskill.service.file.FileWorker;
import com.epam.upskill.util.init.Configuration;
import com.epam.upskill.util.validate.FileChecker;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileController {

    private static final Path DIRECTORY = Paths.get("src/main/resources/files/");
    private static final Path CONFIG = Paths.get("src/main/resources/config.json");
    private static final Logger LOGGER = LogManager.getLogger(FileController.class);

    public static void main(String[] args) {
        LOGGER.trace("The SuffixingApp is running");
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(CONFIG.toString())) {
            JsonReader jsonReader = new JsonReader(fileReader);
            Configuration configuration = gson.fromJson(jsonReader, Configuration.class);
            LOGGER.debug("Read configuration (path={}): {}", CONFIG, configuration);
            String suffix = configuration.getSuffix();
            String[] fileNames = configuration.getFileNames();
            if (FileChecker.checkFilesExisting(fileNames)) {
                System.out.println("All specified files are exist. Ready to work...");
            } else {
                throw new FileNotFoundException("Specified file or files are not found!");
            }
            LOGGER.debug("{} files found in total", fileNames.length);
            for (String fileName : fileNames) {
                FileWorker.renameFile(DIRECTORY.resolve(fileName), DIRECTORY.resolve(suffix.concat(fileName)));
            }
        } catch (IOException ex) {
            LOGGER.error(ex);
            ex.printStackTrace();
        }
        LOGGER.trace("Shutting down the SuffixingApp");
    }

    public static Path getDIRECTORY() {
        return DIRECTORY;
    }
    public static Path getCONFIG() {
        return CONFIG;
    }
}

