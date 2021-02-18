package com.epam.upskill.util.init;

import java.util.Arrays;

public class Configuration {
    private String suffix;
    private String[] fileNames;

    public Configuration() {
    }

    public String getSuffix() {
        return suffix;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "suffix='" + suffix + '\'' +
                ", fileNames=" + Arrays.toString(fileNames) +
                '}';
    }
}
