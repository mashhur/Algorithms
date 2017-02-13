package ccinterview;

import java.util.*;

class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    int count = 0;
    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }
}

public class Contacts {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie trie = new Trie();
        for(int i = 0; i < n; i++) {
            String cmd = in.next();
            if(cmd.equals("add")) {
                String contact = in.next();
                trie.insert(contact);
            }
            else if(cmd.equals("find")){
                String str = in.next();
                int nCount = 0;
                if(trie.search(str)){
                    System.out.println(str + " found.");
                }

            }
        }

    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            //set leaf node
            if(i==word.length()-1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if(t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    public int searchParticial(String word) {
        TrieNode t = searchNode(word);

        if(t != null)
            return t.count ;
        else
            return 0;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }

        return t;
    }
}
