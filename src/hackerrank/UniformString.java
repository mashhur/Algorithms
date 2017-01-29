package hackerrank;

import java.util.*;
import Utils.Utils;

class UniformStrNode {
    char c;
    int weight = 0;
    int nRepated = 0;
}

/**
 * Created by mashhur on 1/28/17.
 */
public class UniformString {
    public static void main(String args[]){
        Map<Character, Integer> nWeightMap = getWeightMap();
        List<UniformStrNode> nList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String sStr = sc.next();
        char[] chArr = sStr.toCharArray();

        UniformStrNode item = new UniformStrNode();
        item.c = chArr[0];
        item.weight = nWeightMap.get(chArr[0]);
        item.nRepated = 1;
        boolean bLastInsert = false;
        for (int i=1; i<chArr.length; i++){
            if(item.c == chArr[i])
                item.nRepated++;
            else {
                nList.add(item);
                item = new UniformStrNode();
                item.c = chArr[i];
                item.weight = nWeightMap.get(chArr[i]);
                item.nRepated = 1;
            }
        }
        nList.add(item);

        /*for (UniformStrNode i : nList) {
            System.out.println("Char: " + i.c +
                             "; Weight: " + i.weight +
                             "; Repeat count: " + i.nRepated);
        }*/

        int n = sc.nextInt();
        for(int q = 0; q < n; q++){
            int nSum = sc.nextInt();
            boolean bFound = false;
            //System.out.println(nSum);
            for ( UniformStrNode i : nList) {
                // 1st filter
                int nCurrWeight = i.nRepated * i.weight;
                if(nCurrWeight == nSum){
                    System.out.println("Yes");
                    bFound = true; break;
                }
                // 2nd filter
                if(i.weight != 1 && nCurrWeight % nSum == 0 && nSum % i.weight == 0) {
                    System.out.println("Yes");
                    bFound = true; break;
                }

                // 3nd filter
                if(i.weight != 1 && nSum%i.weight == 0 &&
                        (i.nRepated > nSum / i.weight)) {
                    System.out.println("Yes");
                    bFound = true; break;
                }
                // 4th filter
                if(i.weight == 1){
                    if(i.nRepated >= nSum){
                        System.out.println("Yes");
                        bFound = true; break;
                    }
                }
            }
            if(!bFound)
                System.out.println("No");
        }
    }

    private static Map<Character, Integer> getWeightMap(){
        // weight list
        Map<Character, Integer> nMap = new HashMap<>();
        int nCurrWeight = 0;
        for(char ch='a'; ch<='z'; ch++){
            nCurrWeight++;
            nMap.put(ch, nCurrWeight);
        }

        return nMap;
    }
}
