package containers;

/**
 * Created by mashhur on 11/13/16.
 */

public class Node<T> {
    public T data;
    public T key;

    public Node<T> next;

    public Node() {
    }

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
