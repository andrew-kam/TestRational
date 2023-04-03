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

}
