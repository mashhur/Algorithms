package assessments.amzn;

import java.util.Scanner;

/**
 * Created by mashhur on 1/31/16.
 */
public class AmazonLocker {

    public static void UnitTest(){
        task1();
    }

    private static void task1() {
        Scanner sc = new Scanner(System.in);
        int cWidth = sc.nextInt();
        int cHeight = sc.nextInt();

        int nLength = sc.nextInt();
        int[] nArrX = new int[nLength];
        int[] nArrY = new int[nLength];
        int i = 0;
        while (i < nLength) {
            nArrX[i] = sc.nextInt()-1;
            nArrY[i] = sc.nextInt()-1;
            i++;
        }

        getLockerDistanceGrid(cHeight, cWidth, nArrX, nArrY);

        // O(n) time complexity
        for (int y = 0; y < cHeight; y++) {
            for (int x = 0; x < cWidth; x++) {
                i = 0;
                int nMin = Integer.MAX_VALUE;
                while (i < nLength) {
                    // Manhattan (not Euclidean) Distance
                    int n = Math.abs(x - nArrX[i]) + Math.abs(y - nArrY[i]);
                    i++;
                    if (nMin > n)
                        nMin = n;
                }
                System.out.print(nMin);
            }
            System.out.println();
        }
    }

    private static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        // 0. Initialize return parameter
        // 1. Validation: 1<=cityLength <= cityWidth <= 9
        //      1<=lockerXCoordinates[i] <=lockerYCoordinates[i] <=9
        // 2. Calculate minimum Manhattan Distance
        // 3. Time Complexity : O(n) - where n is the length of locker coordinates

        int[][] nArr = new int[cityLength][cityWidth];

        for(int i=0; i<cityLength; i++){
            for(int j=0; j<cityWidth; j++){

                // distance for every locker
                int m=0;
                int nMinimum = Integer.MAX_VALUE;
                while(m<lockerXCoordinates.length){
                    int nX = lockerXCoordinates[m] - 1;
                    int nY = lockerYCoordinates[m] - 1;
                    int nDist = Math.abs(j-nX) + Math.abs(i-nY);
                    m++;
                    // assign minimum distance to return array value
                    if(nMinimum > nDist) nMinimum = nDist;
                }
                nArr[i][j] = nMinimum;
            }
        }
        return nArr;
    }
}
