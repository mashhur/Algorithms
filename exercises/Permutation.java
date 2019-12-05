package exercises;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        List<String> strList = permute("abc");

        for (String s : strList) {
            System.out.println(s);
        }
    }

    public static List<String> permute(String str) {
        List<String> results = new ArrayList<>();
        permute("", str, results);

        return results;
    }

    public static void permute(String soFar, String rest, List<String> results) {
        //System.out.println("sofar: " + soFar + ", rest: " + rest);
        if (rest.equals("")) {
            //System.out.println(soFar);
            results.add(soFar);
            return;
        } else {
            for (int i = 0; i < rest.length(); i++) {

                String next = soFar + rest.charAt(i);
                String remaining = rest.substring(0, i) + rest.substring(i + 1);
                System.out.println("Next: " + next + ", remain: " + remaining);
                permute(next, remaining, results);
            }
        }
    }
}
