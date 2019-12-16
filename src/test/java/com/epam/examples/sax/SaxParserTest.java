package com.epam.examples.sax;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;

public class SaxParserTest {

    @Test
    public void start() throws IOException, SAXException, ParserConfigurationException {
        SaxParser parser =new SaxParser();
        System.out.println(parser.start("data\\information.xml"));
    }
}