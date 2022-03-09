package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts = MyQueue.create();

    @BeforeEach
    void setUp()
    {
        System.out.println();
        System.out.print("Test");
    }

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

        // We are enqueuing 2 and verify if it works*/
        System.out.print("Adding 2 to the queue : Supposed result : [1,2] what we got -> ");
        queueOfInts.enqueue(2);
        System.out.println(queueOfInts);

        // We are enqueuing 3 and verify if it works*/
        System.out.print("Adding 3 to the queue : Supposed result : [1,2,3] what we got -> ");
        queueOfInts.enqueue(3);
        System.out.println(queueOfInts);
    }

    /** We are testing removeLast method*/
    @Test
    void test_dequeue()
    {
        int res = 0;
        // specify the methode tested
        System.out.println(" dequeue");

        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        System.out.println("Initialized queue : " + queueOfInts);

        // We are dequeue 3 and verify if it works*/
        System.out.print("Dequeue 3 to the queue : Supposed result : [1,2] what we got -> ");
        res = queueOfInts.dequeue();
        System.out.println(queueOfInts + " dequeued element : " + res);

        // We are dequeue 2 at the last place and verify if it works*/
        System.out.print("Dequeue 2 to the list : Supposed result : [1] what we got -> ");
        res = queueOfInts.dequeue();
        System.out.println(queueOfInts + " dequeued element : " + res);

        // We are dequeue 1 and verify if it works*/
        System.out.print("Removing 1 to the list : Supposed result : [] what we got -> ");
        res = queueOfInts.dequeue();
        System.out.println(queueOfInts + " dequed element : " + res);
    }

    @Test
    void test_numOfElems()
    {
        // specify the methode tested
        System.out.println(" numOfElems");

        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(4);
        queueOfInts.enqueue(5);
        System.out.println("Initialized queue : " + queueOfInts);

        System.out.println("Number of elements expected : 5 what we got -> " + queueOfInts.numOfElems());
    }

    @Test
    void test_peek()
    {
        // specify the methode tested
        System.out.println(" peek");

        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(4);
        queueOfInts.enqueue(5);
        System.out.println("Initialized queue : " + queueOfInts);

        System.out.println("The last element of the queue should be : 5 what we got -> " + queueOfInts.peek());
        System.out.println("Verify that the queue was not changed : what we got -> " + queueOfInts + " as expected");
    }

    @Test
    void test_isEmpty()
    {
        // specify the methode tested
        System.out.println(" isEmpty");

        System.out.println("Initialized queue : " + queueOfInts);
        System.out.println("Is this queue empty ? : expected : true, what we got -> " + queueOfInts.isEmpty());

        System.out.println("Now we are adding elemnts to the queue :");
        // initialized list
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        System.out.println("Initialized queue : " + queueOfInts);
        System.out.println("Is this queue empty ? : expected : false, what we got -> " + queueOfInts.isEmpty());
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Test end");
        System.out.println();
    }
}