package Backtracking;

public class PrintBinary {

    public static void main(String[] args) {
        PrintBinary printBinary = new PrintBinary();
        printBinary.printBinary(5, "");
    }

    public void printBinary(int digit, String prefix) {
        if (digit == 0)
            return;

        if (digit == 1) {
            System.out.println(prefix + "0");
            System.out.println(prefix + "1");
        } else {
            printBinary(digit - 1, prefix + "0");
            printBinary(digit - 1, prefix + "1");
        }
    }
}
