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
        Rational rationalNumber = new Rational(1, 0);
    }
    @Test(expected = ArithmeticException.class)
    public void testConstructorWithZeroDenominatorAndNegativeNominator() {
       Rational rationalNumber = new Rational(-1, 0);
    }
    @Test(expected = ArithmeticException.class)
    public void testConstructorWithZeroDenominatorAndZeroNominator() {
        Rational rationalNumber = new Rational(0, 0);
    }

    @Test
    public void testConstructorWithValidArguments() {
        Rational rationalNumber = new Rational(1, 1);
        assertEquals("Constructor returns wrong numerator", 1, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 1, rationalNumber.getDenominator());
        rationalNumber = new Rational(-2147483648, 2147483647);
        assertEquals("Constructor returns wrong numerator", -2147483648, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 2147483647, rationalNumber.getDenominator());

        rationalNumber = new Rational(2, -1);
        assertEquals("Constructor returns wrong numerator", -2, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 1, rationalNumber.getDenominator());
        rationalNumber = new Rational(-1, -2);
        assertEquals("Constructor returns wrong numerator", 1, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 2, rationalNumber.getDenominator());

        rationalNumber = new Rational(0, 21);
        assertEquals("Constructor returns wrong numerator", 0, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 1, rationalNumber.getDenominator());
        rationalNumber = new Rational(0, -37);
        assertEquals("Constructor returns wrong numerator", 0, rationalNumber.getNumerator());
        assertEquals("Constructor returns wrong denominator", 1, rationalNumber.getDenominator());
    }











}
