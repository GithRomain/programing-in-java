package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest
{
    /** Initialise the testlist with the constructor*/
    DLinkList<Integer> dLinkList = new DLinkList<>();

    /** Before every test will say that that the test start and skip a line*/
    @BeforeEach
    void setUp()
    {
        System.out.println();
        System.out.print("Test");
    }

    /** We are testing addFirst methode*/
    @Test
    void test_addFirst()
    {
        // specify the methode tested
        System.out.println(" addFirst");
        System.out.println("Initialized list : " + dLinkList);

        // We are adding 1 at the first place and verify if it works*/
        System.out.print("Adding 1 to the list : Supposed result : [1] what we got -> ");
        dLinkList.addFirst(1);
        System.out.println(dLinkList);

        // We are adding 2 at the first place and verify if it works*/
        System.out.print("Adding 2 to the list : Supposed result : [2,1] what we got -> ");
        dLinkList.addFirst(2);
        System.out.println(dLinkList);

        // We are adding 3 at the first place and verify if it works*/
        System.out.print("Adding 3 to the list : Supposed result : [3,2,1] what we got -> ");
        dLinkList.addFirst(3);
        System.out.println(dLinkList);
    }

    /** We are testing addLast methode*/
    @Test
    void test_addLast()
    {
        // specify the methode tested
        System.out.println(" addLast");
        System.out.println("Initialized list : " + dLinkList);

        // We are adding 1 at the last place and verify if it works*/
        System.out.print("Adding 1 to the list : Supposed result : [1] what we got -> ");
        dLinkList.addLast(1);
        System.out.println(dLinkList);

        // We are adding 2 at the last place and verify if it works*/
        System.out.print("Adding 2 to the list : Supposed result : [1,2] what we got -> ");
        dLinkList.addLast(2);
        System.out.println(dLinkList);

        // We are adding 3 at the last place and verify if it works*/
        System.out.print("Adding 3 to the list : Supposed result : [1,2,3] what we got -> ");
        dLinkList.addLast(3);
        System.out.println(dLinkList);
    }

    /** We are testing removeFirst methode*/
    @Test
    void test_removeFirst()
    {
        int res = 0;
        // specify the methode tested
        System.out.println(" removeFirst");

        // initialized list
        dLinkList.addFirst(1);
        dLinkList.addFirst(2);
        dLinkList.addFirst(3);
        System.out.println("Initialized list : " + dLinkList);

        // We are removing 3 at the first place and verify if it works*/
        System.out.print("Removing 3 to the list : Supposed result : [2,1] what we got -> ");
        res = dLinkList.removeFirst();
        System.out.println(dLinkList + " Removed element : " + res);

        // We are removing 2 at the first place and verify if it works*/
        System.out.print("Removing 2 to the list : Supposed result : [1] what we got -> ");
        res = dLinkList.removeFirst();
        System.out.println(dLinkList + " Removed element : " + res);

        // We are removing 1 at the first place and verify if it works*/
        System.out.print("Removing 1 to the list : Supposed result : [] what we got -> ");
        res = dLinkList.removeFirst();
        System.out.println(dLinkList + " Removed element : " + res);
    }

    /** We are testing removeLast method*/
    @Test
    void test_removeLast()
    {
        int res = 0;
        // specify the methode tested
        System.out.println(" removeLast");

        // initialized list
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        dLinkList.addLast(3);
        System.out.println("Initialized list : " + dLinkList);

        // We are removing 3 at the last place and verify if it works*/
        System.out.print("Removing 3 to the list : Supposed result : [1,2] what we got -> ");
        res = dLinkList.removeLast();
        System.out.println(dLinkList + " Removed element : " + res);

        // We are removing 2 at the last place and verify if it works*/
        System.out.print("Removing 2 to the list : Supposed result : [1] what we got -> ");
        res = dLinkList.removeLast();
        System.out.println(dLinkList + " Removed element : " + res);

        // We are removing 1 at the last place and verify if it works*/
        System.out.print("Removing 1 to the list : Supposed result : [] what we got -> ");
        res = dLinkList.removeLast();
        System.out.println(dLinkList + " Removed element : " + res);
    }

    /** After every test will say that the test end and skip a line*/
    @AfterEach
    void tearDown()
    {
        System.out.println("Test end");
        System.out.println();
    }
}
