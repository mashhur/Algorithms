package graphs.ShortestPath;

import java.util.*;

class Vertex implements Comparable<Vertex> {
    int index;
    List<Edge> edges;
    int minDistance = Integer.MAX_VALUE;

    @Override
    public int compareTo(Vertex o) {
        if (this.minDistance < o.minDistance)
            return -1;
        if (this.minDistance > o.minDistance)
            return 1;
        return 0;
    }
}

class Edge {
    Vertex to;
    int distance;

    public Edge(Vertex to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}

public class Dijkstra {

    public static void main(String[] args) {
        Vertex[] graph = new Vertex[6];

        graph[5] = new Vertex();
        graph[5].index = 5;

        graph[4] = new Vertex();
        graph[4].index = 4;
        graph[4].edges = new ArrayList<>();
        graph[4].edges.add(new Edge(graph[5], 5));

        graph[3] = new Vertex();
        graph[3].index = 3;
        graph[3].edges = new ArrayList<>();
        graph[3].edges.add(new Edge(graph[4], 4));

        graph[2] = new Vertex();
        graph[2].index = 2;
        graph[2].edges = new ArrayList<>();
        graph[2].edges.add(new Edge(graph[5], 5));
        graph[2].edges.add(new Edge(graph[3], 1));

        graph[1] = new Vertex();
        graph[1].index = 1;
        graph[1].edges = new ArrayList<>();
        graph[1].edges.add(new Edge(graph[3], 3));

        graph[0] = new Vertex();
        graph[0].index = 0;
        graph[0].edges = new ArrayList<>();
        graph[0].edges.add(new Edge(graph[1], 2));
        graph[0].edges.add(new Edge(graph[2], 6));

        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.shortestPath(graph[0], graph[4], graph));
    }

    public int shortestPath(Vertex fromNode, Vertex toNode, Vertex[] graph) {
        if (fromNode.index >= graph.length || toNode.index >= graph.length)
            throw new ArrayIndexOutOfBoundsException("Invalid start or end node.");

        // BFS
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        fromNode.minDistance = 0;
        queue.add(fromNode);

        boolean visited[] = new boolean[graph.length];

        while (queue.isEmpty() == false) {
            Vertex node = queue.poll();
            visited[node.index] = true;

            if (node.index == toNode.index) { // destination node found
                return toNode.minDistance;
            }

            if (graph[node.index].edges != null) {
                for (Edge edge : graph[node.index].edges) {
                    if (visited[edge.to.index])
                        continue;

                    if (node.minDistance + edge.distance < edge.to.minDistance)
                        edge.to.minDistance = node.minDistance + edge.distance;
                    queue.add(edge.to);
                }
            }
        }

        return 0;
    }
}
