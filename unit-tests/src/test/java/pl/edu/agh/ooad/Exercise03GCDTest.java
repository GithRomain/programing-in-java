package pl.edu.agh.ooad;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise03GCDTest {
    @Test
    @DisplayName("Test divided by 0")
    public void testGCDZero()
    {
        //Given
        int a = 5;
        int b = 0;

        //Exception catch expected
        assertThrows(IllegalArgumentException.class, () -> {
            Exercise03GCD.gcd(a, b);
        }, "Exception ");
    }

    @Test
    @DisplayName("Test 0")
    public void testGCDZeroOk()
    {
        //Given
        int a = 0;
        int b = 5;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = b;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd with 1")
    public void testGCDWithOne()
    {
        //Given
        int a = 5;
        int b = 1;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = b;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd with 1 v2")
    public void testGCDWithOneV2()
    {
        //Given
        int a = 1;
        int b = 5;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = a;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd with negative value and one")
    public void testGCDNegativeValueAndOne()
    {
        //Given
        int a = -5;
        int b = 1;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = b;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd with negative value and one v2")
    public void testGCDNegativeValueAndOneV2()
    {
        //Given
        int a = 1;
        int b = -5;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = a;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd first among us and commonn values")
    public void testGCDCommonFirstAmong()
    {
        //Given
        int a = 7;
        int b = 5;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = 1;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd first among us and commonn values v2")
    public void testGCDCommonFirstAmongV2()
    {
        //Given
        int a = 13;
        int b = 99;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = 1;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd non first among common values")
    public void testGCDCommonNonFirstAmong()
    {
        //Given
        int a = 6;
        int b = 12;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = a;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd non first among common values v2")
    public void testGCDCommonNonFirstAmongV2()
    {
        //Given
        int a = 81;
        int b = 9;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = b;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd first among with common negative values")
    public void testGCDCommonNegativeValueFirstAmong()
    {
        //Given
        int a = 13;
        int b = -7;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = 1;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd first among with common negative values v2")
    public void testGCDCommonNegativeValueFirstAmongV2()
    {
        //Given
        int a = -5;
        int b = 8;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = 1;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd first among with common negative values v3")
    public void testGCDCommonNegativeValueFirstAmongV3()
    {
        //Given
        int a = -5;
        int b = -13;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = 1;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd non first among with common negative values")
    public void testGCDCommonNegativeValueNonFirstAmong()
    {
        //Given
        int a = -4;
        int b = -12;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = 4;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd non first among with common negative values v2")
    public void testGCDCommonNegativeValueNonFirstAmongV2()
    {
        //Given
        int a = 2;
        int b = -62;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = a;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test gcd non first among with common negative values v3")
    public void testGCDCommonNegativeValueNonFirstAmongV3()
    {
        //Given
        int a = -42;
        int b = 6;

        //When
        int tested = Exercise03GCD.gcd(a, b);
        int expected = b;

        //Then
        assertEquals(expected, tested);
    }

}
