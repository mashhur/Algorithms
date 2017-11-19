package cci;

import java.util.*;

/**
 * Created by mashhur on 1/8/17.
 * Point: Hash Table
 */
public class RansomNote {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        HashMap<String, Integer> magazine = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String word = in.next();
            int val = magazine.getOrDefault(word, 0);
            magazine.put(word, val + 1);
        }
        HashMap<String, Integer> ransom = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = in.next();
            ransom.put(word, ransom.getOrDefault(word, 0) + 1);
        }

        Optional<Integer> res = ransom.entrySet().stream()
                .map(e -> magazine.getOrDefault(e.getKey(), 0) - e.getValue())
                .filter(e -> e < 0)
                .findFirst();

        System.out.println(res.isPresent() ? "No" : "Yes");
    }
}
