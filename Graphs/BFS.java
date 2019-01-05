package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mashhur on 11/13/16.
 * Breadth First Search
 */

public class BFS {

    public void traverse(AdjacencyMatrix nAdjMatrix, int idx) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] bVisitedArr = new boolean[nAdjMatrix.size()];

        queue.add(idx);
        bVisitedArr[idx] = true;

        while (!queue.isEmpty()){
            int n = queue.poll();
            System.out.println("Visit : " + n);
            for (int i = 0; i < nAdjMatrix.size(); i++){
                int nVal = nAdjMatrix.getVertice(n, i);
                if(nVal == 1 && bVisitedArr[i] == false){
                    queue.add(i);
                    bVisitedArr[i] = true;
                }
            }
        }

    }

    public void traverse(AdjacencyList nAdjList, int idx){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] bVisitedArr = new boolean[nAdjList.size()];

        queue.add(idx);
        bVisitedArr[idx] = true;

        while (!queue.isEmpty()){
            int n = queue.poll();
            System.out.println("Visit : " + n);
            List<Integer> nList = nAdjList.getVertice(n);
            for (int i : nList){
                if(bVisitedArr[i] == false){
                    queue.add(i);
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
        BFS bfs = new BFS();
        bfs.traverse(nAdj, 0);
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

        BFS bfs = new BFS();
        bfs.traverse(nAdjList, 0);
    }
}
