package com.epam.upskill.service.quadraticequation;

import com.epam.upskill.entity.QuadraticEquationCoefficientsHolder;

public class RootCalculator {
    public static double[] calculate(QuadraticEquationCoefficientsHolder coefficientsHolder) throws
            IllegalArgumentException {
        if (coefficientsHolder.getAValue() != 0) {
            double discriminant = DiscriminantCalculator.calculate(coefficientsHolder);
            if (discriminant > 0) {
                return findTwoRoots(coefficientsHolder, discriminant);
            } else if (discriminant == 0) {
                return findOneRoot(coefficientsHolder, discriminant);
            } else {
                return null;
            }
        } else {
            throw new IllegalArgumentException("A-value can not be zero!");
        }
    }

    private static double[] findTwoRoots(QuadraticEquationCoefficientsHolder coefficientsHolder, double discriminant) {
        double discriminantSqrt = Math.sqrt(discriminant);
        double divisor = 2 * coefficientsHolder.getAValue();
        double negativeBValue = -coefficientsHolder.getBValue();
        double[] roots = new double[2];
        roots[0] = (negativeBValue + discriminantSqrt) / divisor;
        roots[1] = (negativeBValue - discriminantSqrt) / divisor;
        return roots;
    }

    private static double[] findOneRoot(QuadraticEquationCoefficientsHolder coefficientsHolder, double discriminant) {
        double[] roots = new double[1];
        roots[0] = (-coefficientsHolder.getBValue() + Math.sqrt(discriminant)) / (2 * coefficientsHolder.getAValue());
        return roots;
    }

}
