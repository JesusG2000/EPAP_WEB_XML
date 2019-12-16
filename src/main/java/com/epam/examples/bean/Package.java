package com.epam.examples.bean;

import java.util.Objects;

public class Package {
    private String form;
    private int count;
    private int price;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return count == aPackage.count &&
                price == aPackage.price &&
                Objects.equals(form, aPackage.form);
    }

    @Override
    public int hashCode() {
        return Objects.hash(form, count, price);
    }

    @Override
    public String toString() {
        return "Package{" +
                "form='" + form + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
