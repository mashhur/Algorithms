package leetcode.contest.weekly57;

import java.util.*;

/**
 * Created by mashhur on 11/5/17.
 */

public class LongestWord {

    public static void main(String[] args){
        //String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        // output: apple

        //String words[] = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        // output: latte

        //String words[] = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        // output: yodn

        String words[] ={"k","lg","it","oidd","oid","oiddm","kfk","y","mw","kf","l","o","mwaqz","oi","ych","m","mwa"};
        System.out.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word: words)
            wordset.add(word);
        for (String word: words) {
            if (word.length() > ans.length() ||
                    (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }
        }
        return ans;
    }

}
