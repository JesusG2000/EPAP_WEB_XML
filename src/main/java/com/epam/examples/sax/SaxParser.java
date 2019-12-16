package com.epam.examples.sax;

import com.epam.examples.bean.Medicine;
import com.epam.examples.dom.DomParser;
import com.epam.examples.validate.Validate;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser {
    private static Logger log = Logger.getLogger(SaxParser.class);
    public List<Medicine> start(String dataHolder) throws SAXException, ParserConfigurationException, IOException {
        if (Validate.validate(dataHolder)) {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            VersionHandler handler = new VersionHandler();
            xmlReader.setContentHandler(handler);
            log.info("Start Sax parser");
            xmlReader.parse(dataHolder);
            List<Medicine> medicineList = handler.getMedicineList();
            log.info(" Document was parsered");
            return medicineList;
        } else {
            log.error(" Document was not parsered");
            return null;
        }
    }

}
