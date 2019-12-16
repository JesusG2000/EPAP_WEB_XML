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

    private StringBuilder builder = new StringBuilder();

    List<Medicine> getMedicineList() {
        return medicineList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {


        switch (Tag.valueOf(qName.toUpperCase())) {
            case MEDICINS: {
                medicineList = new ArrayList<>();
                builder.delete(0, builder.length());
                break;
            }
            case MEDICINE: {
                medicine = new Medicine();
                medicine.setId(Integer.parseInt(attributes.getValue("id")));
                builder.delete(0, builder.length());
                break;
            }
            case ANALOGS: {
                analogList = new ArrayList<>();
                builder.delete(0, builder.length());
                break;
            }
            case ANALOG: {
                analog = new Analog();
                builder.delete(0, builder.length());
                break;
            }
            case VERSIONS: {
                versionList = new ArrayList<>();
                builder.delete(0, builder.length());
                break;
            }
            case VERSION: {
                version = new Version();
                builder.delete(0, builder.length());
                break;
            }
            case PACKAGE: {
                medPackage = new Package();
                builder.delete(0, builder.length());
                break;
            }
            case DOSAGE: {
                dosage = new Dosage();
                builder.delete(0, builder.length());
                break;
            }
            case CERTIFICATE: {
                certificate = new Certificate();
                certificate.setDrugNumber(Integer.parseInt(attributes.getValue("drugNumber")));
                builder.delete(0, builder.length());
                break;
            }
            case NAME:
            case PHARM:
            case GROUP:
            case ISSUE:
            case FORM:
            case TYPE:
            case EXPIRATION:
            case ORGANIZATION:
            case COUNT:
            case PRICE:
            case DOSE:
            case FREQUENCY: {
                builder.delete(0, builder.length());
                break;
            }

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (Tag.valueOf(qName.toUpperCase())) {
            case NAME: {
                medicine.setName(builder.toString());
                break;
            }
            case PHARM: {
                medicine.setPharm(builder.toString());
                break;
            }

            case GROUP: {
                medicine.setGroup(builder.toString());
                break;
            }
            case ANALOG: {
                analog.setName(builder.toString());
                analogList.add(analog);
                break;
            }
            case MEDICINE: {
                medicine.setAnalogs(analogList);
                medicine.setVersions(versionList);
                medicineList.add(medicine);
                break;
            }

            case CERTIFICATE: {
                version.setCertificate(certificate);

                break;
            }
            case PACKAGE: {
                version.setMedPackage(medPackage);
                break;
            }
            case DOSAGE: {
                version.setDosage(dosage);
                break;
            }
            case ANALOGS: {
                medicine.setAnalogs(analogList);
                break;
            }
            case VERSIONS: {
                medicine.setVersions(versionList);
                break;
            }
            case VERSION: {
                versionList.add(version);
                break;
            }

            case ISSUE: {
                certificate.setIssue(builder.toString());
                break;
            }
            case EXPIRATION: {
                certificate.setExpiration(builder.toString());
                break;
            }
            case ORGANIZATION: {
                certificate.setOrganization(builder.toString());
                break;
            }
            case COUNT: {
                medPackage.setCount(Integer.parseInt(builder.toString()));
                break;
            }
            case PRICE: {
                medPackage.setPrice(Integer.parseInt(builder.toString()));
                break;
            }
            case FORM: {
                medPackage.setForm(builder.toString());
                break;
            }
            case DOSE: {
                dosage.setDose(Integer.parseInt(builder.toString()));
                break;
            }
            case FREQUENCY: {
                dosage.setFrequency(Integer.parseInt(builder.toString()));
                break;
            }
            case TYPE: {
                version.setType(builder.toString());
                break;
            }
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        builder.append(ch, start, length);
    }
}
