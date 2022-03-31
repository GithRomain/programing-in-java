package pl.edu.agh.ooad;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise04FibonacciTest {

    @Test
    @DisplayName("Test Negative value v2")
    public void testFibonnacciNegativeV2()
    {
        //Given
        int n = -5;

        //Exception catch expected
        assertThrows(IllegalArgumentException.class, () -> {
            Exercise04Fibonacci.fibonacci(n);
        }, "Exception ");
    }

    @Test
    @DisplayName("Test Negative value v3")
    public void testFibonnacciNegativeV3()
    {
        //Given
        int n = -15489;

        //Exception catch expected
        assertThrows(IllegalArgumentException.class, () -> {
            Exercise04Fibonacci.fibonacci(n);
        }, "Exception ");
    }

    @Test
    @DisplayName("Test Negative value")
    public void testFibonnacciNegative()
    {
        //Given
        int n = -1;

        //Exception catch expected
        assertThrows(IllegalArgumentException.class, () -> {
            Exercise04Fibonacci.fibonacci(n);
        }, "Exception ");
    }

    @Test
    @DisplayName("Test Fibonnaci first value")
    public void testFibonacciFirst()
    {
        //Given
        int n = 0;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 0;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Fibonnaci second value")
    public void testFibonacciSecond()
    {
        //Given
        int n = 1;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 1;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Fibonnaci third value")
    public void testFibonacciThird()
    {
        //Given
        int n = 2;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 1;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Fibonnaci fourth value")
    public void testFibonacciFourth()
    {
        //Given
        int n = 3;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 2;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Fibonnaci fifth value")
    public void testFibonacciFifth()
    {
        //Given
        int n = 4;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 3;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Fibonnaci sixth value")
    public void testFibonacciSixth()
    {
        //Given
        int n = 5;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 5;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Fibonnaci common value")
    public void testFibonacciCommon()
    {
        //Given
        int n = 42;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 267914296;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Fibonnaci common value v2")
    public void testFibonacciCommonV2()
    {
        //Given
        int n = 25;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 75025;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Fibonnaci common value v3")
    public void testFibonacciCommonV3()
    {
        //Given
        int n = 10;

        //When
        int tested = Exercise04Fibonacci.fibonacci(n);
        int expected = 55;

        //Then
        assertEquals(expected, tested);
    }
}
