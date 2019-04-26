package hackerrank.Graph.dijkstra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mashhur on 2/14/17.
 * Undirected Graph, Dijkstra algorithm implementation.
 */

public class DijkstraShortestPath {

    public static void main(String[] args) {

/* simple test case
1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1
*/
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases

        for (int i = 0; i < t; i++) {
            int nVertices = sc.nextInt();   // vertices
            int nEdges = sc.nextInt();      // edges

            Vertex[] vertices = new Vertex[nVertices];
            Edge[] edges = new Edge[nEdges];

            for (int k = 0; k < nVertices; k++) {
                vertices[k] = new Vertex(k);
            }

            // edge connections
            for (int k = 0; k < nEdges; k++) {
                int u = sc.nextInt() - 1;     // from Vertex
                int v = sc.nextInt() - 1;     // to Vertex
                int x = sc.nextInt();       // weight

                vertices[u].addNeignbourVertice(v);
                vertices[v].addNeignbourVertice(u);
                vertices[u].addEdge(k);
                vertices[v].addEdge(k);
                edges[k] = new Edge(vertices[u], vertices[v], x);
            }
            int nStart = sc.nextInt() - 1;
            int[] distArr = calcShortestDistance(vertices, edges, nStart);
            for (Vertex vertex : vertices) {
                if (vertex.getIdx() == nStart) continue;

                if (vertex.getMinDistance() == Integer.MAX_VALUE)
                    System.out.print("-1 ");
                else
                    System.out.print(vertex.getMinDistance() + " ");
            }
            System.out.println();
        }
    }

    static int[] calcShortestDistance(Vertex[] vertices, Edge[] edges, int nStart) {
        Vertex grStart = vertices[nStart];
        grStart.setMinDistance(0);
        // BFS
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(grStart);
        int[] nDistance = new int[vertices.length];

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            if (vertex.isVisited())
                continue;

            vertex.setVisited();

            //System.out.println("......... Traverse node ....... " + vertex.getIdx());
            for (int idx : vertex.getEdgeList()) {
                if (!edges[idx].getFromVertice().isVisited())
                    queue.add(edges[idx].getFromVertice());
                if (!edges[idx].getToVertice().isVisited())
                    queue.add(edges[idx].getToVertice());

                Vertex vChilVertex = null;
                if (edges[idx].getFromVertice().getIdx() != vertex.getIdx())
                    vChilVertex = edges[idx].getFromVertice();
                else
                    vChilVertex = edges[idx].getToVertice();

                if (vChilVertex.getMinDistance() > vertex.getMinDistance() + edges[idx].getWeight())
                    vChilVertex.setMinDistance(vertex.getMinDistance() + edges[idx].getWeight());

                //System.out.println("Vertex : " + vChilVertex.getIdx());
                //System.out.println("Distance : " + vChilVertex.getMinDistance());
            }
        }

        return nDistance;
    }
}
