package Sorting;

import java.math.BigInteger;

/**
 * Created by mashhur on 1/30/17.
 */
public class MergeSort {

    private int[] array;
    private int[] tempMergArr;
    private int length;

    public static void main(String a[]){

        //int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        int[] inputArr = {2, 1, 3, 1, 2};
        //int[] inputArr = {1, 1, 1, 2, 2};
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(nSwapCount);
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    static int nSwapCount = 0;
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
                //nSwapCount++;
            } else {
                array[k] = tempMergArr[j];
                j++;
                nSwapCount++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
            nSwapCount++;
        }
    }
}
