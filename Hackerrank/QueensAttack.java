package Hackerrank;

import java.util.Scanner;

/**
 * Created by mashhur on 1/29/17.
 */

public class QueensAttack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // N x N board
        int k = in.nextInt(); // number of obstacles
        int rQueen = in.nextInt(); // Queen X position
        int cQueen = in.nextInt(); // Queen Y position

        int nBoard[][] = new int[n][n];

        /* IDEA */
        // define visit positions
        // mark as visited Obstacle positions
        // DFS to count can be visited positions

        // define visit positions
        // 1: X straight coord: rQueen ~ N, 0 ~ rQueen, cQueen is constant
        // 2: Y straight coord: cQueen ~ N, 0 ~ cQueen, rQueen is constant
        // 3: rQueen-- cQueen-- ~ 0, rQueen++ cQueen++ ~ N
        // 4: rQueen-- ~ 0 cQueen++ ~ N, rQueen++ ~ N cQueen-- ~ 0
        setQueenVisitCoords(n, nBoard, rQueen, cQueen);
        print(n, nBoard);

        // mark as 0 obstacle positions
        for (int a = 0; a < k; a++) { // Obstacles
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            // define which side of Queen standing an obstacle (up-left, up-right, down-left, down-right)
            // define whether obstacle
            //setObstacleCoords(n, nBoard, rQueen, cQueen, rObstacle, cObstacle);
            //print(n, nBoard);
        }
    }

    public static void setQueenVisitCoords(int n, int nBoard[][], int rQueen, int cQueen) {
        // 1) rQueen ~ N, 0 ~ rQueen, cQueen is constant
        int nX = rQueen, nY = cQueen;
        while (nX > 0) {
            nX--;
            nBoard[nX][nY] = 1;
        }
        nX = rQueen;
        while (nX < n) {
            nX++;
            nBoard[nX][nY] = 1;
        }

        // 2) cQueen ~ N, 0 ~ cQueen, rQueen is constant
        nX = rQueen;
        nY = cQueen;
        while (nY > 0) {
            nY--;
            nBoard[nX][nY] = 1;
        }
        nY = cQueen;
        while (nY < n) {
            nY++;
            nBoard[nX][nY] = 1;
        }

        // 3) rQueen-- cQueen-- ~ 0, rQueen++ cQueen++ ~ N
        nX = rQueen;
        nY = cQueen;
        while (nX > 0 && nY > 0) {
            nX--;
            nY--;
            nBoard[nX][nY] = 1;
        }

        nX = rQueen;
        nY = cQueen;
        while (nX < n && nY < n) {
            nX++;
            nY++;
            nBoard[nX][nY] = 1;
        }

        // 4) rQueen-- ~ 0 cQueen++ ~ N, rQueen++ ~ N cQueen-- ~ 0
        nX = rQueen;
        nY = cQueen;
        while (nX > 0 && nY < n) {
            nX--;
            nY++;
            nBoard[nX][nY] = 1;
        }

        nX = rQueen;
        nY = cQueen;
        while (nX < n && nY > 0) {
            nX++;
            nY--;
            nBoard[nX][nY] = 1;
        }
    }

    public static void setObstacleCoords(int n, int nBoard[][], int rQueen, int cQueen, int rObstacle, int cObstacle) {
        // same X position
        if (rObstacle == rQueen) {
            if (cObstacle - cQueen > 0) { // Obstacle is the down side of Queen
                int nX = rQueen, nY = cQueen;
                while (nX > 0) {
                    nX--;
                    nBoard[nX][nY] = 1;
                }
            } else { // Obstacle is the up side of Queen

            }
        }

        // same Y position
        if (cObstacle == cQueen) {
            if (rObstacle - rQueen > 0) { // Obstacle is the up side of Queen

            } else { // Obstacle is the down side of Queen

            }
        }

        if (cObstacle - cQueen == rObstacle - rQueen) {

        }
    }

    static void print(int n, int nBoard[][]) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (nBoard[x][y] == 1)
                    System.out.println("X : " + x + "  Y : " + y);
            }
        }
    }
}
