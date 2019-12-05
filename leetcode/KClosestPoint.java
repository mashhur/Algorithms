package leetcode;

import java.util.PriorityQueue;

class Point implements Comparable<Point> {

    private int distance;
    public int[] points;

    public Point(int distance, int[] points) {
        setDistance(distance);
        setPoints(points);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public int[] getPoints() {
        return this.points;
    }

    @Override
    public int compareTo(Point point) {
        if (this.distance > point.distance)
            return 1;
        else
            return -1;
    }
}

public class KClosestPoint {

    PriorityQueue<Point> queue = new PriorityQueue<>();
    public int[][] kClosest(int[][] points, int K) {

        // 1 <= K <= points.length <= 10000
        // -10000 < points[i][0] < 10000
        // -10000 < points[i][1] < 10000

        int[][] result = new int[K][K];

        // calculate the Euc distance
        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            queue.add(new Point(distance, point));
        }

        for (int i=0; i<K; i++) {
            Point point = queue.poll();
            result[i] = point.getPoints();
        }

        return result;
    }
}
