package containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mashhur on 1/31/17.
 */

public class DuplicateLinkedList {

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        //Write your code here
        if (head == null) return null;
        if (head.next == null) return head;

        Node<Integer> nCurr = head;
        List<Integer> nList = new ArrayList<>();
        nList.add(head.data);
        while (nCurr.next != null) {
            if (nList.contains(nCurr.next.data)) {
                // remove node
                Node<Integer> delNode = nCurr.next;
                nCurr.next = delNode.next;
                if (nCurr.next == null)
                    break;
                else
                    continue;
            } else
                nList.add(nCurr.next.data);
            nCurr = nCurr.next;
        }

        return head;
    }

    public static Node<Integer> insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);
    }
}
