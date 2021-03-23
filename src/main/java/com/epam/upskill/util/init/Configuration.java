package com.epam.upskill.util.init;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Arrays;

@XmlType(name = "configuration")
@XmlRootElement
public class Configuration {
    @XmlElement(name = "suffix")
    private String suffix;
    @XmlElementWrapper(name = "fileNames")
    @XmlElement(name = "fileName")
    private String[] fileNames;
    @XmlElement(name = "coefficientsPath")
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
