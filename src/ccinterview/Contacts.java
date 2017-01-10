package ccinterview;

import Containers.Node;

import java.util.*;

class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode() {}
    public TrieNode(char c){
        this.c = c;
    }
}

class Trie {
    List<TrieNode> nodes = new ArrayList<>(); // MAX = 26, English alphabetical chars

    void add(String item){
        char[] chArr = item.toCharArray();
        for (int i=0; i<chArr.length; i++) {
            for (TrieNode node : nodes) {
                if (node.c == chArr[i]) { // goes to children

                } else { // add node
                    //node
                }
            }
        }

    }

    void find(){

    }

    int count(String part){
        return 0;
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
                trie.add(contact);
            }
            else if(cmd.equals("find")){
                String str = in.next();
                int nCount = 0;

                System.out.println(nCount);
            }
        }

    }
}
