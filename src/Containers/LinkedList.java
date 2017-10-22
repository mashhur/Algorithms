package Containers;

/**
 * Created by mashhur on 10/22/17.
 */

public class LinkedList {

    Node root;

    // adds node to list, if same key already exists updates its value
    public void put(Node node) {
        if(node == null) return;
        if(root == null) {
            root = node;
            return;
        }

        Node curr_node = root;
        while (curr_node != null) {
            if(curr_node.key == node.key) { // same node
                curr_node.data = node.data;
                return;
            }
            curr_node = curr_node.next;
        }
        curr_node.next = node;
    }

    // get
    public Node get(Object key) {
        Node curr_node = root;
        while (curr_node != null) {
            if(curr_node.key == key)
                return curr_node;
            curr_node = curr_node.next;
        }

        return null;
    }

    // removes node from list
    public void remove(Node node) {
        if(root == node) {
            root = null;
            return;
        }

        Node curr_node = root;
        while (curr_node.next != null) {
            if(curr_node.next.key == node.key) { // same node
                curr_node.next = curr_node.next.next;
            }
        }
    }

    // removes node from list
    public void remove(Object key) {
        if(root.key == key) {
            root = null;
            return;
        }

        Node curr_node = root;
        while (curr_node.next != null) {
            if(curr_node.next.key == key) { // same node
                curr_node.next = curr_node.next.next;
                break;
            }
        }
    }

    // print
    public void print() {
        Node curr_node = root;
        while (curr_node != null) {
            System.out.println("Key: " + curr_node.key + " Value: " + curr_node.data);
            curr_node = curr_node.next;
        }
    }
}
