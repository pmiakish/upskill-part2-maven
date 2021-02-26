package com.epam.upskill.service.quadraticequation;

import com.epam.upskill.entity.QuadraticEquationCoefficientsHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class RootCalculatorTest {

    private double aValue;
    private double bValue;
    private double cValue;
    private double[] expectedRoots;

    public RootCalculatorTest(double aValue, double bValue, double cValue, double[] expectedRoots) {
        this.aValue = aValue;
        this.bValue = bValue;
        this.cValue = cValue;
        this.expectedRoots = expectedRoots;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, -2.0, -3.0, new double[]{3.0, -1.0}}, // two roots
                {3.0, 5.0, -1.5, new double[]{0.25957, -1.9262}},
                {-2.5, -2.0, 11.0, new double[]{-2.5354, 1.7354}},
                {1.0, 4.0, 4.0, new double[]{-2.0}}, // one root
                {3.0, 6.0, 3.0, new double[]{-1.0}},
                {8.0, -8.0, 2.0, new double[]{0.5}},
                {1.0, 2.0, 12.0, null}, // no roots
                {3.0, 2.0, 4.5, null},
                {-3.0, -2.0, -10.0, null},
                {-3.0, 0.0, 2.5, new double[]{-0.91287, 0.91287}}, // some of coefficients excluding 'a' equal zero
                {-3.0, 7.5, 0.0, new double[]{0.0, 2.5}}
        });
    }

    @Test
    public void shouldFindRoots() {
        QuadraticEquationCoefficientsHolder coefficientsHolder = new QuadraticEquationCoefficientsHolder(aValue, bValue,
                cValue);
        double[] actualRoots = RootCalculator.calculate(coefficientsHolder);
        assertArrayEquals("Failure: roots not found", expectedRoots, actualRoots, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAValueEqualsZero() {
        QuadraticEquationCoefficientsHolder coefficientsHolder = new QuadraticEquationCoefficientsHolder(0.0, 1.0, 1.0);
        RootCalculator.calculate(coefficientsHolder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenAllValuesEqualZero() {
        QuadraticEquationCoefficientsHolder coefficientsHolder = new QuadraticEquationCoefficientsHolder(0.0, 0.0, 0.0);
        RootCalculator.calculate(coefficientsHolder);
    }

}