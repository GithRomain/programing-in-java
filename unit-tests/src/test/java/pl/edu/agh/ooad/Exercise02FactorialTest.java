package pl.edu.agh.ooad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise02FactorialTest {


    @Test
    @DisplayName("Test fact 0")
    public void testFactZero()
    {
        int i;
        int test_i;
        int expectedValue = 1;

        Given:
        i = 0;

        When:
        test_i = Exercise02Factorial.factorial(i);

        Then:
        assertEquals(expectedValue, test_i);
    }

    @Test
    @DisplayName("Test fact 1")
    public void testFactOne()
    {
        int i;
        int test_i;
        int expectedValue = 1;

        Given:
        i = 1;

        When:
        test_i = Exercise02Factorial.factorial(i);

        Then:
        assertEquals(expectedValue, test_i);
    }

    @Test
    @DisplayName("Test fact positive small")
    public void testFactPositiveValueSmall()
    {
        int i;
        int test_i;
        int expectedValue = 120;

        Given:
        i = 5;

        When:
        test_i = Exercise02Factorial.factorial(i);

        Then:
        assertEquals(expectedValue, test_i);
    }

    @Test
    @DisplayName("Test fact positive big")
    public void testFactPositiveValueBig()
    {
        int i;
        int test_i;
        int expectedValue = 3628800;

        Given:
        i = 10;

        When:
        test_i = Exercise02Factorial.factorial(i);

        Then:
        assertEquals(expectedValue, test_i);
    }

    @Test
    @DisplayName("Test fact positive big")
    public void testFactNegativeValue()
    {
        int i;
        int test_i;


        Given:
        i = -5;

        When:
        test_i = Exercise02Factorial.factorial(i);

        Then:
        assertThrows(IllegalArgumentException.class, () -> {
            Exercise02Factorial.factorial(i);
        }, "IllegalArgumentException");
    }
}
