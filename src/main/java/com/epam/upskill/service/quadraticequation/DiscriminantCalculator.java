package com.epam.upskill.service.quadraticequation;

import com.epam.upskill.entity.QuadraticEquationCoefficientsHolder;

public class DiscriminantCalculator {
    public static double calculate(QuadraticEquationCoefficientsHolder coefficientsHolder) {
        return Math.pow(coefficientsHolder.getBValue(), 2.0) - 4.0 * coefficientsHolder.getAValue() *
                coefficientsHolder.getCValue();
    }
}
