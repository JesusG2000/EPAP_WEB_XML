package com.epam.examples.validate;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validate {
    public static boolean validate(String dataWay) throws SAXException {
        SchemaFactory factory1 = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemaLocation = new File("src\\main\\resources\\information.xsd");
        Schema schema = factory1.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource(dataWay);
        try {
            validator.validate(source);
            return true;
        } catch (SAXException | IOException e) {
            return false;
        }
    }
}
