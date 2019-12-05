package utils;

/**
 * Created by mashhur on 12/24/16.
 */
public class Utils {

    // Converts decimal to binary
    static String convertDecimalToBinary(int n) {
        if (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) return "";

        StringBuilder sb = new StringBuilder();
        int nRemain = n;
        while (n >= 2) {
            nRemain = n % 2;
            n = n / 2;
            sb.append(nRemain);
        }
        sb.append(n);
        sb.reverse();
        return sb.toString();
    }

    // Converts binary string to integer
    static int convertBinaryToInteger(String sBinary) {
        char[] chArr = sBinary.toCharArray();
        int n = chArr.length - 1;
        int nSum = 0;
        for (int i = n; i >= 0; i--) {
            //System.out.print(chArr[i]);
            //if(chArr[i] != '1' || chArr[i] != '0') return -1;
            if (chArr[i] == '1')
                nSum += Math.pow(2, n - i);
        }

        return nSum;
    }

    // Converts decimal to hexa
    static String convertDecimalToHexa(int n) {
        if (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) return "";

        // Digits in hexadecimal number system
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        int nRemain = 0;
        while (n > 0) {
            nRemain = n % 16;
            sb.append(hex[nRemain]);
            n = n / 16;
        }
        sb.reverse();
        return sb.toString();
    }

    // converts hexa string to decimal
    static int convertHexaToDecimal(String sHexa) {
        String hex = "0123456789ABCDEF";
        char[] chArr = sHexa.toCharArray();
        int n = chArr.length - 1;
        int nSum = 0;
        for (int i = n; i >= 0; i--) {
            //System.out.print(chArr[i]);
            nSum += hex.indexOf(chArr[i]) * Math.pow(16, n - i);
        }
        return nSum;
    }

    // Greatest Common Divisor/Factor
    static int gcd(int n1, int n2) {
        if (n1 < Integer.MIN_VALUE || n1 > Integer.MAX_VALUE) return -1;
        if (n2 < Integer.MIN_VALUE || n2 > Integer.MAX_VALUE) return -1;

        return n1 ^ n2;
    }

    // Least Common Denominator
    static int lcd(int n1, int n2) {
        if (n1 < Integer.MIN_VALUE || n1 > Integer.MAX_VALUE) return -1;
        if (n2 < Integer.MIN_VALUE || n2 > Integer.MAX_VALUE) return -1;

        int n = gcd(n1, n2);
        if (n == -1)
            return -1;

        return n * n1 / n * n2 / n;
    }

    public static void swap(int[] arr, int m, int n) {
        if (m >= arr.length || m < 0) return;
        if (n >= arr.length || n < 0) return;

        int nTemp = arr[m];
        arr[m] = arr[n];
        arr[n] = nTemp;
    }

    public static void quickSort(char[] ar) {
        partition(ar, 0, ar.length - 1);
    }

    private static void partition(char[] ar, int left, int right) {
        int pivot = ar[left + (right - left) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (ar[i] < pivot)
                i++;
            while (ar[j] > pivot)
                j--;

            if (i <= j) {
                swapChar(ar, i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            partition(ar, left, j);
        }
        if (i < right)
            partition(ar, i, right);
    }

    private static void swapChar(char[] ar, int n, int k) {
        char nVal = ar[n];
        ar[n] = ar[k];
        ar[k] = nVal;
        //printArray(ar);
    }
}
