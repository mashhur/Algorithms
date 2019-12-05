package leetcode;

import java.util.HashMap;
import java.util.Map;

class WordProperty {
    boolean banned = false;
    int count;

    public WordProperty(boolean banned, int count) {
        setBanned(banned);
        setCount(count);
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public boolean isBanned() {
        return this.banned;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void incrementCount() {
        this.count++;
    }
}

public class MostCommonWord {
    Map<String, WordProperty> map = new HashMap<>(); // < Word, WordProperty >

    private void check(String key) {
        if (map.containsKey(key) == false) {
            map.put(key, new WordProperty(false, 0));
        } else {
            // increment count if not banned
            WordProperty property = map.get(key);
            if (property.isBanned() == false) {
                property.incrementCount();
            }
        }
    }

    private String getMostCommonWord() {
        String result = "";
        // find max count from map
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, WordProperty> entry : map.entrySet()) {
            WordProperty property = entry.getValue();
            if (property.getCount() > max) {
                max = property.getCount();
                result = entry.getKey();
                System.out.println(result);
            }
        }

        return result;
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        // add banned words into map
        for (String ban : banned) {
            map.put(ban.toLowerCase(), new WordProperty(true, -1));
        }

        char[] array = paragraph.toCharArray();
        StringBuilder word = new StringBuilder();
        for (char ch : array) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                word.append(ch);
            } else {
                String key = word.toString().toLowerCase();
                if (key.isEmpty() == false) {
                    check(key);
                    word = new StringBuilder();
                }
            }
        }

        return getMostCommonWord();
    }
}
