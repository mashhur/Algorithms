package Leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
    int data;
    long time;

    public LRUNode(int data, int time) {
        this.data = data;
        this.time = time;
    }
}

public class LRUCache {

    int capacity = 0;
    Map<Integer, LRUNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        LRUNode node = map.get(key);
        if (node == null)
            return -1;

        node.time = System.nanoTime();
        map.put(key, node);
        return node.data;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            LRUNode node = map.get(key);
            node.data = value;
            node.time =  System.nanoTime();
            map.put(key, node);
        } else {
            if (map.size() >= this.capacity) {
                evict();
            }

            LRUNode node = new LRUNode(value, 0);
            node.time = System.nanoTime();
            map.put(key, node);
        }
    }

    private void evict() {
        int key = 0;
        long min = Long.MAX_VALUE;

        for (Map.Entry<Integer, LRUNode> entry : map.entrySet()) {
            if (min > entry.getValue().time) {
                min = entry.getValue().time;
                key = entry.getKey();
            }
        }

        map.remove(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
