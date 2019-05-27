package Hackerrank.Graph.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashhur on 3/7/17.
 */
public class Vertex {

    private int idx;
    private List<Integer> nNeighbourVertices = new ArrayList<>();
    private List<Integer> nEdges = new ArrayList<>();
    private int nMinDist = Integer.MAX_VALUE;
    private boolean isVisited = false;

    public Vertex(int idx) {
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }

    public void setVisited() {
        isVisited = true;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public int getMinDistance() {
        return nMinDist;
    }

    public void setMinDistance(int dist) {
        nMinDist = dist;
    }

    public List<Integer> getNeighbourList() {
        return nNeighbourVertices;
    }

    public void addNeignbourVertice(int idx) {
        nNeighbourVertices.add(idx);
    }

    public void addEdge(int idx) {
        nEdges.add(idx);
    }

    public List<Integer> getEdgeList() {
        return nEdges;
    }
}
