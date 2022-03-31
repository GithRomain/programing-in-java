package pl.edu.agh.ooad;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise05ChangeTest {

    @Test
    @DisplayName("Test change 0")
    public void testChangeZero()
    {
        //Given
        int amount = 0;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,0,0,0,0};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change negative value")
    public void testChangeNegative()
    {
        //Given
        int amount = -10;

        //Exception catch expected
        assertThrows(IllegalArgumentException.class, () -> {
            Exercise05Change.countChanges(amount);
        }, "Exception ");
    }

    @Test
    @DisplayName("Test change 1")
    public void testChangeOne()
    {
        //Given
        int amount = 1;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,0,0,0,1};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 2")
    public void testChangeTwo()
    {
        //Given
        int amount = 2;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,0,0,1,0};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 3")
    public void testChangeThree()
    {
        //Given
        int amount = 3;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,0,0,1,1};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 4 for check if we take the big one numer")
    public void testChangeFour()
    {
        //Given
        int amount = 4;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,0,0,2,0}; //not {0,0,0,0,1,2}

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 5")
    public void testChangeFive()
    {
        //Given
        int amount = 5;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,0,1,0,0};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 8")
    public void testChangeEight()
    {
        //Given
        int amount = 8;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,0,1,1,1};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 10")
    public void testChangeTen()
    {
        //Given
        int amount = 10;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,1,0,0,0};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 18")
    public void testChangeEighteen()
    {
        //Given
        int amount = 18;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,0,1,1,1,1};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 20")
    public void testChangeTewlve()
    {
        //Given
        int amount = 20;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,1,0,0,0,0};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 38")
    public void testChangeThirtyEight()
    {
        //Given
        int amount = 38;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{0,1,1,1,1,1};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 50")
    public void testChangeFifty()
    {
        //Given
        int amount = 50;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{1,0,0,0,0,0};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change 88")
    public void testChangeEightyEight()
    {
        //Given
        int amount = 88;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{1,1,1,1,1,1};

        //Then
        assertArrayEquals(expected, tested);
    }

    @Test
    @DisplayName("Test change classic values")
    public void testChangeClassicValues()
    {
        //Given
        int amount = 128;

        //When
        int[] tested = Exercise05Change.countChanges(amount);
        int[] expected = new int[]{2,1,0,1,1,1};

        //Then
        assertArrayEquals(expected, tested);
    }
}
