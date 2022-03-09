package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    @BeforeEach
    void setUp() {
        System.out.println();
        System.out.print("Test");
    }

    @Test
    void test_push()
    {
        // specify the methode tested
        System.out.println(" push");
        System.out.println("Initialized stack : " + stackOfInts);

        // We are enqueuing 1 and verify if it works*/
        System.out.print("Adding 1 to the stack : Supposed result : [1] what we got -> ");
        stackOfInts.push(1);
        System.out.println(stackOfInts);

        // We are enqueuing 2 and verify if it works*/
        System.out.print("Adding 2 to the stack : Supposed result : [2,1] what we got -> ");
        stackOfInts.push(2);
        System.out.println(stackOfInts);

        // We are enqueuing 3 and verify if it works*/
        System.out.print("Adding 3 to the stack : Supposed result : [3,2,1] what we got -> ");
        stackOfInts.push(3);
        System.out.println(stackOfInts);
    }

    /** We are testing removefirst method*/
    @Test
    void test_pop()
    {
        int res = 0;
        // specify the methode tested
        System.out.println(" pop");

        // initialized list
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        System.out.println("Initialized stack : " + stackOfInts);

        // We are pop 3 and verify if it works*/
        System.out.print("pop 3 to the stack : Supposed result : [2,1] what we got -> ");
        res = stackOfInts.pop();
        System.out.println(stackOfInts + " popd element : " + res);

        // We are pop 2 at the first place and verify if it works*/
        System.out.print("pop 2 to the list : Supposed result : [1] what we got -> ");
        res = stackOfInts.pop();
        System.out.println(stackOfInts + " popd element : " + res);

        // We are pop 1 and verify if it works*/
        System.out.print("Removing 1 to the list : Supposed result : [] what we got -> ");
        res = stackOfInts.pop();
        System.out.println(stackOfInts + " dequed element : " + res);
    }

    @Test
    void test_numOfElems()
    {
        // specify the methode tested
        System.out.println(" numOfElems");

        // initialized list
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        stackOfInts.push(4);
        stackOfInts.push(5);
        System.out.println("Initialized stack : " + stackOfInts);

        System.out.println("Number of elements expected : 5 what we got -> " + stackOfInts.numOfElems());
    }

    @Test
    void test_peek()
    {
        // specify the methode tested
        System.out.println(" peek");

        // initialized list
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        stackOfInts.push(4);
        stackOfInts.push(5);
        System.out.println("Initialized stack : " + stackOfInts);

        System.out.println("The first element of the stack should be : 5 what we got -> " + stackOfInts.peek());
        System.out.println("Verify that the stack was not changed : what we got -> " + stackOfInts + " as expected");
    }

    @Test
    void test_isEmpty()
    {
        // specify the methode tested
        System.out.println(" isEmpty");

        System.out.println("Initialized stack : " + stackOfInts);
        System.out.println("Is this stack empty ? : expected : true, what we got -> " + stackOfInts.isEmpty());

        System.out.println("Now we are adding elemnts to the stack :");
        // initialized list
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        System.out.println("Initialized stack : " + stackOfInts);
        System.out.println("Is this stack empty ? : expected : false, what we got -> " + stackOfInts.isEmpty());
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Test end");
        System.out.println();
    }
}