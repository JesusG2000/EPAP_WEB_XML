package com.epam.examples.bean;

import java.util.Objects;

public class Analog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Analog analog = (Analog) o;
        return Objects.equals(name, analog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Analog{" +
                "name='" + name + '\'' +
                '}';
    }
}
