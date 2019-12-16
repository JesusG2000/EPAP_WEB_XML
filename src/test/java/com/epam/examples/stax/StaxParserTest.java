package com.epam.examples.stax;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

import static org.junit.Assert.*;

public class StaxParserTest {

    @Test
    public void start() throws SAXException, IOException, XMLStreamException {
        StaxParser parser =new StaxParser();
        System.out.println(parser.start("data\\information.xml"));
    }
}