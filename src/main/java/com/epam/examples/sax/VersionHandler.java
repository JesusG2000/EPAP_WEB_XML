package com.epam.examples.sax;

import com.epam.examples.bean.Package;
import com.epam.examples.bean.*;
import com.epam.examples.bean.tag.Tag;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class VersionHandler extends DefaultHandler {
    private List<Medicine> medicineList;
    private List<Analog> analogList;
    private List<Version> versionList;
    private Medicine medicine;
    private Version version;
    private Package medPackage;
    private Analog analog;
    private Certificate certificate;
    private Dosage dosage;

    private String currentElement;
    private int medicineId;
    private int drugNumber;

    List<Medicine> getMedicineList() {
        return medicineList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        Tag tag = Tag.valueOf(currentElement.toUpperCase());
        switch (tag) {
            case MEDICINS: {
                medicineList = new ArrayList<>();
                break;
            }
            case MEDICINE: {
                medicine = new Medicine();
                medicine.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            }
            case ANALOGS: {
                analogList = new ArrayList<>();
                break;
            }
            case ANALOG: {
                System.out.println(111);
                analog = new Analog();
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
            case PACKAGE: {
                medPackage = new Package();
                break;
            }
            case CERTIFICATE: {
                certificate = new Certificate();
                certificate.setDrugNumber(Integer.parseInt(attributes.getValue("drugNumber")));
                break;
            }
            default:{

            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (Tag.valueOf(qName.toUpperCase())) {
            case MEDICINE: {
                medicine.setVersions(versionList);
                medicine.setAnalogs(analogList);
                break;
            }
            case ANALOG: {

                analogList.add(analog);
                //analog = null;
                break;
            }
            case VERSION: {
                versionList.add(version);
                //version = null;
                break;
            }
            case CERTIFICATE: {
                version.setCertificate(certificate);
                //certificate = null;
                break;
            }
            case PACKAGE: {
                version.setMedPackage(medPackage);
               // medPackage = null;
                break;
            }
            case DOSAGE: {
                version.setDosage(dosage);
               // dosage = null;
                break;
            }
            default:{

            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        if (!text.contains("<") && currentElement != null) {
            Tag tag = Tag.valueOf(currentElement.toUpperCase());

            switch (tag) {
                case NAME: {
                    medicine.setName(text);
                    break;
                }
                case PHARM: {
                    medicine.setPharm(text);
                    break;
                }
                case GROUP: {
                    medicine.setGroup(text);
                    break;
                }
                case ANALOG: {
                    analog.setName(text);
                    break;
                }
                case ISSUE: {
                    certificate.setIssue(text);
                    break;
                }
                case EXPIRATION: {
                    certificate.setExpiration(text);
                    break;
                }
                case ORGANIZATION: {
                    certificate.setOrganization(text);
                    break;
                }
                case COUNT: {

                    medPackage.setCount(Integer.parseInt(text));
                    break;
                }
                case PRICE: {
                    medPackage.setPrice(Integer.parseInt(text));
                    break;
                }
                case DOSE: {
                    dosage.setDose(Integer.parseInt(text));
                    break;
                }
                case FREQUENCY: {
                    dosage.setFrequency(Integer.parseInt(text));
                    break;
                }
                default:{

                }
            }
        }
    }
}
