package containers;

import sun.awt.Mutex;

/**
 * Created by mashhur on 11/12/16.
 */
public class MyQueue<Object> {
    Mutex mutex = new Mutex();
    private long nSize = 0;
    private Node<Object> root;
    private Node<Object> tail;

    public void put(Node node) {
        mutex.lock();
        nSize++;
        if (root == null) {
            root = node;
            tail = root;
        } else {
            tail.next = node;
            tail = tail.next;
        }

        System.out.println("Root data : " + root.data);
        System.out.println("Tail data : " + tail.data);
        mutex.unlock();
    }

    public Node pop() {
        mutex.lock();
        if (root == null) return null;

        nSize--;
        Node nRet = root;
        root = root.next;
        System.out.println("Pop node data : " + nRet.data);
        mutex.unlock();
        return nRet;
    }

    public boolean isEmpty() {
        return (root == null);
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

    public long getSize() {
        System.out.println("Size of my queue is : " + nSize);
        return nSize;
    }

}
