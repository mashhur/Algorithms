package AmznInterviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mashhur on 1/14/17.
 */
public class FirstNonRepeaterChar {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        boolean bFound = false;
        List<Character> lst = new ArrayList<Character>();
        char[] chArr = str.toCharArray();
        for (int i=chArr.length-1; i>=0; i--){
            if(lst.contains(chArr[i])){
                System.out.println(chArr[i]);
                bFound = true;
                break;
            }
            else lst.add(chArr[i]);
        }

        if(!bFound)
            System.out.println("First non-repeated char not found!");
    }
}
