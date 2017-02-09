package ccinterview;

import Containers.Node;

import java.util.*;

class TrieNode {
    char c;
    List<TrieNode> children = new ArrayList<>();

    public TrieNode() {}
    public TrieNode(char c){
        this.c = c;
    }
}

class Trie {
    List<TrieNode> nodes = new ArrayList<>(); // MAX = 26, English alphabetical chars

    void add(String item){
        char[] chArr = item.toCharArray();
        if(nodes.size() == 0) {
            for (int i = 0; i < chArr.length; i++)
                nodes.add(new TrieNode(chArr[i]));
            return;
        }

        TrieNode lastNode = null;
        for(int i=0; i<chArr.length; i++) {
            TrieNode node = containsOf(chArr[i], nodes);
            if(node != null)
                lastNode = node;
            if(node == null) {
                addToChild(lastNode, i, chArr);
                break;
            }
        }

        for (TrieNode node : nodes){
            print(node);
        }
    }

    void addToChild(TrieNode node, int idx, char[] chArr){
        TrieNode lastNode = node;
        while (node != null && idx < chArr.length) {
            node = containsOf(chArr[idx], node.children);
            if(node != null)
                lastNode = node;
            idx++;
        }
        if(idx == chArr.length) return;

        if(node == null) {
            while (idx < chArr.length) {
                lastNode.children.add(new TrieNode(chArr[idx]));
                idx++;
            }
        }
        else
            addToChild(lastNode, idx, chArr);
    }

    TrieNode containsOf(char ch, List<TrieNode> nodes){
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

    void print(TrieNode node){
        System.out.print(node.c + " ");
        for(TrieNode inner_node : node.children)
            print(inner_node);
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
