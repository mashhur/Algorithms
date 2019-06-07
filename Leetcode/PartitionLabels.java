package Leetcode;

import java.util.*;

class Position implements Comparable<Position> {
    int count;
    int startPosition = -1;
    int endPosition = -1;

    public Position(int count, int startPosition) {
        this.count = count;
        this.startPosition = startPosition;
    }

    public void increment() {
        this.count++;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    public int compareTo(Position position) {
        if (this.count == position.count) {
            return this.endPosition = position.endPosition;
        }
        return this.count = position.count;
    }
}

public class PartitionLabels {

    Map<Character, Position> map = new HashMap<>();

    public List<Integer> partitionLabels(String S) {
        if (S.length() < 1 || S.length() > 500)
            return null;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (map.containsKey(ch) == true) {
                Position position = map.get(ch);
                position.increment();
                position.setEndPosition(i);
            } else {
                Position position = new Position(1, i);
                map.put(ch, position);
            }
        }

        List<Integer> result = new ArrayList<>();
        PriorityQueue<Position> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Position> entry : map.entrySet()) {
            if (entry.getValue().count > 1) {
                queue.add(entry.getValue());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> list = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        for (int item : list) {
            System.out.print(item + " ");
        }
    }
}
