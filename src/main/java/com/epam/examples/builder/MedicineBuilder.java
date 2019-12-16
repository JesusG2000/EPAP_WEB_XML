package com.epam.examples.builder;

import com.epam.examples.bean.Analog;
import com.epam.examples.bean.Medicine;
import com.epam.examples.bean.Version;

import java.util.List;

public class MedicineBuilder {
    private int id;
    private String name;
    private String pharm;
    private String group;
    private List<Analog> analogs;
    private List<Version> versions;

    public MedicineBuilder buildId(int id) {
        this.id = id;
        return this;
    }

    public MedicineBuilder buildName(String name) {
        this.name = name;
        return this;
    }

    public MedicineBuilder buildPharm(String pharm) {
        this.pharm = pharm;
        return this;
    }

    public MedicineBuilder buildGroup(String group) {
        this.group = group;
        return this;
    }

    public MedicineBuilder buildAnalogs(List<Analog> analogs) {
        this.analogs = analogs;
        return this;
    }

    public MedicineBuilder buildVersions(List<Version> versions) {
        this.versions = versions;
        return this;
    }
    public Medicine buildMedicine(){
        Medicine medicine =new Medicine();
        medicine.setId(id);
        medicine.setName(name);
        medicine.setGroup(group);
        medicine.setPharm(pharm);
        medicine.setAnalogs(analogs);
        medicine.setVersions(versions);
        return medicine;
    }
}
