package codility;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfSubstring {

    public static void main(String args[]) {
        MinimumNumberOfSubstring instance = new MinimumNumberOfSubstring();
        System.out.println(instance.solution("dddd"));
    }

    public int solution(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        return helper(s, 0, 0, new HashSet<>());
    }

    private int helper(String s, int start, int count, Set<Character> memorize) {
        if (start == s.length()) {
            return memorize.size() > 0 ? count + 1 : count;
        }

        if (memorize.contains(s.charAt(start))) {
            memorize.clear();
            count++;
        }

        memorize.add(s.charAt(start));
        start++;
        return helper(s, start, count, memorize);
    }
}
