package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mashhur on 2/11/17.
 */
public class MaxSumOfSubArray {
    // find a maximum sum of contiguous sub array, Solution 2*O(N) where N size of array

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];

        // 1. find maximum
        int nMaxElem = Integer.MIN_VALUE;
        int nMaxIndex = 0;
        for (int i=0; i<n; i++) {
            nArr[i] = sc.nextInt();
            if(nArr[i] > nMaxElem) {
                nMaxElem = nArr[i];
                nMaxIndex = i;
            }
        }

        // 2. track maximum to left side
        int nCurrIndex = nMaxIndex-1;
        int nSum = nArr[nMaxIndex];
        List<Integer> nMaxList = new ArrayList<>();
        while (nCurrIndex >= 0){
            int nTempSum = nSum;
            nTempSum += nArr[nCurrIndex];
            if(nTempSum < nSum)
                nMaxList.add(nSum);
            nSum = nTempSum;
            nCurrIndex--;
        }

        // 3. track maximum to right side
        nCurrIndex = nMaxIndex + 1;
        nSum = nArr[nMaxIndex];
        while (nCurrIndex < n){
            int nTempSum = nSum;
            nTempSum += nArr[nCurrIndex];
            if(nTempSum < nSum)
                nMaxList.add(nSum);
            nSum = nTempSum;
            nCurrIndex++;
        }

        Collections.sort(nMaxList);
        System.out.println(nMaxList.get(nMaxList.size()-1));
    }

}
