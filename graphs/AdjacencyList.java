package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashhur on 11/13/16.
 * Reference : http://www.geeksforgeeks.org/graph-and-its-representations/
 * Undirected Graph
 */
public class AdjacencyList {

    List<Integer>[] nAdjMap;
    private int v;
    private boolean isDirected;

    public AdjacencyList(int vertexes, boolean bDirected) {
        if (vertexes <= 0) return;
        this.isDirected = bDirected;
        this.v = vertexes;
        nAdjMap = new ArrayList[v];
        for (int i = 0; i < vertexes; i++) {
            nAdjMap[i] = new ArrayList<Integer>();
        }
    }

    public static void main(String[] args) {
        AdjacencyList nAdj = new AdjacencyList(5, false);
        nAdj.addEdge(0, 1);
        nAdj.addEdge(0, 4);
        nAdj.addEdge(1, 2);
        nAdj.addEdge(1, 3);
        nAdj.addEdge(1, 4);
        nAdj.addEdge(2, 3);
        nAdj.addEdge(3, 4);

        nAdj.print();

        nAdj.removeEdge(1, 4);
        nAdj.print();
    }

    public List<Integer> getVertice(int n) {
        if (nAdjMap == null)
            return null;

        return nAdjMap[n];
    }

    public int size() {
        return v;
    }

    public boolean isEmpty() {
        return v == 0;
    }

    public void addEdge(int x, int y) {
        if (x >= v || y >= v) return;
        nAdjMap[x].add(y);

        if (!isDirected)
            nAdjMap[y].add(x);
    }

    public void removeEdge(int x, int y) {
        if (x >= v || y >= v) return;
        int idx = nAdjMap[x].indexOf(y);
        nAdjMap[x].remove(idx);

        int idy = nAdjMap[y].indexOf(x);
        nAdjMap[y].remove(idy);
    }

    public void print() {
        for (int i = 0; i < v; i++) {
            System.out.println();
            List<Integer> nList = nAdjMap[i];
            System.out.print(" " + i + " ->");
            for (Integer k : nList) {
                System.out.print(" " + k);
            }
        }
    }
}


