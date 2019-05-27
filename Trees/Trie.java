package Trees;

import java.util.*;

class TrieNode {
    int count;
    Map<Character, TrieNode> children;
}

/* Test case
Input:
    4
    add hack
    add Hackerrank
    find hac
    find hak
Output:
    0
    2
*/

public class Trie {

    private static TrieNode trie = new TrieNode();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = scanner.nextInt();
        scanner.nextLine();

        while (commandCount > 0) {
            commandCount--;

            String[] commands = scanner.nextLine().split(" ");
            if (commands[0].equals("add")) {
                add(0, commands[1].toCharArray(), trie);
            } else if (commands[0].equals("find")) {
                System.out.println(find(0, commands[1].toCharArray(), trie));
            }
        }
        System.out.println(trie);
    }

    private static void add(int index, char[] data, TrieNode trie) {
        if (index >= data.length)
            return;

        if (trie.children == null)
            trie.children = new HashMap<>();

        TrieNode node = trie.children.get(data[index]);
        if (node == null) {
            node = new TrieNode();
            trie.children.put(data[index], node);
        }
        node.count++;
        add(index + 1, data, node);
    }

    private static int find(int index, char[] data, TrieNode trie) {
        if (index >= data.length)
            return trie == null ? 0 : trie.count;

        if (trie == null || trie.children == null)
            return 0;

        return find(index + 1, data, trie.children.get(data[index]));
    }
}
