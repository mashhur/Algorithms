package ccinterview;

import java.util.*;

/**
 * Created by mashhur on 1/7/17.
 * Main point: StringBuilder
 */
public class Anagram {

    public static int numberNeeded(String first, String second) {
        StringBuilder str_b1 = new StringBuilder(first);
        StringBuilder str_b2 = new StringBuilder(second);

        int nDeleteCnt = 0;
        for (char ch='a'; ch<='z'; ch++){
            int nCount1 = getConsistCount(str_b1, ch);
            int nCount2 = getConsistCount(str_b2, ch);
            System.out.println("String 1: " + ch + " " + nCount1);
            System.out.println("String 2: " + ch + " " + nCount2);

            nDeleteCnt += Math.abs(nCount1 - nCount2);
        }

        return nDeleteCnt;
    }

    private static int getConsistCount(StringBuilder str_b, Character ch){
        int nCount = 0;
        int nRet = 0;
        while (nRet != -1){
            nRet = str_b.indexOf(String.valueOf(ch), nRet);
            if(nRet != -1)
                nCount ++;
            if(nRet != -1) nRet ++;
        }

        return nCount;
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
