package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mashhur on 1/23/17.
 */

class Name{
    String name ;
    char cStart, cEnd;
    Name(String name, char cStart, char cEnd){
        next = null;
        this.name = name;
        this.cStart = cStart;
        this.cEnd = cEnd;
    }
    Name next;
}

public class ArrangeName {
    /* DEFINITION:
       The input is a list of names in random order.
       We need a function that chains elements of the list in such a way that
       the last character of an name is the same as the first one of the next name.

        For instance:

        Input: [“Raymond”, “Nora”, “Daniel”, “Louie”, “Peter”, “Esteban”]
        Output: [“Peter”, “Raymond”, “Daniel”, “Louie”, “Esteban”, “Nora”]
        There should be only one solution, so the first element is unique.
    */

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        stack.push('a');
        queue.add('a');
        stack.pop();
        queue.poll();

        Name head = null;
        String[] strName = {"Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban"};
        for (int i=0; i<strName.length; i++){
            char[] chNameArr = strName[i].toCharArray();
            Name node = new Name(strName[i], chNameArr[0], chNameArr[chNameArr.length-1]);
            if(head == null)
                head = node;
            else {
                insertNode(head, node);
                //head = arrangeTree(head);
            }
        }

        display(head);
    }

    static void insertNode(Name head, Name node){
        Name nCurrNode = head;
        while (nCurrNode.next != null){
            nCurrNode = nCurrNode.next;
        }
        nCurrNode.next = node;
    }

    public static void display(Name node){
        while (node != null){
            System.out.print(node.name + " ");
            node = node.next;
        }
    }
}
