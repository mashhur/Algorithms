import ccinterview.LeftRotation;

import java.util.ArrayList;
import java.util.Scanner;

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

        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // int to binary test
        String sBinary = ConvertDecimalToBinary(n);
        System.out.println(n + " to binary : " + sBinary);

        // binary to int test
        int nRes = ConvertBinaryToInteger(sBinary);
        System.out.println(sBinary + " to integer : " + nRes);

        // decimal to hexa test
        String sHexa = ConvertDecimalToHexa(n);
        System.out.println(n + " to hexa : " + sHexa);

        // hexa to decimal test
        n = ConvertHexaToDecimal(sHexa);
        System.out.println(sHexa + " to decimal : " + n);

        // Greatest Common Factor test
        System.out.println("GCF : " + gcd(30, 20));

        // Least Common Denominator test
        System.out.println("LCD : " + lcd(30, 20));
        */

        /*
        // test of my queue
        MyQueue<Object> nQueue = new MyQueue<>();

        Node<Integer> node1 = new Node<>();
        node1.data = 1;
        nQueue.put(node1);

        Node<String> node2 = new Node<>();
        node2.data = "2";
        nQueue.put(node2);

        Node<String> node3 = new Node<>();
        node3.data = "3";
        nQueue.put(node3);

        nQueue.getSize();
        nQueue.print();

        Node node = nQueue.pop();
        nQueue.getSize();
        nQueue.print();
        */

        /*
        // test of my stack
        MyStack<Object> sStack = new MyStack<>();
        Node<Integer> node1 = new Node<>();
        node1.data = 1;
        sStack.push(node1);

        Node<String> node2 = new Node<>();
        node2.data = "2";
        sStack.push(node2);

        Node<String> node3 = new Node<>();
        node3.data = "3";
        sStack.push(node3);

        sStack.getSize();
        sStack.print();

        while (sStack.getSize() > 0)
            sStack.pop();

        sStack.print();
        */
    }
}
