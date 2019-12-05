package graphs;

/**
 * Created by mashhur on 11/13/16.
 * Reference : http://www.geeksforgeeks.org/graph-and-its-representations/
 * Undirected Graph
 */
public class AdjacencyMatrix {
    private int nNodes;
    private boolean isDirected;
    private int[][] nMatrix;

    public AdjacencyMatrix(int nodes, boolean bDirected) {
        if (nodes <= 0) return;

        this.isDirected = bDirected;
        this.nNodes = nodes;
        nMatrix = new int[nodes][nodes];
    }

    public static void main(String[] args) {
        AdjacencyMatrix nAdj = new AdjacencyMatrix(5, false);
        nAdj.addEdge(0, 1);
        nAdj.addEdge(0, 4);
        nAdj.addEdge(1, 2);
        nAdj.addEdge(1, 3);
        nAdj.addEdge(1, 4);
        nAdj.addEdge(2, 3);
        nAdj.addEdge(3, 4);

        nAdj.print();
    }

    public int size() {
        return nNodes;
    }

    public int getVertice(int x, int y) {
        if (x >= nNodes || y >= nNodes) return -1;
        return nMatrix[x][y];
    }

    public void addEdge(int x, int y) {
        if (x >= nNodes || y >= nNodes) return;
        nMatrix[x][y] = 1;

        if (!isDirected)
            nMatrix[y][x] = 1;
    }

    public void removeEdge(int x, int y) {
        if (x >= nNodes || y >= nNodes) return;
        nMatrix[x][y] = 0;
        nMatrix[y][x] = 0;
    }

    public void print() {
        for (int i = 0; i < nNodes; i++) {
            System.out.println();
            for (int k = 0; k < nNodes; k++) {
                System.out.print(" " + nMatrix[i][k]);
            }
        }
    }
}
