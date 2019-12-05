package leetcode;

import java.util.HashMap;

// Definition for a Node.
class Node {

    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Input:
    {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
    Node 1's value is 1, both of its next and random pointer points to Node 2.
    Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */

public class CopyListWithRandomPointer {

    HashMap<Integer, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head != null) {
            Node clonedHead = new Node(head.val, null, null);
            map.put(clonedHead.val, clonedHead);
            clonedHead.next = copyRandomList(head.next);
            if (head.random != null)
                clonedHead.random = map.get(head.random.val);
            return clonedHead;
        }

        return null;
    }
}
