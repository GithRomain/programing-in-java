package agh.ii.prinjava.lab00.lst00_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @BeforeEach
    void setUp() {
        System.out.println("CalcTest.setup...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("CalcTest.tearDown...");
    }

    @Test
    void add() {
        int a = 1, b = 2;

        assertEquals(3, Calc.add(a,b));
    }
}