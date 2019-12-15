package com.epam.examples.bean;

import java.util.Objects;

public class Dosage {
    private int dose;
    private int frequency;

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dosage dosage = (Dosage) o;
        return dose == dosage.dose &&
                frequency == dosage.frequency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dose, frequency);
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "dose=" + dose +
                ", frequency=" + frequency +
                '}';
    }
}
