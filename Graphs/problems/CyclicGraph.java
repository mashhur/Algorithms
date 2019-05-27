package Graphs.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CyclicGraph {

    public static void main(String[] args) {
        int nodes = 6;
        int[][] graph = new int[nodes][nodes];
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 1;
        }

        graph[0][1] = 1;
        graph[1][0] = 1;
        graph[0][4] = 1;
        graph[4][0] = 1;
        graph[1][2] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[3][2] = 1;
        graph[2][5] = 1;
        graph[5][2] = 1;
        graph[3][4] = 1;
        graph[4][3] = 1;
        boolean[][] visited = new boolean[nodes][nodes];

        //System.out.println(isCyclic(graph, 0));
        //System.out.println(helper(graph, 0, visited));

        List<Integer>[] listGraph = new ArrayList[nodes];
        for (int i=0; i<listGraph.length; i++) {
            listGraph[i] = new ArrayList<>();
        }

        listGraph[0].add(1);
        listGraph[1].add(2);
        listGraph[2].add(3);
        listGraph[2].add(5);
        listGraph[3].add(4);
        listGraph[4].add(0);
        System.out.println(isCyclic(listGraph, 0));
    }

    private static boolean isCyclic(int[][] graph, int idx) {
        Stack<Integer> stack = new Stack<>();
        boolean[] bVisitedArr = new boolean[graph.length];

        stack.push(idx);
        bVisitedArr[idx] = true;

        while (!stack.isEmpty()) {
            int n = stack.pop();
            System.out.println("Visit : " + n);
            for (int i = 0; i < graph.length; i++) {
                int nVal = graph[n][i];
                if (nVal == 1 && bVisitedArr[i] == false) {
                    stack.push(i);
                    bVisitedArr[i] = true;

                    while (stack.isEmpty() == false) {
                        int index = stack.pop();
                        int[] array = graph[index];
                        for (int k = 0; k < array.length; k++) {
                            if (array[k] == idx)
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean helper(int[][] graph, int index, boolean[][] visited) {
        System.out.println("Index: " + index);

        Stack<Integer> stack = new Stack<>();

        visited[index][index] = true;
        stack.push(index);

        while (stack.isEmpty() == false) {
            int idx = stack.pop();
            System.out.println("Main ----- " + idx);
            for (int i = 0; i < graph[idx].length; i++) {
                if (idx == i)
                    continue;

                System.out.println("    Sub ----- " + i);
                if (graph[idx][i] == 1 && visited[idx][i] == false) {
                    stack.push(i);
                    visited[idx][i] = true;

                    if (i == index)
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclic(List<Integer>[] graph, int index) {
        boolean[] visited = new boolean[graph.length];

        visited[index] = true;

        Stack<Integer> stack = new Stack<>();
        stack.add(index);

        while (stack.empty() == false) {
            int idx = stack.pop();
            System.out.println(idx);

            List<Integer> list = graph[idx];
            for (int item : list) {
                if (item == index)
                    return true;

                if (visited[item] == false) {
                    visited[item] = true;
                    stack.add(item);
                }
            }
        }
        return false;
    }
}
