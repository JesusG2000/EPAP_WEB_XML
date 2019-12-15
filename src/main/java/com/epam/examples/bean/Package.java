package com.epam.examples.bean;

import java.util.Objects;

public class Package {
    private String type;
    private int count;
    private int price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                Objects.equals(type, aPackage.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, count, price);
    }

    @Override
    public String toString() {
        return "Package{" +
                "type='" + type + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
