package line;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FindSticks {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sticks[] = scanner.nextLine().split(" ");
        int target = scanner.nextInt();

        Map<Integer, Integer> stickHash = new HashMap<>();
        Map<Integer, Integer> resultHash = new HashMap<>();
        boolean found = false;
        for (String stick: sticks) {
            int stickLength = Integer.parseInt(stick);
            int nextStick = target - stickLength;
            if (stickHash.get(nextStick) != null) {
                // found
                found = true;
                resultHash.put(stickLength, nextStick);
            } else {
                stickHash.put(stickLength, stickLength); // memorize the need value
            }
        }
        if (found == false) {
            System.out.println(-1);
            return;
        }

        analyzeResultSet(resultHash);

    }

    private static void analyzeResultSet(Map<Integer, Integer> resultHash) {
        int minKey = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry: resultHash.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            minKey = Math.min(minKey, entry.getKey());
            minValue = Math.min(minValue, entry.getValue());
        }

        if (minKey <= minValue) {
            System.out.println(minKey + " " + resultHash.get(minKey));
        } else {
            // TODO: memorize min value's key to avoid this loop
            for (Map.Entry<Integer, Integer> entry: resultHash.entrySet()) {
                if (entry.getValue() == minValue) {
                    System.out.println(entry.getValue() + " " + entry.getKey());
                    return;
                }
            }
        }
    }
}