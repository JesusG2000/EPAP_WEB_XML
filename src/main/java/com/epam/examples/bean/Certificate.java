package com.epam.examples.bean;

import java.util.Objects;

public class Certificate {
    private int drugNumber;
    private String issue;
    private String expiration;
    private String organization;

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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return drugNumber == that.drugNumber &&
                Objects.equals(issue, that.issue) &&
                Objects.equals(expiration, that.expiration) &&
                Objects.equals(organization, that.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugNumber, issue, expiration, organization);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "drugNumber=" + drugNumber +
                ", issue='" + issue + '\'' +
                ", expiration='" + expiration + '\'' +
                ", registerOrganization='" + organization + '\'' +
                '}';
    }
}
