package ccinterview;

import java.util.Scanner;
import Utils.*;
/**
 * Created by mashhur on 12/24/16.
 */
public class LeftRotation {

    // Time complexity O(N), space complexity O(N)
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // array size
        int k = in.nextInt(); // number of rotations
        int arr[] = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }

        int arr_rot[] = new int[n];
        for(int i=0; i<n; i++) {
            arr_rot[(i+n-k)%n] = arr[i];
            //System.out.println((i+n-k)%n);
        }

        print(arr_rot);
    }

    private static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
