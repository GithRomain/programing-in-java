package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

import java.awt.image.ImagingOpException;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    /** the queue is assimiled as a DLinkList*/
    private DLinkList<E> elems;

    /** constructor of a queue by creating a new instance of DLinkKist*/
    public MyQueueDLLBImpl()
    {
        elems = new DLinkList<>();
    }

    /** enqueue put the element in last position*/
    @Override
    public void enqueue(E x)
    {
        elems.addLast(x);
    }

    /** dequeue remove the element by the end of the queue*/
    @Override
    public E dequeue() throws IllegalStateException
    {
        //if queue is empty then we can't retire any element
        if (isEmpty())
        {
            throw new IllegalStateException("Queue is empty");
        }
        else
        {
            //else we removed the last one
             return elems.removeLast();
        }
    }

    /** numOfElemns return the lenght of the queue*/
    @Override
    public int numOfElems()
    {
        //lenght of the string
        int n = elems.toString().length();
        //we found the length of the queue
        return  n - n/2 - 1;
    }

    /** peek methode return the last element of the queue (the next to become retired)*/
    @Override
    public E peek() throws IllegalStateException
    {
        // we call the last element : "res" and initialized at null
        E res = null;
        //if queue is empty then we can't show the last element of the queue
        if (isEmpty())
        {
            throw new IllegalStateException("Queue is empty");
        }
        else
        {
            // we are removing the last element and store it to return it
            res = elems.removeLast();
            // and we are adding this element to not change the queue
            elems.addLast(res);
            return res;
        }
    }

    /** toString methode is to visualise the queue properly*/
    @Override
    public String toString() {
        return elems.toString();
    }
}
