package com.epam.examples.stax;

import com.epam.examples.bean.Package;
import com.epam.examples.bean.*;
import com.epam.examples.bean.tag.Tag;
import com.epam.examples.validate.Validate;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StaxParser {

    private List<Medicine> medicineList;
    private List<Analog> analogList;
    private List<Version> versionList;
    private Medicine medicine;
    private Version version;
    private Package medPackage;
    private Analog analog;
    private Certificate certificate;
    private Dosage dosage;

    public List<Medicine> start(String dataHolder) throws SAXException, IOException, XMLStreamException {
        if (Validate.validate(dataHolder)) {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(dataHolder));
            return mainElements(xmlEventReader);

        } else {
            return null;
        }
    }

    private List<Medicine> mainElements(XMLEventReader xmlEventReader) throws XMLStreamException {


        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                switch (Tag.getElement(startElement.getName().getLocalPart())) {
                    case MEDICINS: {
                        medicineList = new ArrayList<>();
                        break;
                    }
                    case MEDICINE: {
                        medicine = new Medicine();
                        Attribute attribute = startElement.getAttributeByName(new QName("id"));
                        medicine.setId(Integer.parseInt(attribute.getValue()));
                        break;
                    }
                    case NAME: {
                        medicine.setName(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case PHARM: {
                        medicine.setPharm(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case GROUP: {
                        medicine.setGroup(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case ANALOGS: {
                        analogList = new ArrayList<>();
                        break;
                    }
                    case ANALOG: {
                        analog = new Analog();
                        analog.setName(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case VERSIONS: {
                        versionList = new ArrayList<>();
                        break;
                    }
                    case VERSION: {
                        version = new Version();
                        break;
                    }
                    case TYPE: {
                        version.setType(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case CERTIFICATE: {
                        certificate = new Certificate();
                        Attribute attribute = startElement.getAttributeByName(new QName("drugNumber"));
                        certificate.setDrugNumber(Integer.parseInt(attribute.getValue()));
                        break;
                    }
                    case ISSUE: {
                        certificate.setIssue(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case EXPIRATION: {
                        certificate.setExpiration(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case ORGANIZATION: {
                        certificate.setOrganization(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case PACKAGE: {
                        medPackage = new Package();
                        break;
                    }
                    case FORM: {
                        medPackage.setForm(xmlEventReader.nextEvent().asCharacters().getData());
                        break;
                    }
                    case COUNT: {
                        medPackage.setCount(Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData()));
                        break;
                    }
                    case PRICE: {
                        medPackage.setPrice(Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData()));
                        break;
                    }
                    case DOSAGE: {
                        dosage = new Dosage();
                        break;
                    }
                    case DOSE: {
                        dosage.setDose(Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData()));
                        break;
                    }
                    case FREQUENCY: {
                        dosage.setFrequency(Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData()));
                        break;
                    }
                }
            }
            if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();
                switch (Tag.getElement(endElement.getName().getLocalPart())) {
                    case MEDICINE: {
                        medicine.setVersions(versionList);
                        medicine.setAnalogs(analogList);
                        medicineList.add(medicine);
                        break;
                    }
                    case ANALOG: {
                        analogList.add(analog);
                        break;
                    }
                    case VERSION: {
                        version.setDosage(dosage);
                        version.setMedPackage(medPackage);
                        version.setCertificate(certificate);
                        versionList.add(version);
                        break;
                    }
                }
            }
        }
        return medicineList;
    }

}