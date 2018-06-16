package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {

    static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        Node nCurr = root;
        while (nCurr != null) {
            if (data > nCurr.data) { // insert on right branch
                if (nCurr.right == null) {
                    nCurr.right = new Node(data);
                    break;
                } else
                    nCurr = nCurr.right;
            } else { // insert on left branch
                if (nCurr.left == null) {
                    nCurr.left = new Node(data);
                    break;
                } else
                    nCurr = nCurr.left;
            }
        }
        return root;
    }

    public static int getHeight(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void BFS(Node root) {
        if (root == null) return;
        System.out.print("BFS traversal : ");

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node nCurr = queue.poll();
            System.out.print(nCurr.data + " ");
            if (nCurr.left != null)
                queue.add(nCurr.left);
            if (nCurr.right != null)
                queue.add(nCurr.right);
        }
        System.out.println();
    }

    public static void DFS(Node root) {
        if (root == null) return;

        System.out.print("DFS traversal : ");
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node nCurr = stack.pop();
            System.out.print(nCurr.data + " ");
            if (nCurr.right != null)
                stack.push(nCurr.right);
            if (nCurr.left != null)
                stack.push(nCurr.left);
        }
        System.out.println();
    }

    static boolean checkBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTUtil(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.data < min || node.data > max)
            return false;
        return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }

        System.out.println("Is valid BST: " + (checkBST(root) == true ? "YES" : "NO"));
        int height = getHeight(root);
        System.out.println("Height of the BST : " + height);
        BFS(root);
        DFS(root);
    }
}
