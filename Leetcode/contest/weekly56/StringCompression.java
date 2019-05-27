package Leetcode.contest.weekly56;

/**
 * Created by mashhur on 10/29/17.
 */
public class StringCompression {

    public static void main(String args[]) {

        // ["a","a","b","b","c","c","c"] -> ["a","2","b","2","c","3"]
        // ["a","b","b","b","b","b","b","b","b","b","b","b","b"] -> ["a","b","1","2"]
        // ["a"] -> ["a"]

        //char arr[] = {'a','a','b','b','c','c','c'};
        //char arr[] = {'a'};
        char arr[] = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(arr));
    }

    public static int compress(char[] chars) {
        int j = 0, curRun = 1, n = chars.length;
        for (int i = 1; i <= n; i++, curRun++) {
            if (i < n && chars[i] == chars[i - 1]) continue;
            chars[j++] = chars[i - 1];
            if (curRun != 1) {
                String s = Integer.toString(curRun);
                for (int k = j; k < j + s.length(); k++) chars[k] = s.charAt(k - j);
                j += s.length();
            }
            curRun = 0;
        }
        return j;
    }
}
