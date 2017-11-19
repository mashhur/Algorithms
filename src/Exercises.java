import java.util.*;

/**
 * Created by mashhur on 11/12/16.
 */
public class Exercises {

    // Converts decimal to binary
    static String ConvertDecimalToBinary(int n) {
        if(n < Integer.MIN_VALUE || n> Integer.MAX_VALUE) return "";

        StringBuilder sb = new StringBuilder();
        int nRemain = n;
        while (n >= 2){
            nRemain = n % 2;
            n = n/2;
            sb.append(nRemain);
        }
        sb.append(n);
        sb.reverse();
        return sb.toString();
    }

    // Converts binary string to integer
    static int ConvertBinaryToInteger(String sBinary){
        char[] chArr = sBinary.toCharArray();
        int n = chArr.length-1;
        int nSum = 0;
        for (int i=n; i>=0; i--){
            //System.out.print(chArr[i]);
            //if(chArr[i] != '1' || chArr[i] != '0') return -1;
            if(chArr[i] == '1')
                nSum += Math.pow(2, n-i);
        }

        return nSum;
    }

    // Converts decimal to hexa
    static String ConvertDecimalToHexa(int n) {
        if(n < Integer.MIN_VALUE || n> Integer.MAX_VALUE) return "";

        // Digits in hexadecimal number system
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        StringBuilder sb = new StringBuilder();
        int nRemain = 0;
        while(n>0)
        {
            nRemain=n%16;
            sb.append(hex[nRemain]);
            n=n/16;
        }
        sb.reverse();
        return sb.toString();
    }

    // converts hexa string to decimal
    static int ConvertHexaToDecimal(String sHexa) {
        String hex = "0123456789ABCDEF";
        char[] chArr = sHexa.toCharArray();
        int n = chArr.length-1;
        int nSum = 0;
        for (int i=n; i>=0; i--){
            //System.out.print(chArr[i]);
            nSum += hex.indexOf(chArr[i]) * Math.pow(16, n-i);
        }
        return nSum;
    }

    // Greatest Common Divisor/Factor
    static int gcd(int n1, int n2){
        if(n1 < Integer.MIN_VALUE || n1> Integer.MAX_VALUE) return -1;
        if(n2 < Integer.MIN_VALUE || n2> Integer.MAX_VALUE) return -1;

        return n1 ^ n2;
    }

    // Least Common Denominator
    static int lcd(int n1, int n2){
        if(n1 < Integer.MIN_VALUE || n1> Integer.MAX_VALUE) return -1;
        if(n2 < Integer.MIN_VALUE || n2> Integer.MAX_VALUE) return -1;

        int n = gcd(n1, n2);
        if(n == -1)
            return -1;

        return n * n1/n * n2/n;
    }


    public static void main(String[] args){
        System.out.println("Main Run");

        System.out.println(judgeCircle("UDLLRLDDRURU"));
    }


    // string solution
    public static boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int i = arr[0] == '-' ? 1 : 0, j=arr.length-1;
        while (i<j) {
            if(arr[i] != arr[j])
                return false;
            i++;
            j--;
        }

        return true;
    }

    // divide by 10 + remain solution
    public static boolean isPalindrome2(int x) {

        int last_idx = x/10;

        return true;
    }

    public static boolean judgeCircle(String moves) {
        Map<Integer, Character> map = new HashMap<>();
        char arr[] = moves.toCharArray();

        int idx = 0;
        for(char ch : arr) {
            idx++;
            boolean bRes = false;
            switch (ch) {
                case 'U':
                    bRes = deleteMove(map, 'D');
                    break;
                case 'D':
                    bRes = deleteMove(map, 'U');
                    break;
                case 'L':
                    bRes = deleteMove(map, 'R');
                    break;
                case 'R':
                    bRes = deleteMove(map, 'L');
                    break;
            }

            if(bRes == false)
                map.put(idx, ch);
        }

        return map.isEmpty();
    }

    public static boolean deleteMove(Map<Integer, Character> map, char ch) {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int idx = iterator.next();
            if(map.get(idx) == ch) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
