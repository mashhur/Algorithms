package Containers;

import sun.awt.Mutex;

/**
 * Created by mashhur on 11/12/16.
 */
public class MyStack<Object> {
    Mutex mutex = new Mutex();
    private Node<Object> root;
    private long nSize = 0;

    public void push(Node node) {
        mutex.lock();
        nSize++;
        if (root == null)
            root = node;
        else {
            Node nCurr = root;
            root = node;
            root.next = nCurr;
        }
        mutex.unlock();
    }

    public Node pop() {
        mutex.lock();
        ;
        if (root == null) return null;

        nSize--;
        Node nRet = root;
        root = root.next;
        System.out.println("Pop node data : " + nRet.data);
        mutex.unlock();
        return nRet;
    }

    public void print() {
        mutex.lock();
        Node nCurr = root;
        while (nCurr != null) {
            System.out.println("Node data : " + nCurr.data);
            nCurr = nCurr.next;
        }
        mutex.unlock();
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public long getSize() {
        System.out.println("Size of my stack is : " + nSize);
        return nSize;
    }
}
