package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

public interface MyQueue<E> {

    /** enqueue add elements to a queue by the end of the queue*/
    void enqueue(E x);

    /** dequeue remove element from a queue by the the end of the queue*/
    E dequeue();

    /** isEmpty return a boolean and say if the queue is empty or not*/
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /** numOfElems return the lenght of the queue*/
    int numOfElems();

    /** peek shows the next element to be dequeue -> the last one*/
         E peek();

    /** Consider pros and cons of having a factory method in the interface
     * pros : it's static so this queue can't be modified even if we applying method to directly to it, one less constructor and it above the classtest to use a constructeur of Dklinsted, the type put it is just defenie by the "MyQueue<Integer>, we exactly know what type is it</Integer>
     * cons : it's just a queue not a queueDLLBLimpl, we don't really no what's inisde because we create it like if all is normal, no proper constructor in testclass*/
    static <T> MyQueue<T> create()
    {
        return new MyQueueDLLBImpl<>();
    }
}
