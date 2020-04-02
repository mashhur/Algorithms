package assessments.tmon;

public class Solution {

    public static void main(String args[]) {

        System.out.println(countBits(9));

        int n, m;
        String second = "penpineapple";
        String first = "applepen";

        n = first.length();
        m = second.length();

        System.out.println(lcs(first, second, n, m, ""));
    }

    // lowest common substring
    // Time complexity O(n*m), n: length of first string, m: length of second string
    static String lcs(String first, String second, int i, int j, String common) {

        if (i == 0 || j == 0) {
            return common;
        }

        if (first.charAt(i - 1) == second.charAt(j - 1)) {
            common = lcs(first, second, i - 1, j - 1, second.charAt(j - 1) + common);
        }

        String firstSubstr = lcs(first, second, i, j - 1, "");
        String secondSubstr = lcs(first, second,i - 1, j, "");
        String subStr = firstSubstr.length() > secondSubstr.length() ? firstSubstr : secondSubstr;

        return subStr.length() > common.length() ? subStr : common;
    }

    // calculate 1s count
    public static int countBits(int number) {
        int count = 0;
        while (number != 0) {
            count += (number & 1);
            number = number >>> 1;
        }
        return count;
    }
}
