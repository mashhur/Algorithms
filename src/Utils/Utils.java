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


}
