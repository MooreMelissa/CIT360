/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitexample;

import java.util.Arrays;

/**
 *
 * @author melissamoore
 */
public class Conversion {

    /**
     * requires unit not null and is either C or F ensures if F returns C of
     * temp if C returns F temp if anything else returns entered temp
     *
     * @param temp
     * @param unit
     * @return
     */
    public double tempConversion(double temp, String unit) {
        if (unit.equals("F")) {
            return (temp - 32) * (5.0 / 9.0);
        }
        if (unit.equals("C")) {
            return (temp * (9.0 / 5.0)) + 32;
        } else {
            return temp;
        }
    }

    public Integer Calculate(Integer value1, Integer value2) {
        if (value1 == null || value2 == null) {
            return null;
        }
        Integer sum = value1 + value2;
        return sum;
    }

    public Integer TwoArrays(Integer[] num1, Integer[] num2) {

        if (Arrays.equals(num1, num2)) {
            Integer total = num1[0] + num2[0];
            return total;
        }
        if (num1[0] > num2[0]) {
            Integer total = num1[0] - num2[0];
            return total;
        } else {
            Integer total = num1[0] * num2[0];
            return total;
        }

    }

}
