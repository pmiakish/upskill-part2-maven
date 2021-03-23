package com.epam.upskill.start;

import com.epam.upskill.entity.QuadraticEquationCoefficientsHolder;
import com.epam.upskill.service.quadraticequation.RootCalculator;
import com.epam.upskill.util.init.ConfigReader;
import com.epam.upskill.util.init.Configuration;
import jakarta.xml.bind.JAXBException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class QuadraticEquationController {

    private static final Path DIRECTORY = Paths.get("src/main/resources/");
    private static final Path CONFIG = DIRECTORY.resolve("config.xml");
    private static final int NUMBER_OF_COEFFICIENTS = 3;

    public static void main(String[] args) {
        try {
            Configuration configuration = Objects.requireNonNull(ConfigReader.read(CONFIG), "Check config path");
            Path coefficientsPath = DIRECTORY.resolve(Paths.get(configuration.getCoefficientsPath()));
            if (Files.exists(coefficientsPath)) {
                List<String> coefficientsLines = Files.readAllLines(coefficientsPath);
                for (int i = 0; i < coefficientsLines.size(); i++) {
                    String[] coefficientsSet = coefficientsLines.get(i).split(" ");
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
                            throw new IllegalArgumentException("In the line #" + i + ", number of given coefficient " +
                                    "values is " + coefficientsSet.length + ", but expected number is " +
                                    NUMBER_OF_COEFFICIENTS + "!");
                        }
                    } catch (IllegalArgumentException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                throw new FileNotFoundException("Specified file is not found!");
            }
        }
        catch (IOException | NullPointerException | JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
