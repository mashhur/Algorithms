package hackerrank.contest.RookiRank2;

import java.util.Scanner;

/**
 * Created by mashhur on 2/11/17.
 */

public class HackerRankInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        String sHack = "hackerrank";
        for (int i = 0; i < q; i++) {
            String s = sc.next();
            System.out.println(isMatch(sHack, s) ? "YES" : "NO");
        }
    }

    static boolean isMatch(String hack, String input) {
        int nRevPos = 0;
        for (int i = 0; i < hack.length(); i++) {
            char ch = hack.charAt(i);
            nRevPos = input.indexOf(ch, nRevPos);
            if (nRevPos == -1)
                return false;
            else
                nRevPos++;
        }

        return true;
    }
}
