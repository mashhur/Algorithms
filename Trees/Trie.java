package Trees;

import java.util.*;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = scanner.nextInt();
        scanner.nextLine();

        TrieNode trieNode = new TrieNode();
        Trie trie = new Trie();

        while (commandCount > 0) {
            commandCount--;

            String[] commands = scanner.nextLine().split(" ");
            if (commands[0].equals("add")) {
                trie.add(0, commands[1].toCharArray(), trieNode);
            } else if (commands[0].equals("find")) {
                System.out.println(trie.find(0, commands[1].toCharArray(), trieNode));
            }
        }
        System.out.println(trieNode);
    }

    public static void add(int index, char[] data, TrieNode trie) {
        if (index >= data.length)
            return;

        if (trie.children == null)
            trie.children = new HashMap<>();

        TrieNode node = trie.children.get(data[index]);
        if (node == null) {
            node = new TrieNode();
            node.value = data[index];
            trie.children.put(data[index], node);
        }
        node.count++;
        add(index + 1, data, node);
    }

    private int find(int index, char[] data, TrieNode trie) {
        if (index >= data.length)
            return trie == null ? 0 : trie.count;

        if (trie == null || trie.children == null)
            return 0;

        return find(index + 1, data, trie.children.get(data[index]));
    }
}
