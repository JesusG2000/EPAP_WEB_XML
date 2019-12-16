package com.epam.examples.bean;

import java.util.Objects;

public class Version {
    private String type;
    private Certificate certificate;
    private Package medPackage;
    private Dosage dosage;

    public Version(){
        certificate =new Certificate();
        medPackage= new Package();
        dosage=new Dosage();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Package getMedPackage() {
        return medPackage;
    }

    public void setMedPackage(Package medPackage) {
        this.medPackage = medPackage;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Version version = (Version) o;
        return Objects.equals(type, version.type) &&
                Objects.equals(certificate, version.certificate) &&
                Objects.equals(medPackage, version.medPackage) &&
                Objects.equals(dosage, version.dosage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, certificate, medPackage, dosage);
    }

    @Override
    public String toString() {
        return "Version{" +
                "type='" + type + '\'' +
                ",certificate=" + certificate +
                ",medPackage=" + medPackage +
                ",dosage=" + dosage +
                "}";
    }
}
