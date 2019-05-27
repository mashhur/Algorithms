package Hackerrank;

import java.util.Scanner;

/**
 * Created by mashhur on 2/9/17.
 */

class NodeLL {
    int data;
    NodeLL next;

    NodeLL(int data, NodeLL next) {
        this.data = data;
        this.next = next;
    }
}

public class ReverseLinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NodeLL root = new NodeLL(0, null);
        NodeLL nCurr = root;
        for (int i = 1; i <= 10; i++) {
            nCurr.next = new NodeLL(i, null);
            nCurr = nCurr.next;
        }
        NodeLL newRoot = makeReverseLL(root);
        print(newRoot);
    }

    // reverse LinkedList
    static NodeLL makeReverseLL(NodeLL root) {
        if (root == null) return null;
        NodeLL newCurr = null;
        while (root != null) {
            if (newCurr == null) {
                newCurr = new NodeLL(root.data, root.next);
                newCurr.next = null;
            } else {
                NodeLL newNode = new NodeLL(root.data, root.next);
                newNode.next = newCurr;
                newCurr = newNode;
            }

            root = root.next;
        }

        return newCurr;
    }

    static void print(NodeLL root) {
        if (root == null) return;
        ;
        NodeLL nCurr = root;
        while (nCurr != null) {
            System.out.println(nCurr.data);
            nCurr = nCurr.next;
        }
    }
}
