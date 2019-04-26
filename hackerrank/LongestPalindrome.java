package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mashhur on 2/2/17.
 */

class Palindrome {
    char[] data;
    int start;
    int end;

    Palindrome(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class LongestPalindrome {

    // My Solution: O(N)*O(N) time complexity
    // Optimized solution: Centric approach, find palindrome start with centric position
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chArr = str.toCharArray();

        List<Palindrome> nList = new ArrayList<>();
        for (int i = 0; i < chArr.length; i++) {
            char chStart = chArr[i];
            boolean bFound = false;
            for (int k = chArr.length - 1; k > i; k--) {
                if (chStart == chArr[k]) {
                    if (isPalindrome(chArr, i, k)) {
                        nList.add(new Palindrome(i, k));
                        bFound = true;
                        break;
                    }
                }
            }

            if (bFound) break;
        }

        for (int i = 0; i < nList.size(); i++) {
            System.out.println(chArr[nList.get(i).start] + " " + chArr[nList.get(i).end]);
        }
    }

    // aabcbaa
    static boolean isPalindrome(char[] chArr, int start, int end) {
        boolean bAnagram = false;
        while (start < end) {
            if (chArr[start] != chArr[end])
                break;
            start++;
            end--;
        }

        if (start >= end) bAnagram = true;

        return bAnagram;
    }


    // return book problem
    static void ReturnBook() {
        Scanner sc = new Scanner(System.in);
        int dRet = sc.nextInt();
        int mRet = sc.nextInt();
        int yRet = sc.nextInt();

        int dExpct = sc.nextInt();
        int mExpct = sc.nextInt();
        int yExpct = sc.nextInt();

        System.out.println(getFine(dRet, mRet, yRet, dExpct, mExpct, yExpct));
    }

    static int getFine(int dRet, int mRet, int yRet, int dExpct, int mExpct, int yExpct) {
        int nFine = 0;

        // converting to the day
        int dReturn = (yRet * 12 * 31 - 6) + mRet * 31 + dRet;
        int dExpected = (yExpct * 12 * 31 - 6) + mExpct * 31 + dExpct;
        int nDiff = dReturn - dExpected;

        if (yRet - yExpct > 0)
            return 10000;

        if (nDiff > 30)
            return (nDiff / 30) * 500;

        if (nDiff > 0)
            return nDiff * 15;

        return nFine;
    }

}
