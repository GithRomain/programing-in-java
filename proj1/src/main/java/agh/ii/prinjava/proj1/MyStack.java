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

    /** Consider pros and cons of having a factory method in the interface
     * pros : it's static so this stack can't be modified even if we applying method to directly to it, one less constructor and it above the classtest to use a constructeur of Dklinsted, the type put it is just defenie by the "MyStack<Integer>, we exactly know what type is it</Integer>
     * cons : it's just a stack not a stackDLLBLimpl, we don't really no what's inisde because we create it like if all is normal, no proper constructor in testclass*/
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
