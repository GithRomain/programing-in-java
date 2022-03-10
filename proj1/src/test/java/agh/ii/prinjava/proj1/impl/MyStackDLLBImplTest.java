package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    /** Initialise the stack with the constructor (in the interface)*/
    MyStack<Integer> stackOfInts = MyStack.create();

    /** Before every test will say that that the test start and skip a line*/
    @BeforeEach
    void setUp() {
        System.out.println();
        System.out.print("Test");
    }

    /** We are testing push method which is adding a first element to the queue*/
    @Test
    void test_push()
    {
        // specify the methode tested
        System.out.println(" push");
        System.out.println("Initialized stack : " + stackOfInts);

        // We are pushing 1 and verify if it works*/
        System.out.print("Adding 1 to the stack : Supposed result : [1] what we got -> ");
        stackOfInts.push(1);
        System.out.println(stackOfInts);

        // We are pushing 2 and verify if it works*/
        System.out.print("Adding 2 to the stack : Supposed result : [2,1] what we got -> ");
        stackOfInts.push(2);
        System.out.println(stackOfInts);

        // We are pushing 3 and verify if it works*/
        System.out.print("Adding 3 to the stack : Supposed result : [3,2,1] what we got -> ");
        stackOfInts.push(3);
        System.out.println(stackOfInts);
    }

    /** We are testing pop method which is removing the first element of the queue*/
    @Test
    void test_pop()
    {
        // initialized the element removed later
        int res = 0;
        // specify the methode tested
        System.out.println(" pop");

        // test the exception case
        try {
            System.out.println("Initialized queue : " + stackOfInts);
            System.out.print("We are trying to pop an empty stack, what we got -> ");
            res = stackOfInts.pop();
        }
        catch (IllegalStateException illegalStateException)
        {
            System.out.println(illegalStateException);
        }

        // initialized list
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        System.out.println("New Initialized stack : " + stackOfInts);

        // We are pop 3 and verify if it works*/
        System.out.print("pop 3 to the stack : Supposed result : [2,1] what we got -> ");
        res = stackOfInts.pop();
        System.out.println(stackOfInts + " pop element : " + res);

        // We are pop 2 at the first place and verify if it works*/
        System.out.print("pop 2 to the stack : Supposed result : [1] what we got -> ");
        res = stackOfInts.pop();
        System.out.println(stackOfInts + " pop element : " + res);

        // We are pop 1 and verify if it works*/
        System.out.print("pop 3 to the stack : Supposed result : [] what we got -> ");
        res = stackOfInts.pop();
        System.out.println(stackOfInts + " pop element : " + res);
    }

    /** We are testing numOfElemes method which is tell us the number of element in the stack*/
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

    /** We are testing peek method which is tell us the next element to be pop in the stack*/
    @Test
    void test_peek()
    {
        // specify the methode tested
        System.out.println(" peek");

        // test the exception case
        try {
            System.out.println("Initialized stack : " + stackOfInts);
            System.out.print("We are trying to peek an empty stack, what we got -> ");
            stackOfInts.peek();
        }
        catch (IllegalStateException illegalStateException)
        {
            System.out.println(illegalStateException);
        }

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

    /** We are testing isEmpty method which is tell us if the stack is empty or not*/
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

    /** We are testing toString method which is return the String of the stack to see it properly*/
    @Test
    void test_toString()
    {
        // specify the methode tested
        System.out.println(" toString");

        // initialized list
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        System.out.println("Initialized stack, what we expected : [3,2,1], what we got -> : " + stackOfInts + " : The String is correct");
    }

    /** After every test will say that the test end and skip a line*/
    @AfterEach
    void tearDown()
    {
        System.out.println("Test end");
        System.out.println();
    }
}