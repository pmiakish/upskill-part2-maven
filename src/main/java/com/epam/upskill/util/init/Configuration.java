package com.epam.upskill.util.init;

import java.util.Arrays;

public class Configuration {
    private String suffix;
    private String[] fileNames;
    private String coefficientsPath;

    public Configuration() {
    }
    public String getSuffix() {
        return suffix;
    }
    public String[] getFileNames() {
        return fileNames;
    }
    public String getCoefficientsPath() {
        return coefficientsPath;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "suffix='" + suffix + '\'' +
                ", fileNames=" + Arrays.toString(fileNames) +
                ", coefficientsPath='" + coefficientsPath + '\'' +
                '}';
    }
}
