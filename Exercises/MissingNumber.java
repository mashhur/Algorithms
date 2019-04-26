package Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mashhur on 3/4/17.
 */
public class MissingNumber {

    /* test case : 11122333 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sLine = sc.nextLine();
        char[] chArr = sLine.toCharArray();

        if (chArr.length == 0) return;

        Map<Character, Integer> hMap = new HashMap<>();
        Map<Integer, Character> hMapIdx = new HashMap<>();
        hMap.put(chArr[0], 1);
        hMapIdx.put(0, chArr[0]);
        for (int i = 1; i < chArr.length; i++) {
            Integer nCount = hMap.get(chArr[i]);
            if (nCount != null) {
                nCount++;
                hMap.put(chArr[i], nCount);
            } else {
                if (hMap.size() > 1) {
                    Character ch = getMissingNumber(hMap, hMapIdx);
                    if (ch != null) {
                        System.out.println(ch);
                        return;
                    }
                }
                hMap.put(chArr[i], 1);
                hMapIdx.put(hMapIdx.size(), chArr[i]);
            }
        }
    }

    static Character getMissingNumber(Map<Character, Integer> hashMap, Map<Integer, Character> hMapIdx) {
        Character item = null;
        char ch1 = hMapIdx.get(hMapIdx.size() - 2);
        char ch2 = hMapIdx.get(hMapIdx.size() - 1);

        Integer n1 = hashMap.get(ch1);
        Integer n2 = hashMap.get(ch2);

        if (n1 < n2)
            return ch1;
        else if (n1 > n2)
            return ch2;
        else
            return null;
    }
}
