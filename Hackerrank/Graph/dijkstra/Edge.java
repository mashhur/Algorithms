package Hackerrank.Graph.dijkstra;

/**
 * Created by mashhur on 3/7/17.
 */
public class Edge {

    private Vertex fromVertice;
    private Vertex toVertice;
    private int weight;

    public Edge(Vertex from, Vertex to, int weight) {
        this.weight = weight;
        this.fromVertice = from;
        this.toVertice = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setVertices(Vertex from, Vertex to) {
        this.fromVertice = from;
        this.toVertice = to;
    }

    public Vertex getFromVertice() {
        return fromVertice;
    }

    public Vertex getToVertice() {
        return toVertice;
    }
}