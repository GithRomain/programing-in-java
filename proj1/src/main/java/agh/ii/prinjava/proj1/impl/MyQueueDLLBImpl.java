package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.w3c.dom.Node;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    /** the queue is assimiled as a DLinkList*/
    private DLinkList<E> elems = new DLinkList<>();

    /** to enqueue we have to put the element in last position*/
    @Override
    public void enqueue(E x)
    {
        elems.addLast(x);
        //throw new IllegalStateException("To be implemented");
    }

    /** to dequeue we have to remove element by the end of the queue*/
    @Override
    public E dequeue()
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
    public E peek()
    {
        E res = null;
        //if queue is empty then we can't show the last element of the queue
        if (isEmpty())
        {
            throw new IllegalStateException("Queue is empty");
        }
        else
        {
            res = elems.removeLast();
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
