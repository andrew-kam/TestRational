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






}
