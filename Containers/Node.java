package Containers;

/**
 * Created by mashhur on 11/13/16.
 */

public class Node<T> {
    public T data;
    public T key;

    public Node next;

    public Node(T data) {
        this.data = data;
    }

    public Node(T key, T data) {
        this.key = key;
        this.data = data;
    }

    public void add(T data) {
        this.data = data;
    }
}
