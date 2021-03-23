package com.epam.upskill.util.validate;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class XMLValidator {
    public static void validate(Path pathToXML, Path pathToXSD) throws SAXException, IOException {
        Source xmlSource = new StreamSource(new File(pathToXML.toString()));
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(pathToXSD.toString()));
        Validator validator = schema.newValidator();
        validator.validate(xmlSource);
    }
    public static void validate(DOMSource domSource, Path pathToXSD) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(pathToXSD.toString()));
        Validator validator = schema.newValidator();
        validator.validate(domSource);
    }
}
