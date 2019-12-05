package hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by mashhur on 2/19/17.
 */
public class BreakingRecords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nSize = sc.nextInt();
        int[] nScores = new int[nSize];
        for (int i = 0; i < nSize; i++) {
            nScores[i] = sc.nextInt();
        }

        PriorityQueue<Integer> pMaxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> pMinQueue = new PriorityQueue<>();
        int nMax = nScores[0];
        int nMin = nScores[0];
        for (int i = 1; i < nSize; i++) {
            if (nMax < nScores[i]) {
                nMax = nScores[i];
                pMaxQueue.add(nMax);
            } else if (nMin > nScores[i]) {
                nMin = nScores[i];
                pMinQueue.add(nMin);
            }
        }
        System.out.print(pMaxQueue.size() + " ");
        System.out.println(pMinQueue.size());
    }
}
