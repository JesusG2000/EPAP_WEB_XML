package com.epam.examples.sax;

import com.epam.examples.bean.Medicine;
import com.epam.examples.validate.Validate;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser {
    public List<Medicine> start(String dataHolder) throws SAXException, ParserConfigurationException, IOException {
        if (Validate.validate(dataHolder)) {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            VersionHandler handler = new VersionHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(dataHolder);

            return handler.getMedicineList();

        } else {
            System.out.println("is not valid");
            return null;
        }
    }

}
