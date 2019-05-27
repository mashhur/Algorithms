package Hackerrank.tree;

import java.util.Scanner;

/*
 * Created by mashhur on 2/19/17.
 */

public class SwapNodes {

/*
3
2 3
-1 -1
-1 -1
2
1
1
*/

    static int nCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nSize = sc.nextInt();

        Node root = new Node(1);
        for (int i = 0; i < nSize; i++) {
            int nA = sc.nextInt();
            int nB = sc.nextInt();
            insert(root, i, nA, nB);
        }

        System.out.println(root.data);
    }

    static boolean insert(Node root, int nDepth, int a, int b) {
        if (nCount == nDepth) {
            if (a != -1)
                root.left = new Node(a);
            if (b != -1)
                root.right = new Node(b);
            nCount = 0;
            return true;
        }
        nCount++;

        boolean bRet = false;
        if (root.left != null)
            bRet = insert(root.left, nDepth, a, b);
        if (bRet) return bRet;

        if (root.right != null)
            bRet = insert(root.right, nDepth, a, b);

        return bRet;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
}
