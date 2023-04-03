import org.junit.Test;
import static org.junit.Assert.*;

public class RationalTest {

//    Блок проверок конструктора класса
    @Test
    public void testDefaultConstructor() {
        Rational defaultNumber = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, defaultNumber.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, defaultNumber.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void testConstructorWithZeroDenominatorAndPositiveNominator() {
        new Rational(1, 0);
    }
    @Test(expected = ArithmeticException.class)
    public void testConstructorWithZeroDenominatorAndNegativeNominator() {
       new Rational(-1, 0);
    }
    @Test(expected = ArithmeticException.class)
    public void testConstructorWithZeroDenominatorAndZeroNominator() {
        new Rational(0, 0);
    }

    @Test
    public void testConstructorWithoutChanges() {
        Rational rationalNumber = new Rational(1, 1);
        assertEquals("Constructor returns wrong numerator", 1, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 1, rationalNumber.getDenominator());
        rationalNumber = new Rational(-2147483648, 2147483647);
        assertEquals("Constructor returns wrong numerator", -2147483648, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 2147483647, rationalNumber.getDenominator());
    }

    @Test
    public void testConstructorWithZeroNominator() {
        Rational rationalNumber = new Rational(0, 21);
        assertEquals("Constructor returns wrong numerator", 0, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 1, rationalNumber.getDenominator());
        rationalNumber = new Rational(0, -37);
        assertEquals("Constructor returns wrong numerator", 0, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 1, rationalNumber.getDenominator());
    }

    @Test
    public void testConstructorWithSimplifyMinuses() {
        Rational rationalNumber = new Rational(2147483647, -1);
        assertEquals("Constructor returns wrong numerator", -2147483647, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 1, rationalNumber.getDenominator());
        rationalNumber = new Rational(-1, -2147483647);
        assertEquals("Constructor returns wrong numerator", 1, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 2147483647, rationalNumber.getDenominator());
    }

    @Test
    public void testConstructorWithReduce() {
        Rational rationalNumber = new Rational(-52, 91);
        assertEquals("Constructor returns wrong numerator", -4, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 7, rationalNumber.getDenominator());
        rationalNumber = new Rational(20, 12);
        assertEquals("Constructor returns wrong numerator", 5, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 3, rationalNumber.getDenominator());
    }

    @Test
    public void testConstructorWithReduceAndSimplifyMinuses() {
        Rational rationalNumber = new Rational(7, -21);
        assertEquals("Constructor returns wrong numerator", -1, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 3, rationalNumber.getDenominator());
        rationalNumber = new Rational(-12, -8);
        assertEquals("Constructor returns wrong numerator", 3, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 2, rationalNumber.getDenominator());
    }

//    Блок проверок сравнений
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

//    Блок математических операций
    @Test
    public void testPlus() {
        Rational firstNumber = new Rational(1, 6);
        Rational secondNumber = new Rational(1, 2);
        Rational resultNumber = new Rational(2, 3);
        assertEquals("Sum calculated incorrectly", resultNumber, firstNumber.plus(secondNumber));
        firstNumber = new Rational(-5, 3);
        secondNumber = new Rational(-3, 8);
        resultNumber = new Rational(-49, 24);
        assertEquals("Sum calculated incorrectly", resultNumber, firstNumber.plus(secondNumber));
        firstNumber = new Rational(5, 6);
        secondNumber = new Rational(-1, 8);
        resultNumber = new Rational(17, 24);
        assertEquals("Sum calculated incorrectly", resultNumber, firstNumber.plus(secondNumber));
        firstNumber = new Rational(13, 6);
        secondNumber = new Rational(0, -5);
        resultNumber = new Rational(13, 6);
        assertEquals("Sum calculated incorrectly", resultNumber, firstNumber.plus(secondNumber));
        firstNumber = new Rational(-2, 5);
        secondNumber = new Rational();
        resultNumber = new Rational(-2, 5);
        assertEquals("Sum calculated incorrectly", resultNumber, firstNumber.plus(secondNumber));
        firstNumber = new Rational(0, 6);
        secondNumber = new Rational(0, -3);
        resultNumber = new Rational(0, 1);
        assertEquals("Sum calculated incorrectly", resultNumber, firstNumber.plus(secondNumber));
    }

    @Test
    public void testMinus() {
        Rational firstNumber = new Rational(2, 3);
        Rational secondNumber = new Rational(13, 15);
        Rational resultNumber = new Rational(-1, 5);
        assertEquals("Difference calculated incorrectly", resultNumber, firstNumber.minus(secondNumber));
        firstNumber = new Rational(-2, 6);
        secondNumber = new Rational(-1, 3);
        resultNumber = new Rational(0, 1);
        assertEquals("Difference calculated incorrectly", resultNumber, firstNumber.minus(secondNumber));
        firstNumber = new Rational(-2, 8);
        secondNumber = new Rational(1, 4);
        resultNumber = new Rational(-1, 2);
        assertEquals("Difference calculated incorrectly", resultNumber, firstNumber.minus(secondNumber));
        firstNumber = new Rational(7, 13);
        secondNumber = new Rational();
        resultNumber = new Rational(7, 13);
        assertEquals("Difference calculated incorrectly", resultNumber, firstNumber.minus(secondNumber));
        firstNumber = new Rational(0, 5);
        secondNumber = new Rational(2, -3);
        resultNumber = new Rational(2, 3);
        assertEquals("Difference calculated incorrectly", resultNumber, firstNumber.minus(secondNumber));
        firstNumber = new Rational(0, -4);
        secondNumber = new Rational(0, 5);
        resultNumber = new Rational(0, 1);
        assertEquals("Difference calculated incorrectly", resultNumber, firstNumber.minus(secondNumber));
    }



}
