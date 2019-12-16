package com.epam.examples.validate;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validate {
    private static Logger log = Logger.getLogger(Validate.class);
    public static boolean validate(String dataWay) throws SAXException {

        SchemaFactory factory1 = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemaLocation = new File("data\\information.xsd");
        Schema schema = factory1.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource(dataWay);
        try {
            validator.validate(source);
            log.info("Validation was successful");
            return true;
        } catch (SAXException | IOException e) {
            log.error("Validation was not successful");
            return false;
        }
    }
}
