package agh.ii.prinjava.proj1.impl;

public class DLinkList<E>
{
    /** DlinkedList is a lot of Nodes collapse each other, so attributs is only Node which are linked*/
    private Node<E> node;

    /** Constructor which initialized the first Node at a null Node, it's the property*/
    public DLinkList()
    {
        node = null;
    }

    /** addFirst methode add an element at the first position on the list*/
    public void addFirst(E e)
    {
        // if the list is null, so we created a new node with the value asked
        if (node == null)
        {
            node = new Node<>(e);
            // node.prev = null;
            // node.next = null;
        }
        else
        {
            // else we have to place the index of the node on the first one in the list
            while (node.prev != null)
            {
                // while we are not on the first one, we reached the previous one
                node = node.prev;
            }
            //then we created a new node
            Node<E> stack = new Node<>(e);
            // stack.prev = null;
            // and we linked the new one to the first node in the list
            stack.setNext(node);
            // in each orientation
            node.setPrev(stack);
        }
    }

    /** addLast methode add an element at the last position of the list*/
    public void addLast(E e)
    {
        // if the list is null, so we created a new node with the value asked
        if (node == null)
        {
            node = new Node<>(e);
            // node.prev = null;
            // node.next = null;
        }
        else
        {
            // else we have to place the index of the node on the last one in the list
            while (node.next != null)
            {
                // while we are not on the first one, we reached the previous one
                node = node.next;
            }
            //then we created a new node
            Node<E> stack = new Node<>(e);
            // stack.next = null;
            // and we linked the new one to the last node in the list
            stack.setPrev(node);
            // in each orientation
            node.setNext(stack);
        }
    }

    /** removeFirst remove an element at the first position of the list*/
    public E removeFirst()
    {
        E res = null;
        // we have to place the index of the node on the first one in the list
        while (node.prev != null)
        {
            // while we are not on the first one, we reached the previous one
            node = node.prev;
        }
        res = node.elem;
        // if the list got just one elem -> return empty list
        if (node.prev == null && node.next == null)
        {
            node = null;
        }
        else
        {
            // else we break the linked between head (null) and this node by linking head with nextNode
            node.next.setPrev(node.prev);
            // then we place index in good position
            node = node.next;
        }
        return res;
    }

    /** removeLast remove the last element of the list
     * @return*/
    public E removeLast()
    {
        E res = null;
        // we have to place the index of the node on the last one in the list
        while (node.next != null)
        {
            // while we are not on the first one, we reached the previous one
            node = node.next;
        }
        res = node.elem;
        // if the list got just one elem -> return empty list
        if (node.prev == null && node.next == null)
        {
            node = null;
        }
        else
        {
            // else we break the linked between tail (null) and this node by linking head with previousNode
            node.prev.setNext(node.next);
            // then we place index in good position
            node = node.prev;
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
        else
        {
            //if it's not then we placed the index on the first node to read the list properly
            while (node.prev != null)
            {
                node = node.prev;
            }
            //we add all the next node to our string
            while (node.next != null)
            {
                str += node.elem + ",";
                node = node.next;
            }
            //don't forget to implement the last one
            str += node.elem;
            //and we replace the index on the first node to make tests more easy and fine to see
            while (node.prev != null)
            {
                node = node.prev;
            }
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

        /** Constructor where elem is the value entered and the others Nodes are null and just linked to the node "this"*/
        public Node(T elem)
        {
            this.elem = elem;
            this.next = null;
            this.prev = null;
        }

        /** setters to be more visual and it's usefull*/
        public void setNext(Node<T> next)
        {
            this.next = next;
        }

        public void setPrev(Node<T> prev)
        {
            this.prev = prev;
        }
    }
}
