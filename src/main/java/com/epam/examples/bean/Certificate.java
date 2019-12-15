package com.epam.examples.bean;

import java.util.Objects;

public class Certificate {
    private int drugNumber;
    private String issue;
    private String expiration;
    private String registerOrganization;

    public int getDrugNumber() {
        return drugNumber;
    }

    public void setDrugNumber(int drugNumber) {
        this.drugNumber = drugNumber;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getRegisterOrganization() {
        return registerOrganization;
    }

    public void setRegisterOrganization(String registerOrganization) {
        this.registerOrganization = registerOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return drugNumber == that.drugNumber &&
                Objects.equals(issue, that.issue) &&
                Objects.equals(expiration, that.expiration) &&
                Objects.equals(registerOrganization, that.registerOrganization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugNumber, issue, expiration, registerOrganization);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "drugNumber=" + drugNumber +
                ", issue='" + issue + '\'' +
                ", expiration='" + expiration + '\'' +
                ", registerOrganization='" + registerOrganization + '\'' +
                '}';
    }
}
