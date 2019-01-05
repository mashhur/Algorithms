package cci;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mashhur on 1/8/17.
 */
public class TaleOfTwoStacks {

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            prepOld();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {

            prepOld();
            return stackOldestOnTop.pop();

        }

        public void prepOld(){
            if (stackOldestOnTop.isEmpty())
                while(!stackNewestOnTop.isEmpty())
                    stackOldestOnTop.push(stackNewestOnTop.pop());
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
