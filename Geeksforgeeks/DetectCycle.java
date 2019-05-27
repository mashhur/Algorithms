package Geeksforgeeks;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mashhur on 2/13/17.
 */
public class DetectCycle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int nVertices = sc.nextInt();
            LinkedList<Integer>[] alist = new LinkedList[nVertices];
            int nEdges = sc.nextInt();
            for (int k = 0; k < nVertices; k++)
                alist[k] = new LinkedList<>();

            for (int k = 0; k < nEdges; k++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                alist[u].add(v);
            }

            System.out.println(isCyclic(nVertices, alist));
        }
    }

    static Boolean isCyclic(int V, LinkedList<Integer>[] list) {

        boolean[] bVisit = new boolean[list.length];
        for (int i = 0; i < V; i++) {

            int nStart = i;
            if (bVisit[i])
                continue;

            // DFS
            Stack<Integer> stack = new Stack<>();
            stack.push(nStart);

            while (!stack.isEmpty()) {
                int idx = stack.pop();
                if (bVisit[idx])
                    continue;

                bVisit[idx] = true;
                //System.out.println(idx);
                LinkedList<Integer> nList = list[idx];
                for (int item : nList) {
                    if (nStart == item)
                        return true;
                    else
                        stack.add(item);
                }
            }
        }
        return false;
    }
}
