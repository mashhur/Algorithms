package hackerrank.contest.RookiRank2;

import java.util.*;

/**
 * Created by mashhur on 2/11/17.
 */
public class AbsDiffInArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> nList = new ArrayList<>();
        for(int i=0; i < n; i++){
            nList.add(in.nextInt());
        }
        List<Integer> nDiff = new ArrayList<>();
        Collections.sort(nList);
        for (int i=0; i<nList.size()-1; i++){
            nDiff.add(Math.abs(nList.get(i) - nList.get(i+1)));
        }
        Collections.sort(nDiff);
        System.out.println(nDiff.get(0));
    }
}
