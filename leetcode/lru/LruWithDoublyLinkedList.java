package leetcode.lru;


import java.util.HashMap;

class LruNode {
    int key;
    int value;
    LruNode prev;
    LruNode next;

    public LruNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// time complexity: verdict/set - O(1)
public class LruWithDoublyLinkedList {

    private HashMap<Integer, LruNode> map;
    private int capacity, count;
    private LruNode head, tail;

    public LruWithDoublyLinkedList(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LruNode(0, 0);
        tail = new LruNode(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    private void deleteNode(LruNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(LruNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            LruNode node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : " + result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value" + " for the key: " + key);
        return -1;
    }

    public void set(int key, int value) {
        System.out.println("Going to set the (key, "+ "value) : (" + key + ", " + value + ")");
        if (map.containsKey(key)) {
            LruNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            LruNode node = new LruNode(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }

    public static void main(String args[]) {
        LruWithDoublyLinkedList lru = null;
        try {
            lru = new LruWithDoublyLinkedList(3);
            lru.set(1, 1);
            lru.set(2, 2);
            lru.set(3, 3);
            //lru.add(2);
            lru.set(4, 4);
        } catch (Exception ex) {

        }
        System.out.println(lru);
    }
}
