package Sorting;

import java.util.Scanner;

/**
 * Created by MIK on 11/14/2015.
 */
public class QuickSort {

    /*
    * Quicksort 1 Problem of hackerrank
    */
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();

        int[] nArr = new int[nSz];

        int i=0;
        while (i<nSz){
            nArr[i] = sc.nextInt();
            i++;
        }

        quickSort(nArr);
        System.out.println(nSwaps);
    }

    private static void quickSort(int[] ar) {
        partition(ar, 0, ar.length - 1);
        printArray(ar);
    }

    private static void partition(int[] ar, int left, int right){
        int pivot = ar[left + (right - left) / 2];
        int i = left;
        int j = right;

        while (i <= j){
            while (ar[i] < pivot)
                i++;
            while(ar[j] > pivot)
                j--;

            if (i <= j) {
                swap(ar, i, j);
                i++;
                j--;
            }
        }

        if(left < j) {
            partition(ar, left, j);
        }
        if(i < right)
            partition(ar, i, right);

        //printArray(ar, left, right);
    }

    static int nSwaps;
    private static void swap(int[] ar, int n, int k){
        if(ar[n] == ar[k]) return;

        int nVal = ar[n];
        ar[n] = ar[k];
        ar[k] = nVal;
        nSwaps++;
    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println();
    }

    /*
    * Quicksort 2 Problem of hackerrank
    */
    public static void TestQuickSort2(){
        Scanner sc = new Scanner(System.in);
        int nSz = sc.nextInt();

        int[] nArr = new int[nSz];

        int i=0;
        while (i<nSz){
            nArr[i] = sc.nextInt();
            i++;
        }

        quickSort2(nArr);
    }

    private static void quickSort2(int[] ar) {
        partition2(ar, 0, ar.length - 1);
    }

    private static void partition2(int[] ar, int left, int right){
        int pivot = ar[left + (right - left) / 2];
        int i = left;
        int j = right;

        while (i <= j){
            while (ar[i] < pivot)
                i++;
            while(ar[j] > pivot)
                j--;

            if (i <= j) {
                swap(ar, i, j);
                i++;
                j--;
            }
        }

        if(left < j) {
            printArray(ar, left, j);
            partition(ar, left, j);
        }
        if(i < right){
            printArray(ar, i, right);
            partition(ar, i, right);
        }

        printArray(ar, left, right);
    }

    private static void printArray(int[] ar, int lo, int ri) {
        for(int n=lo; n<=ri; n++) {
            System.out.print(ar[n]+" ");
        }
        System.out.println();
    }
}
