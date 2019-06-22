package Exercises;

import java.io.File;
import java.util.*;

public class Hotels {

    class Coord {
        int x, y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Coord that = (Coord)o;
            return  (that.x == this.x && that.y == this.y);
        }

        @Override
        public int hashCode() {
            return x * y;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("/Users/mashhur/Dev/repos/Algorithms/Exercises/hotels_input.txt"));
        int hotels = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] array = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        Hotels instance = new Hotels();
        List<Coord> nearestHotels = instance.getCoordinates(array, x, y, hotels);
        for (Coord coord : nearestHotels) {
            System.out.println("X: " + coord.x + ", Y: " + coord.y);
        }
    }

    public List<Coord> getCoordinates(int[][] map, int x, int y, int n) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[x].length)
            return Collections.emptyList();

        List<Coord> hotels = new ArrayList<>();
        HashSet<Coord> visited = new HashSet<>();

        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(x, y));

        int[][] neighbors = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(queue.isEmpty() == false) {
            Coord coord = queue.remove();

            if (visited.contains(coord))
                continue;

            visited.add(coord);
            if (map[coord.x][coord.y] == 1)
                hotels.add(coord);
            if (n == hotels.size())
                return hotels;

            for (int[] neighbor : neighbors) {
                int currX = coord.x + neighbor[0];
                int currY = coord.y + neighbor[1];

                if (isSafe(map, currX, currY) == true &&
                        visited.contains(new Coord(currX, currY)) == false) {
                    queue.add(new Coord(currX, currY));
                }
            }
        }

        return Collections.emptyList();
    }

    private boolean isSafe(int[][] map, int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[x].length;
    }

}
