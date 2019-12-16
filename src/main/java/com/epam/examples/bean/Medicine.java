package com.epam.examples.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Medicine {
    private int id;
    private String name;
    private String pharm;
    private String group;
    private List<Analog> analogs;
    private List<Version> versions;

    public Medicine() {
        analogs = new ArrayList<>();
        versions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Analog> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(List<Analog> analogs) {
        this.analogs = analogs;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(pharm, medicine.pharm) &&
                Objects.equals(group, medicine.group) &&
                Objects.equals(analogs, medicine.analogs) &&
                Objects.equals(versions, medicine.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pharm, group, analogs, versions);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pharm='" + pharm + '\'' +
                ", group='" + group + '\'' +
                ", analogs=" + analogs +
                ",versions=" + versions +
                "}\n";
    }
}
