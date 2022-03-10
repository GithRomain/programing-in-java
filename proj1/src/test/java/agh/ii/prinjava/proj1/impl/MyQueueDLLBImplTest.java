package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    /** Initialise the queue with the constructor (in the interface)*/
    MyQueue<Integer> queueOfInts = MyQueue.create();

    /** Before every test will say that that the test start and skip a line*/
    @BeforeEach
    void setUp()
    {
        System.out.println();
        System.out.print("Test");
    }

    /** We are testing enqueue method which is adding a last element to the queue*/
    @Test
    void test_enqueue()
    {
        // specify the methode tested
        System.out.println(" enqueue");
        System.out.println("Initialized queue : " + queueOfInts);

        // We are enqueuing 1 and verify if it works*/
        System.out.print("Adding 1 to the queue : Supposed result : [1] what we got -> ");
        queueOfInts.enqueue(1);
        System.out.println(queueOfInts);
//Junit
assertSame(queueOfInts.dequeue(), 1);
        //To not change the list
        queueOfInts.enqueue(1);

        // We are enqueuing 2 and verify if it works*/
        System.out.print("Adding 2 to the queue : Supposed result : [1,2] what we got -> ");
        queueOfInts.enqueue(2);
        System.out.println(queueOfInts);
//Junit
assertSame(queueOfInts.dequeue(), 2);
        //To not change the list
        queueOfInts.enqueue(2);

        // We are enqueuing 3 and verify if it works*/
        System.out.print("Adding 3 to the queue : Supposed result : [1,2,3] what we got -> ");
        queueOfInts.enqueue(3);
        System.out.println(queueOfInts);
//Junit
assertSame(queueOfInts.dequeue(), 3);
        //To not change the list
        queueOfInts.enqueue(3);
    }

    /** We are testing dequeue method which is removing the last element of the queue*/
    @Test
    void test_dequeue()
    {
        // initialized the element removed later
        int res = 0;

        // specify the methode tested
        System.out.println(" dequeue");

        // test the exception case
        try {
            System.out.println("Initialized queue : " + queueOfInts);
            System.out.print("We are trying to dequeue an empty queue, what we got -> ");
            res = queueOfInts.dequeue();
        }
        catch (IllegalStateException illegalStateException)
        {
            System.out.println(illegalStateException);
        }

        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        System.out.println("New initialized queue : " + queueOfInts);

        // We are dequeue 3 and verify if it works*/
        System.out.print("Dequeue 3 to the queue : Supposed result : [1,2] what we got -> ");
        res = queueOfInts.dequeue();
        System.out.println(queueOfInts + " dequeued element : " + res);
//Junit
assertSame(res, 3);

        // We are dequeue 2 at the last place and verify if it works*/
        System.out.print("Dequeue 2 to the list : Supposed result : [1] what we got -> ");
        res = queueOfInts.dequeue();
        System.out.println(queueOfInts + " dequeued element : " + res);
//Junit
assertSame(res, 2);

        // We are dequeue 1 and verify if it works*/
        System.out.print("Removing 1 to the list : Supposed result : [] what we got -> ");
        res = queueOfInts.dequeue();
        System.out.println(queueOfInts + " dequed element : " + res);
//Junit
assertSame(res, 1);
    }

    /** We are testing numOfElemes method which is tell us the number of element in the queue*/
    @Test
    void test_numOfElems()
    {
        // specify the methode tested
        System.out.println(" numOfElems");


        // testing empty queue
        System.out.println("Initialized queue : " + queueOfInts);
        System.out.println("Number of elements expected : 0 what we got -> " + queueOfInts.numOfElems());

        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(4);
        queueOfInts.enqueue(5);
        System.out.println("New Initialized queue : " + queueOfInts);

        System.out.println("Number of elements expected : 5 what we got -> " + queueOfInts.numOfElems());

//Junit
assertSame(queueOfInts.numOfElems(), 5);
    }

    /** We are testing peek method which is tell us the next element to be dequeue in the queue*/
    @Test
    void test_peek()
    {
        // specify the methode tested
        System.out.println(" peek");

        // test the exception case
        try {
            System.out.println("Initialized queue : " + queueOfInts);
            System.out.print("We are trying to peek an empty queue, what we got -> ");
            queueOfInts.peek();
        }
        catch (IllegalStateException illegalStateException)
        {
            System.out.println(illegalStateException);
        }

        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(4);
        queueOfInts.enqueue(5);
        System.out.println("New Initialized queue : " + queueOfInts);

        // we are peeking the element
        System.out.println("The last element of the queue should be : 5 what we got -> " + queueOfInts.peek());
        System.out.println("Verify that the queue was not changed : what we got -> " + queueOfInts + " as expected");

//Junit
assertSame(queueOfInts.peek(), 5);
    }

    /** We are testing isEmpty method which is tell us if the queue is empty or not*/
    @Test
    void test_isEmpty()
    {
        // specify the methode tested
        System.out.println(" isEmpty");

        System.out.println("Initialized queue : " + queueOfInts);
        System.out.println("Is this queue empty ? : expected : true, what we got -> " + queueOfInts.isEmpty());

//Junit
assertSame(queueOfInts.isEmpty(), true);

        System.out.println("Now we are adding elemnts to the queue :");
        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        System.out.println("Initialized queue : " + queueOfInts);
        System.out.println("Is this queue empty ? : expected : false, what we got -> " + queueOfInts.isEmpty());

//Junit
assertSame(queueOfInts.isEmpty(), false);
    }

    /** We are testing toString method which is return the String of the queue to see it properly*/
    @Test
    void test_toString()
    {
        // specify the methode tested
        System.out.println(" toString");

        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        System.out.println("Initialized queue, what we expected : [1,2,3], what we got -> : " + queueOfInts + " : The String is correct");

//Junit
assertTrue(queueOfInts.toString().equals("[1,2,3]"));
    }

    /** After every test will say that the test end and skip a line*/
    @AfterEach
    void tearDown()
    {
        System.out.println("Test end");
        System.out.println();
    }
}
