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
    List<TrieNode> nodes = new ArrayList<TrieNode>(); // MAX = 26, English alphabetical chars

    void add(String item){
        char[] chArr = item.toCharArray();
        TrieNode node = containsOf(chArr[0]);
        if(node == null){ // make a new node
            node = new TrieNode(chArr[0]);
            for(int i=1; i<chArr.length; i++)
                node.children.put(chArr[i], new TrieNode());
            nodes.add(node);
        } else { // already contains CHAR, update a trie
            boolean bFound = false;
            for (Map.Entry<Character, TrieNode> child_node : node.children.entrySet()){
                char key = child_node.getKey();
                for(char ch : chArr){
                    if(key == ch){
                        bFound = true;
                        break;
                    }
                }
            }
            if(!bFound) {
                for(int i=1; i<chArr.length; i++)
                    node.children.put(chArr[i], new TrieNode());
            }
        }
    }

    TrieNode containsOf(char ch){
        for (TrieNode node : nodes) {
            if (node.c == ch)
                return node;
        }
        return null;
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
