package list;

import trees.Trie;
import trees.TrieNode;

import java.util.Map;
import java.util.Scanner;

/*
3
apple
apps
ape
*/

public class LongestCommonPrefix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();

        TrieNode node = new TrieNode();
        while (size > 0) {
            String word = scanner.nextLine();
            if (word.isEmpty() == false)
                Trie.add(0, word.toCharArray(), node);
            size--;
        }
        System.out.println(getLongestPrefix(node).toString());
    }

    private static StringBuilder getLongestPrefix(TrieNode root) {
        if (root == null)
            return null;

        StringBuilder longestPrefix = new StringBuilder();
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            if (max < entry.getValue().count) {
                root = entry.getValue();
                max = root.count;
            }
        }

        while (root.count == max) {
            longestPrefix.append(root.value);
            if (root.children == null)
                break;

            boolean found = false;
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                if (entry.getValue().count == max) {
                    root = entry.getValue();
                    found = true;
                    break;
                }
            }

            if (found == false)
                break;
        }

        return longestPrefix;
    }
}
