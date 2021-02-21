package com.epam.upskill.start;

import com.epam.upskill.service.FileWorker;
import com.epam.upskill.util.init.Configuration;
import com.epam.upskill.util.validate.FileChecker;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileController {

    private static final Path DIRECTORY = Paths.get("src/main/resources/");
    private static final Path CONFIG = DIRECTORY.resolve("config.json");

    public static void main(String[] args) {
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(CONFIG.toString())) {
            JsonReader jsonReader = new JsonReader(fileReader);
            Configuration configuration = gson.fromJson(jsonReader, Configuration.class);
            String suffix = configuration.getSuffix();
            String[] fileNames = configuration.getFileNames();
            if (FileChecker.checkFilesExisting(fileNames)) {
                System.out.println("All specified files are exist. Ready to work...");
            } else {
                throw new FileNotFoundException("Specified file or files not found!");
            }
            for (String fileName : fileNames) {
                FileWorker.renameFile(DIRECTORY.resolve(fileName), DIRECTORY.resolve(suffix.concat(fileName)));
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Path getDIRECTORY() {
        return DIRECTORY;
    }
    public static Path getCONFIG() {
        return CONFIG;
    }
}

