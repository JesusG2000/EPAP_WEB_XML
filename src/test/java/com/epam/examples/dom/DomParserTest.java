package com.epam.examples.dom;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;

public class DomParserTest {

    @Test
    public void start() throws ParserConfigurationException, SAXException, IOException {
        DomParser parser =new DomParser();
        System.out.println(parser.start("data\\information.xml"));
    }
}