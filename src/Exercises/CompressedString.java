package Exercises;

/**
 * Created by mashhur on 3/7/17.
 */
public class CompressedString {

    // Ex. : a3[b2[c1[d]]]e will be decompressed as abcdcdbcdcdbcdcde.
    public static void main(String args[]){
        final String sEncoded = "a3[b2[c1[d]]]e";
        System.out.println(encode(sEncoded));
    }

    private static String encode(String sEncoded){
        StringBuilder sb = new StringBuilder();

        // append a
        sb.append(sEncoded.charAt(0));


        return sb.toString();
    }

    // Ex. : [b2[c1[d]]] will be decompressed as abcdcdbcdcdbcdcde.
    static String encode(int nStart, int nEnd, String sEncoded){

        int nIdxStart = sEncoded.indexOf('[', nStart);

        String sCycle = "";
        for (int i=1; i<nIdxStart; i++){
            sCycle += sEncoded.charAt(i);
        }

        int nCycle = Integer.parseInt(sCycle);
        for (int i=0; i<nCycle; i++){
            //sb.append();
        }
        return "";
    }
}
