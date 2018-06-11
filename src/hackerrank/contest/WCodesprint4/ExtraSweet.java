package hackerrank.contest.WCodesprint4;

import java.util.*;

/**
 * Created by mashhur on 10/28/17.
 */

class ChocoBar {
    int left;
    int right;

    ChocoBar(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class ExtraSweet {

    /*
        10 3
        2 4
        6 7
        9 9
    * output: 15 21 9 */
    /*
        10 2
        3 3
        5 6
    * output: 9 19 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // choco size
        int s = in.nextInt(); // num of students

        ChocoBar chocoBars[] = new ChocoBar[n];
        chocoBars[0] = new ChocoBar(0, 1);
        for (int i=1; i<n-1; i++)
            chocoBars[i] = new ChocoBar(i-1,i+1);
        chocoBars[n-1] = new ChocoBar(n-1, n);

        for(int a0 = 0; a0 < s; a0++) { // student sequence
            int l = in.nextInt(); // from
            int r = in.nextInt(); // to

            // lef closest available block
            ChocoBar chocoBarLeft = chocoBars[l];
            int left = chocoBarLeft.left;
            int sweetness = left;

            // student takes blocks
            int k = l-1;
            sweetness += (r*(r+1)/2 - k*(k+1)/2);

            // right closest available
            ChocoBar chocoBarRight = chocoBars[r];
            sweetness += chocoBarRight.right;

            if(left-1 > 0 && chocoBarRight.right + 1 < chocoBars.length) {
                chocoBars[chocoBarRight.right + 1].left = left - 1;
                chocoBars[left - 1].right = chocoBarRight.right + 1;
            }

            System.out.println(sweetness);
        }
        in.close();
    }
}
