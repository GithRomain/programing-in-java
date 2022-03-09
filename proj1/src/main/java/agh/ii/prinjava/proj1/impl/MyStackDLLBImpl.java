package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /** pop remove element from a stack by the start of the stack*/
    @Override
    public E pop() {
        //if stack is empty then we can't retire any element
        if (isEmpty())
        {
            throw new IllegalStateException("Stack is empty");
        }
        else
        {
            //else we removed the last one
            return elems.removeFirst();
        }
    }

    /** push add elements to a stack by the start of the stack*/
    @Override
    public void push(E x) {
        elems.addFirst(x);
        //throw new IllegalStateException("To be implemented");
    }

    /** numOfElems return the lenght of the stack*/
    @Override
    public int numOfElems() {
        //lenght of the string
        int n = elems.toString().length();
        //we found the length of the queue
        return  n - n/2 - 1;

        //throw new IllegalStateException("To be implemented");
    }

    /** peek shows the next elemnent to be pop -> the first one*/
    @Override
    public E peek() {
        E res = null;
        //if stack is empty then we can't show the first element of the stack
        if (isEmpty())
        {
            throw new IllegalStateException("Stack is empty");
        }
        else
        {
            res = elems.removeFirst();
            elems.addFirst(res);
            return res;
        }
    }

    @Override
    public String toString() {
        return elems.toString();
    }
}
