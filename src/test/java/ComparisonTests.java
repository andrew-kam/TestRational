import org.junit.Test;

import static org.junit.Assert.*;

public class ComparisonTests {
//
    @Test
    public void testEquals() {
        Rational firstNumber = new Rational(3, 4);
        Rational secondNumber = new Rational(6, 8);
        Rational thirdNumber = new Rational(2, 3);
        assertEquals("Not equivalent", firstNumber, secondNumber);
        assertNotEquals("Equivalent but should not be", secondNumber, thirdNumber);
        firstNumber = new Rational(-5, 3);
        secondNumber = new Rational(-15, 9);
        thirdNumber = new Rational(-3, 4);
        assertEquals("Not equivalent", firstNumber, secondNumber);
        assertNotEquals("Equivalent but should not be", secondNumber, thirdNumber);
        firstNumber = new Rational();
        secondNumber = new Rational(0, -123);
        thirdNumber = new Rational(-8, 7);
        Rational fourthNumber = new Rational(2, 3);
        assertEquals("Not equivalent", firstNumber, secondNumber);
        assertNotEquals("Equivalent but should not be", secondNumber, thirdNumber);
        assertNotEquals("Equivalent but should not be", firstNumber, fourthNumber);
    }

    @Test
    public void testLessPositiveNumbers() {
        Rational firstNumber = new Rational(1, 5);
        Rational secondNumber = new Rational(2, 5);
        Rational thirdNumber = new Rational(2, 3);
        Rational fourthNumber = new Rational(8, 7);
        assertTrue("Not less", firstNumber.less(secondNumber));
        assertFalse("Less but should not be", thirdNumber.less(secondNumber));
        assertTrue("Not less", thirdNumber.less(fourthNumber));
    }

    @Test
    public void testLessNegativeNumbers() {
        Rational firstNumber = new Rational(-5, 7);
        Rational secondNumber = new Rational(-3, 7);
        Rational thirdNumber = new Rational(-3, 4);
        Rational fourthNumber = new Rational(-1, 3);
        assertTrue("Not less", firstNumber.less(secondNumber));
        assertFalse("Less but should not be", thirdNumber.less(secondNumber));
        assertTrue("Not less", thirdNumber.less(fourthNumber));
    }

    @Test
    public void testLessNegativeAndPositiveNumbers() {
        Rational firstNumber = new Rational(-6, 11);
        Rational secondNumber = new Rational(2, 7);
        assertTrue("Not less", firstNumber.less(secondNumber));
    }

    @Test
    public void testLessWithZero() {
        Rational firstNumber = new Rational(0, 11);
        Rational secondNumber = new Rational();
        Rational thirdNumber = new Rational(-6, 11);
        Rational fourthNumber = new Rational(2, 7);
        assertFalse("Less but should not be", firstNumber.less(secondNumber));
        assertTrue("Not less", firstNumber.less(fourthNumber));
        assertTrue("Not less", thirdNumber.less(secondNumber));
    }

    @Test
    public void testLessOrEqualPositive() {
        Rational firstNumber = new Rational(1, 3);
        Rational secondNumber = new Rational(3, 9);
        Rational thirdNumber = new Rational(12, 5);
        assertTrue("Not less or equal", firstNumber.lessOrEqual(secondNumber));
        assertTrue("Not less or equal", firstNumber.lessOrEqual(thirdNumber));
    }

    @Test
    public void testLessOrEqualNegative() {
        Rational firstNumber = new Rational(-6, 8);
        Rational secondNumber = new Rational(-3, 4);
        Rational thirdNumber = new Rational(-1, 2);
        assertTrue("Not less or equal", firstNumber.lessOrEqual(secondNumber));
        assertTrue("Not less or equal", firstNumber.lessOrEqual(thirdNumber));
    }

    @Test
    public void testLessOrEqualNegativeAndPositiveNumbers() {
        Rational firstNumber = new Rational(-5, 12);
        Rational secondNumber = new Rational(3, 7);
        assertTrue("Not less or equal", firstNumber.lessOrEqual(secondNumber));
    }

    @Test
    public void testLessOrEqualWithZero() {
        Rational firstNumber = new Rational(0, -5);
        Rational secondNumber = new Rational();
        Rational thirdNumber = new Rational(-7, 19);
        Rational fourthNumber = new Rational(4, 7);
        assertTrue("Not less or equal", firstNumber.lessOrEqual(secondNumber));
        assertTrue("Not less or equal", firstNumber.lessOrEqual(fourthNumber));
        assertTrue("Not less or equal", thirdNumber.lessOrEqual(secondNumber));
    }
}
