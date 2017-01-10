package Containers;

/**
 * Created by mashhur on 11/13/16.
 */

public class Node<T>{
    public Node(T data){
        this.data = data;
    }

    public void add(T data){
        this.data = data;
    }
    public T data;
    public Node next;
}
