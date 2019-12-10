package lv.helloit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator;

    /*
    @BeforeAll - once befroe all tests
    @AfterEach - close documents could be
    @AfterAll
    */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @AfterEach
    void tearDown() {
        // something
    }
    // setUp and tearDown are base names!

    @Test
    @DisplayName("1 + 1 = 2: calculator.add()")
    void onePlusOneShouldBeTwo() {
        int result = calculator.add(1, 1);
        assertEquals(2, result);
//       assert result == 2;
//        if (result != 2) {
//            throw new AssertionError("Wrong test result");
//        }
    }

    @Test
    void minusOnePlusOneShouldBeZero() {
        int result = calculator.add(-1, 1);
        assert result == 0;
    }

    @Test
    void shouldDivide() {
//        BigDecimal bigDecimal = new BigDecimal("6.03");
//        BigDecimal bigDecimalResult = bigDecimal.divide(new BigDecimal("3"), RoundingMode.FLOOR);
//        double result = bigDecimalResult.doubleValue();
//        assertEquals(result, calculator.divide(6.03, 3), "testing calc divide test");
        assertEquals(2.0, calculator.divide(6.0,3.0));
    }

    @Test
    void afterOneCallCounterShouldBeOne() {
        calculator.add(1, 1);
        calculator.add(1, 1);
        calculator.add(1, 1);
        calculator.add(1, 1);
        calculator.add(1, 1);
        calculator.add(1, 1);
        assertEquals(6, calculator.getCounter());
    }
}