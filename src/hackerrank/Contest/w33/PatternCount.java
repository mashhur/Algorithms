package hackerrank.Contest.w33;

import java.util.Scanner;

/**
 * Created by mashhur on 7/22/17.
 */
public class PatternCount {

    static int patternCount(String s) {
        int count = 0;
        char[] chArr = s.toCharArray();
        boolean bOne = false;
        boolean bZero = false;
        for (int i=0; i<chArr.length; i++) {
            if(chArr[i] == '1') {
                if(!bOne)
                    bOne = true;
                else {
                    if (bZero)
                        count++;
                }
                bZero = false;
            } else if(chArr[i] == '0') {
                if(bOne)
                    bZero = true;
            } else {
                bOne = false;
                bZero = false;
            }
        }

        return count;
    }
    /*
    4
    100001abc101
    1001ab010abc01001
    1001010001
    1111000000000011111
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = patternCount(s);
            System.out.println(result);
        }
    }

}
