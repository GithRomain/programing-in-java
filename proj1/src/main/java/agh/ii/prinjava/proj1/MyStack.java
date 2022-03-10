package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

public interface MyStack<E> {

    /** pop remove element from a stack by the start of the stack*/
    E pop();

    /** push add elements to a stack by the start of the stack*/
    void push(E x);

    /** isEmpty return a boolean and say if the stack is empty or not*/
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /** numOfElems return the lenght of the stack*/
    int numOfElems();

    /** peek shows the next element to be pop -> the first one*/
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
