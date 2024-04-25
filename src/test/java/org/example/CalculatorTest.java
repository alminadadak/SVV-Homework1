/*
    B211202049
    Şüheda Almina Dadak
    https://github.com/alminadadak/SVV-Homework1.git
    Software Verification and Validation - Homework 1
 */

package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.naming.ldap.SortResponseControl;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvSource({"10, 2, 5", "10, 4, 2.5", "12.5f, 5, 2.5f", "12.5f, 2.5f, 5", "10, 2.5f, 4"})
    void dataDrivenDivideTest(float a, float b, float expected){
            Calculator calc = new Calculator();
            assertEquals(expected, calc.divide(a,b));
    }

    @Test
     void testDivision6() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );

        // Optional. To check whether the error messages match.
        assertEquals("Illegal Argument Exception.", exception.getMessage());
    }
}