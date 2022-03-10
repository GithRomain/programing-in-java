package agh.ii.prinjava.proj1.impl;

public class DLinkList<E>
{
    /** The Actual node / DlinkedList is a lot of Nodes collapse each other, so attribute is only Node which are linked*/
    private Node<E> node;
    /** The first node / DlinkedList is a lot of Nodes collapse each other, so attribute is only Node which are linked*/
    private Node<E> head;
    /** The last node / DlinkedList is a lot of Nodes collapse each other, so attribute is only Node which are linked*/
    private Node<E> tail;

    /** Constructor which initialized the first Node at a null Node, it's the property*/
    public DLinkList()
    {
        node = null;
        head = node;
        tail = node;
    }

    /** addFirst method add an element at the first position on the list*/
    public void addFirst(E e)
    {
        // if the list is null, so we created a new node with the value asked
        if (node == null)
        {
            node = new Node<E>(e);
            head = node;
            tail = node;
        }
        else
        {
            // else we have to place the index of the node on the first one in the list
            node = head;
            //then we created a new node
            Node<E> store = new Node<>(e);
            // and we linked the new one to the first node in the list
            store.setNext(node);
            // in each orientation
            node.setPrev(store);
            head = store;
        }
    }

    /** addLast methode add an element at the last position of the list*/
    public void addLast(E e)
    {
        // if the list is null, so we created a new node with the value asked
        if (node == null)
        {
            node = new Node<>(e);
            head = node;
            tail = node;
        }
        else
        {
            // else we have to place the index of the node on the last one in the list
            node = tail;
            //then we created a new node
            Node<E> store = new Node<>(e);
            // and we linked the new one to the last node in the list
            store.setPrev(node);
            // in each orientation
            node.setNext(store);
            tail = store;
        }
    }

    /** removeFirst remove the first element of the list*/
    public E removeFirst()
    {
        // we call the element removed : "res" and initialized at null
        E res = null;
        // we have to place the index of the node on the first one in the list
        node = head;
        // we take the information of the node and store it in "res"
        res = node.elem;
        // if the list got just one elem -> return empty list
        if (node.prev == null && node.next == null)
        {
            node = null;
            head = node;
            tail = node;
        }
        else
        {
            // else we break the linked between head (null) and this node by linking head with nextNode
            node.next.setPrev(node.prev);
            // then we place index in good position
            head = node.next;
        }
        return res;
    }

    /** removeLast remove the last element of the list*/
    public E removeLast()
    {
        // we call the element removed : "res" and initialized at null
        E res = null;
        // we have to place the index of the node on the last one in the list
        node = tail;
        res = node.elem;
        // if the list got just one elem -> return empty list
        if (node.prev == null && node.next == null)
        {
            node = null;
            head = node;
            tail = node;
        }
        else
        {
            // else we break the linked between tail (null) and this node by linking head with previousNode
            node.prev.setNext(node.next);
            // then we place index in good position
            tail = node.prev;
        }
        return res;
    }

    /** toString methode is to visualise the list properly*/
    @Override
    public String toString() {
        //we started the string
        String str = "[";
        //if the list is null then -> empty list
        if (node == null)
        {
            str += "";
        }
        else if (node != null && node.next == null && node.prev == null)
        {
            str += node.elem;
        }
        else
        {
            //if it's not then we placed the index on the first node to read the list properly
            node = head;
            //we add all the next node to our string
            while (node != tail)
            {
                str += node.elem + ",";
                node = node.next;
            }
            //don't forget to implement the last one
            str += node.elem;
        }
        //we closed the String and send it
        return str + "]";
    }

    /** this static inner class will be used to implement a Node*/
    private static class Node<T> {
        /** a node got an information (elem) a nextNode and a previousNode linked to him*/
        T elem;
        Node<T> prev;
        Node<T> next;

        /** Constructor where elem is the value entered and the others Nodes are null and just linked to this node*/
        public Node(T elem)
        {
            this.elem = elem;
            this.next = null;
            this.prev = null;
        }

        /** setters of the next Node to be more visual and it's usefull*/
        public void setNext(Node<T> next)
        {
            this.next = next;
        }

        /** setters of the previous Node to be more visual and it's usefull*/
        public void setPrev(Node<T> prev)
        {
            this.prev = prev;
        }
    }
}
