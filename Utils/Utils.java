package Utils;

/**
 * Created by mashhur on 12/24/16.
 */
public class Utils {

    public static void swap(int[] arr, int m, int n) {
        if(m >= arr.length || m<0) return;
        if(n >= arr.length || n<0) return;

        int nTemp = arr[m];
        arr[m] = arr[n];
        arr[n] = nTemp;
    }

    public static void quickSort(char[] ar) {
        partition(ar, 0, ar.length - 1);
    }

    private static void partition(char[] ar, int left, int right){
        int pivot = ar[left + (right - left) / 2];
        int i = left;
        int j = right;

        while (i <= j){
            while (ar[i] < pivot)
                i++;
            while(ar[j] > pivot)
                j--;

            if (i <= j) {
                swapChar(ar, i, j);
                i++;
                j--;
            }
        }

        if(left < j) {
            partition(ar, left, j);
        }
        if(i < right)
            partition(ar, i, right);
    }

    private static void swapChar(char[] ar, int n, int k){
        char nVal = ar[n];
        ar[n] = ar[k];
        ar[k] = nVal;
        //printArray(ar);
    }
}
