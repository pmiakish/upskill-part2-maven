package com.epam.upskill.start;

import com.epam.upskill.entity.QuadraticEquationCoefficientsHolder;
import com.epam.upskill.service.quadraticequation.RootCalculator;
import com.epam.upskill.util.init.Configuration;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class QuadraticEquationController {

    private static final Path DIRECTORY = Paths.get("src/main/resources/");
    private static final Path CONFIG = DIRECTORY.resolve("config.json");
    private static final int NUMBER_OF_COEFFICIENTS = 3;

    public static void main(String[] args) {
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(CONFIG.toString())) {
            JsonReader jsonReader = new JsonReader(fileReader);
            Configuration configuration = gson.fromJson(jsonReader, Configuration.class);
            Path coefficientsPath = DIRECTORY.resolve(Paths.get(configuration.getCoefficientsPath()));
            if (Files.exists(coefficientsPath)) {
                List<String> coefficientsLines = Files.readAllLines(coefficientsPath);
                for (String coefficientsLine : coefficientsLines) {
                    String[] coefficientsSet = coefficientsLine.split(" ");
                    try {
                        if (coefficientsSet.length == NUMBER_OF_COEFFICIENTS) {
                            QuadraticEquationCoefficientsHolder coefficientsHolder = new
                                    QuadraticEquationCoefficientsHolder(Double.parseDouble(coefficientsSet[0]),
                                    Double.parseDouble(coefficientsSet[1]), Double.parseDouble(coefficientsSet[2]));
                            System.out.println("A, B, C values: " + Arrays.toString(coefficientsSet));
                            double[] roots = RootCalculator.calculate(coefficientsHolder);
                            System.out.println((roots != null) ? "Roots: " + Arrays.toString(roots) + "\n":
                                    "There are no roots!\n");
                        } else {
                            throw new IllegalArgumentException("Number of given values do not equals to number of " +
                                    "coefficients!");
                        }
                    }
                    catch (IllegalArgumentException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                throw new FileNotFoundException("Specified file is not found!");
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
