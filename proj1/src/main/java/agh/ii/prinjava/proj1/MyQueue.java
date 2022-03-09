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

    /** peek shows the next elemnent to be dequeue -> the last one*/
         E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create()
    {
        return new MyQueueDLLBImpl<>();
    }
}
