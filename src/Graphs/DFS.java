package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mashhur on 11/13/16.
 */
public class DFS {
    boolean bVisitedArr[];

    public void traverse(AdjacencyMatrix nAdjMatrix, int idx) {
        Stack<Integer> stack = new Stack<>();
        bVisitedArr = new boolean[nAdjMatrix.size()];

        stack.push(idx);
        bVisitedArr[idx] = true;

        while (!stack.isEmpty()){
            int n = stack.pop();
            System.out.println("Visit : " + n);
            for (int i = 0; i < nAdjMatrix.size(); i++){
                int nVal = nAdjMatrix.getVertice(n, i);
                if(nVal == 1 && bVisitedArr[i] == false){
                    stack.push(i);
                    bVisitedArr[i] = true;
                }
            }
        }
    }

    public void traverse(AdjacencyList nAdjList, int idx){
        Stack<Integer> stack = new Stack<>();
        boolean[] bVisitedArr = new boolean[nAdjList.size()];

        stack.push(idx);
        bVisitedArr[idx] = true;

        while (!stack.isEmpty()){
            int n = stack.pop();
            System.out.println("Visit : " + n);
            List<Integer> nList = nAdjList.getVertice(n);
            for (int i : nList){
                if(bVisitedArr[i] == false){
                    stack.push(i);
                    bVisitedArr[i] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        /*
        AdjacencyMatrix nAdj = new AdjacencyMatrix(5);
        nAdj.addEdge(0, 1);
        nAdj.addEdge(0, 4);
        nAdj.addEdge(1, 2);
        nAdj.addEdge(1, 3);
        nAdj.addEdge(1, 4);
        nAdj.addEdge(2, 3);
        nAdj.addEdge(3, 4);

        nAdj.print();
        System.out.println();
        DFS dfs = new DFS();
        dfs.traverse(nAdj, 0);
        */

        AdjacencyList nAdjList = new AdjacencyList(5, false);
        nAdjList.addEdge(0, 1);
        nAdjList.addEdge(0, 4);
        nAdjList.addEdge(1, 2);
        nAdjList.addEdge(1, 3);
        nAdjList.addEdge(1, 4);
        nAdjList.addEdge(2, 3);
        nAdjList.addEdge(3, 4);

        nAdjList.print();
        System.out.println();

        DFS dfs = new DFS();
        dfs.traverse(nAdjList, 0);
    }
}
