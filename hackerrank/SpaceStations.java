package hackerrank;

import java.util.Scanner;

public class SpaceStations {

    static int flatlandSpaceStations(int numOfCities, int[] cities) {
        if (numOfCities == cities.length)
            return 0;

        int max = 0;
        int distance = 0;
        for (int i = 0; i < numOfCities; i++) {
            distance = minDistance(i, cities);
            if (distance > max)
                max = distance;
        }

        return max;
    }

    private static int minDistance(int city, int[] cities) {
        int min = Integer.MAX_VALUE;
        for (int c : cities) {
            int distance = Math.abs(c - city);
            if (distance < min)
                min = distance;
            //else break;
        }

        return min;
    }

    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int numOfCities = scanner.nextInt();
        if (numOfCities <= 0 || numOfCities > 100000)
            throw new Exception("Invalid param, number of cities.");

        int numOfCitiesWithSpaces = scanner.nextInt();
        if (numOfCitiesWithSpaces <= 0 || numOfCitiesWithSpaces > numOfCities)
            throw new Exception("Invalid param, number of cities with spaces.");

        int[] cities = new int[numOfCitiesWithSpaces];
        for (int i = 0; i < numOfCitiesWithSpaces; i++) {
            int index = scanner.nextInt();
            cities[i] = index;
        }

        System.out.println(flatlandSpaceStations(numOfCities, cities));

        scanner.close();
    }
}
