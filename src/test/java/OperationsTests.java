import org.junit.Test;

import static org.junit.Assert.*;


public class OperationsTests {

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

    @Test
    public void testMultiply() {
        Rational firstNumber = new Rational(2, 3);
        Rational secondNumber = new Rational(3, 4);
        Rational resultNumber = new Rational(1, 2);
        assertEquals("Product of numbers calculated incorrectly", resultNumber, firstNumber.multiply(secondNumber));

        firstNumber = new Rational(-3, 14);
        secondNumber = new Rational(-2, 5);
        resultNumber = new Rational(3, 35);
        assertEquals("Product of numbers calculated incorrectly", resultNumber, firstNumber.multiply(secondNumber));

        firstNumber = new Rational(4, 25);
        secondNumber = new Rational(-7, 18);
        resultNumber = new Rational(-14, 225);
        assertEquals("Product of numbers calculated incorrectly", resultNumber, firstNumber.multiply(secondNumber));

        firstNumber = new Rational(7, 22);
        secondNumber = new Rational(0, 5);
        resultNumber = new Rational(0, 1);
        assertEquals("Product of numbers calculated incorrectly", resultNumber, firstNumber.multiply(secondNumber));

        firstNumber = new Rational(-13, 28);
        secondNumber = new Rational();
        resultNumber = new Rational(0, 1);
        assertEquals("Product of numbers calculated incorrectly", resultNumber, firstNumber.multiply(secondNumber));

        firstNumber = new Rational();
        secondNumber = new Rational(0, 100);
        resultNumber = new Rational(0, 1);
        assertEquals("Product of numbers calculated incorrectly", resultNumber, firstNumber.multiply(secondNumber));
    }

    @Test
    public void testDivide() {
        Rational firstNumber = new Rational(2, 3);
        Rational secondNumber = new Rational(3, 4);
        Rational resultNumber = new Rational(8, 9);
        assertEquals("Division of numbers calculated incorrectly", resultNumber, firstNumber.divide(secondNumber));

        firstNumber = new Rational(-3, 14);
        secondNumber = new Rational(-2, 9);
        resultNumber = new Rational(27, 28);
        assertEquals("Division of numbers calculated incorrectly", resultNumber, firstNumber.divide(secondNumber));

        firstNumber = new Rational(21, 13);
        secondNumber = new Rational(-1, 2);
        resultNumber = new Rational(-42, 13);
        assertEquals("Division of numbers calculated incorrectly", resultNumber, firstNumber.divide(secondNumber));

        firstNumber = new Rational(-18, 23);
        secondNumber = new Rational(2, 3);
        resultNumber = new Rational(-27, 23);
        assertEquals("Division of numbers calculated incorrectly", resultNumber, firstNumber.divide(secondNumber));

        firstNumber = new Rational();
        secondNumber = new Rational(3, 7);
        resultNumber = new Rational(0, 1);
        assertEquals("Division of numbers calculated incorrectly", resultNumber, firstNumber.divide(secondNumber));

        firstNumber = new Rational(0, 7);
        secondNumber = new Rational(-2, 5);
        resultNumber = new Rational(0, 1);
        assertEquals("Division of numbers calculated incorrectly", resultNumber, firstNumber.divide(secondNumber));
    }

    @Test(expected = ArithmeticException.class)
    public void testDividePositiveByZero() {
        Rational firstNumber = new Rational(2, 3);
        Rational secondNumber = new Rational(0, -4);
        firstNumber.divide(secondNumber);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideNegativeByZero() {
        Rational firstNumber = new Rational(-2, 121);
        Rational secondNumber = new Rational(0, 17);
        firstNumber.divide(secondNumber);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideZeroByZero() {
        Rational firstNumber = new Rational();
        Rational secondNumber = new Rational(0, -4);
        firstNumber.divide(secondNumber);
    }

    @Test
    public void multiFunctions() {
        Rational firstNumber = new Rational(1, 3);
        Rational secondNumber = new Rational(-1, 5);
        Rational thirdNumber = new Rational(5, 6);
        Rational fourthNumber = new Rational(9, 4);
        Rational resultNumber = new Rational(-8, 85);
        assertEquals("Result wrong", resultNumber, (
                firstNumber.plus(secondNumber)).divide(thirdNumber.minus(fourthNumber))
        );

        resultNumber = new Rational(-41, 40);
        assertEquals("Result wrong", resultNumber, (
                firstNumber.minus(thirdNumber)).multiply(secondNumber.plus(fourthNumber))
        );
    }
}
