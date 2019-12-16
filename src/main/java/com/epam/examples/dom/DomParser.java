package com.epam.examples.dom;

import com.epam.examples.bean.*;
import com.epam.examples.bean.Package;
import com.epam.examples.bean.tag.*;
import com.epam.examples.validate.Validate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {

    public List<Medicine> start(String dataHolder) throws SAXException, IOException, ParserConfigurationException {
        if (Validate.validate(dataHolder)) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(dataHolder));
            NodeList mainNodeList = document.getElementsByTagName("medicine");
            return mainElements(mainNodeList);
        } else {
            return null;
        }

    }

    private List<Medicine> mainElements(NodeList mainNodeList) {
        List<Medicine> medicineList = new ArrayList<>();
        for (int i = 0; i < mainNodeList.getLength(); i++) {
            Medicine medicine = new Medicine();
            if (mainNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element medicineElement = (Element) mainNodeList.item(i);
                medicine.setId(Integer.parseInt(medicineElement.getAttribute("id")));
                medicineList.add(medicineElements(medicineElement.getChildNodes(), medicine));

            }
        }
        return medicineList;
    }

    private Medicine medicineElements(NodeList medicineNodeList, Medicine medicine) {

        for (int i = 0; i < medicineNodeList.getLength(); i++) {
            if (medicineNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element medicineNodeElement = (Element) medicineNodeList.item(i);
                switch (Tag.getElement(medicineNodeElement.getNodeName())) {
                    case NAME: {
                        medicine.setName(medicineNodeElement.getTextContent());
                        break;
                    }
                    case PHARM: {
                        medicine.setPharm(medicineNodeElement.getTextContent());
                        break;
                    }
                    case GROUP: {
                        medicine.setGroup(medicineNodeElement.getTextContent());
                        break;
                    }
                    case ANALOGS: {
                        medicine.setAnalogs(analogsElements(medicineNodeElement.getChildNodes()));
                        break;
                    }
                    case VERSIONS: {
                        medicine.setVersions(versionsElements(medicineNodeElement.getChildNodes()));
                        break;
                    }
                }
            }
        }
        return medicine;
    }

    private List<Version> versionsElements(NodeList versionsNodeList) {
        List<Version> versions = new ArrayList<>();
        for (int i = 0; i < versionsNodeList.getLength(); i++) {
            if (versionsNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element versionsNodeElement = (Element) versionsNodeList.item(i);
                switch (Tag.getElement(versionsNodeElement.getNodeName())) {
                    case VERSION: {
                        versions.add(versionElements(versionsNodeElement.getChildNodes()));
                        break;
                    }
                }
            }
        }
        return versions;
    }

    private Version versionElements(NodeList versionNodeList) {
        Version version = new Version();
        for (int i = 0; i < versionNodeList.getLength(); i++) {
            if (versionNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element versionNodeElement = (Element) versionNodeList.item(i);
                switch (Tag.getElement(versionNodeElement.getNodeName())) {
                    case TYPE: {
                        version.setType(versionNodeElement.getTextContent());
                        break;
                    }
                    case CERTIFICATE: {
                        Certificate certificate = new Certificate();
                        certificate.setDrugNumber(Integer.parseInt(versionNodeElement.getAttribute("drugNumber")));
                        version.setCertificate(certificateElements(versionNodeElement.getChildNodes(), certificate));
                        break;
                    }
                    case PACKAGE: {
                        version.setMedPackage(medPackageElements(versionNodeElement.getChildNodes()));
                        break;
                    }
                    case DOSAGE: {
                        version.setDosage(dosageElements(versionNodeElement.getChildNodes()));
                        break;
                    }
                }
            }
        }
        return version;
    }

    private Dosage dosageElements(NodeList dosageNodeList) {
        Dosage dosage= new Dosage();
        for (int i = 0; i < dosageNodeList.getLength(); i++) {
            if (dosageNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element dosageNodeElement = (Element) dosageNodeList.item(i);
                switch (Tag.getElement(dosageNodeElement.getNodeName())) {
                    case DOSE: {
                        dosage.setDose(Integer.parseInt(dosageNodeElement.getTextContent()));
                        break;
                    }
                    case FREQUENCY: {
                        dosage.setFrequency(Integer.parseInt(dosageNodeElement.getTextContent()));
                        break;
                    }
                }
            }
        }
        return dosage;
    }

    private Package medPackageElements(NodeList medPackageNodeList) {
        Package medPackage= new Package();
        for (int i = 0; i < medPackageNodeList.getLength(); i++) {
            if (medPackageNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element medPackageNodeElement = (Element) medPackageNodeList.item(i);
                switch (Tag.getElement(medPackageNodeElement.getNodeName())) {
                    case FORM: {
                        medPackage.setForm(medPackageNodeElement.getTextContent());
                        break;
                    }
                    case COUNT: {
                        medPackage.setCount(Integer.parseInt(medPackageNodeElement.getTextContent()));
                       break;
                    }
                    case PRICE: {
                        medPackage.setPrice(Integer.parseInt(medPackageNodeElement.getTextContent()));
                        break;
                    }

                }
            }
        }
        return medPackage;
    }

    private Certificate certificateElements(NodeList certificateNodeList, Certificate certificate) {

        for (int i = 0; i < certificateNodeList.getLength(); i++) {
            if (certificateNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element certificateNodeElement = (Element) certificateNodeList.item(i);

                switch (Tag.getElement(certificateNodeElement.getNodeName())) {
                    case ISSUE: {
                        certificate.setIssue(certificateNodeElement.getTextContent());
                        break;
                    }
                    case EXPIRATION: {
                        certificate.setExpiration(certificateNodeElement.getTextContent());
                        break;
                    }
                    case ORGANIZATION: {
                        certificate.setOrganization(certificateNodeElement.getTextContent());
                        break;
                    }
                }
            }
        }
        return certificate;
    }

    private List<Analog> analogsElements(NodeList analogNodeList) {
        List<Analog> analogs = new ArrayList<>();
        for (int i = 0; i < analogNodeList.getLength(); i++) {
            Analog analog = new Analog();
            if (analogNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element analogNodeElement = (Element) analogNodeList.item(i);
                switch (Tag.getElement(analogNodeElement.getNodeName())) {
                    case ANALOG: {
                        analog.setName(analogNodeElement.getTextContent());
                        break;
                    }
                }
                analogs.add(analog);
            }
        }
        return analogs;
    }
}