package com.epam.upskill.entity;

import java.util.Objects;

public class QuadraticEquationCoefficientsHolder {

    private double aValue;
    private double bValue;
    private double cValue;

    public QuadraticEquationCoefficientsHolder(double aValue, double bValue, double cValue) {
        this.aValue = aValue;
        this.bValue = bValue;
        this.cValue = cValue;
    }

    public double getAValue() {
        return aValue;
    }

    public void setAValue(double aValue) {
        this.aValue = aValue;
    }

    public double getBValue() {
        return bValue;
    }

    public void setBValue(double bValue) {
        this.bValue = bValue;
    }

    public double getCValue() {
        return cValue;
    }

    public void setCValue(double cValue) {
        this.cValue = cValue;
    }

    @Override
    public String toString() {
        return "QuadraticEquationCoefficientsHolder{" +
                "aValue=" + aValue +
                ", bValue=" + bValue +
                ", cValue=" + cValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuadraticEquationCoefficientsHolder that = (QuadraticEquationCoefficientsHolder) o;
        return Double.compare(that.aValue, aValue) == 0 &&
                Double.compare(that.bValue, bValue) == 0 &&
                Double.compare(that.cValue, cValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aValue, bValue, cValue);
    }
}
