/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitexample;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author melissamoore
 */
public class ConversionTest {

    public ConversionTest() {
    }

    @Test
    public void testTempConversion() throws Throwable {
        // Given
        Conversion underTest = new Conversion();

        //When 
        double temp = 80.0;
        String unit = "F";
        double result = underTest.tempConversion(temp, unit);

        // Then assertions for result of method tempConversion(double,String)
        assertEquals(26.67, result, 26.67);

    }

    @Test
    public void testUnitNull() {
        Conversion underTest = new Conversion();

        double result = underTest.tempConversion(30, " ");
        assertTrue(result == 30);
    }

    @Test
    public void testUnitNotForCGiveTemp() {
        // Given
        Conversion underTest = new Conversion();

        //When
        double result = underTest.tempConversion(7, "A");
        assertTrue(result == 7.0);

    }

    @Test
    public void testFalseCaluclate() {
        Conversion underTest = new Conversion();
        assertFalse("This will fail", underTest.Calculate(5, 3) == 9);
    }

    @Test
    public void testAssertTrueTwoArray() {
        Conversion underTest = new Conversion();
        Integer[] num1 = {10, 5, 4};
        Integer[] num2 = {10, 5, 4};
        //assertArrayEquals(num1, num2);
        Integer result = underTest.TwoArrays(num1, num2);
        assertTrue(result == 20);

    }

    @Test
    public void testAssertArrayEqual() {
        Conversion underTest = new Conversion();
        Integer[] num1 = {100, 5, 4};
        Integer[] num2 = {10, 5, 4};
        Integer result = underTest.TwoArrays(num1, num2);
        assertTrue(result == 90);
    }

    @Test
    public void testAssertArrayEquals() {

        Integer[] num1 = {10, 7, 8};
        Integer[] num2 = {10, 7, 8};

        assertArrayEquals("The arrays are Equal", num1, num2);
    }

    @Test
    public void testAssertNotNull() {
        Conversion underTest = new Conversion();

        Integer[] num1 = {10, 6};
        Integer[] num2 = {10};

        assertNotNull("The arrays are not null", underTest.TwoArrays(num1, num2));
    }

    @Test
    public void testAssertNotTheSame() {
        Conversion underTest = new Conversion();
        Integer[] num1 = {10, 7, 8};
        Integer[] num2 = {7, 7, 5, 20};

        assertNotSame("The arrays are not the Same", underTest.TwoArrays(num1, num2));
    }

    @Test
    public void testAssertSame() {

        Integer same[] = {10, 4, 7};
        Integer[] num1 = same;
        Integer[] num2 = same;

        assertSame(num1, num2);
    }

    @Test
    public void testNull() {
        Conversion underTest = new Conversion();

        assertNull("Sum in null", underTest.Calculate(null, null));
    }

    @Test
    public void testAssertThat() {
        Conversion underTest = new Conversion();
        Integer value1 = 5;
        Integer value2 = 2;

        Integer x = underTest.Calculate(value1, value2);
        assertThat(x, is(7));
    }

}
