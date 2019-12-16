package com.epam.examples.bean.tag;

public enum Tag {
    ANALOG,
    ISSUE,
    EXPIRATION,
    ORGANIZATION,
    DOSE,
    FREQUENCY,
    MEDICINE,
    MEDICINS,
    NAME,
    PHARM,
    GROUP,
    ANALOGS,
    VERSIONS,
    TYPE,
    COUNT,
    PRICE,
    VERSION,
    CERTIFICATE,
    PACKAGE,
    DOSAGE,
    FORM;
    public static  Tag getElement(String element){
        switch (element){
            case "analog":return ANALOG;
            case "issue":return ISSUE;
            case "expiration":return EXPIRATION;
            case "organization":return ORGANIZATION;
            case "dose":return DOSE;
            case "frequency":return FREQUENCY;
            case "medicine":return MEDICINE;
            case "medicins":return MEDICINS;
            case "name":return NAME;
            case "pharm":return PHARM;
            case "group":return GROUP;
            case "analogs":return ANALOGS;
            case "versions":return VERSIONS;
            case "type":return TYPE;
            case "count":return COUNT;
            case "price":return PRICE;
            case "version":return VERSION;
            case "certificate":return CERTIFICATE;
            case "package":return PACKAGE;
            case "dosage":return DOSAGE;
            case "form":return FORM;
            default:
                throw new EnumConstantNotPresentException(Tag.class, element);
        }
    }
}
