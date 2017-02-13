package ccinterview;

import java.util.*;

/**
 * Created by mashhur on 2/12/17.
 */
public class Staircase {

    // Solution
    // A(n) = A(n - 1) + A(n - 2) + A(n - 3)
    // A(1)=1; A(2)=2; A(3)=4.

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++) {
            int n = sc.nextInt();
            System.out.println(calcNum(n));
        }
    }

    static int getCombination(int n){
        if(n <=0 ) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n == 3) return 4;

        return getCombination(n-1) + getCombination(n-2) + getCombination(n-3);
    }

    public static int calcNum(int n) {
        int[] array = new int[n];
        if (n == 1) {
            return 1;
        }
        else if(n == 2) {
            return 2;
        }
        else if(n == 3) {
            return 4;
        }
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;
        for (int i = 3; i < n; i++) {
            array[i] = array[i-1] + array[i-2] + array[i-3];
        }
        return array[array.length-1];
    }
}
