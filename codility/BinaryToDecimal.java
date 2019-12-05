package codility;

public class BinaryToDecimal {

    public static void main(String[] args) {
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        System.out.println(binaryToDecimal.binaryToDecimal("01110"));
    }

    public int binaryToDecimal(String binary) {
        if (binary == null || binary.isEmpty() == true)
            throw new NumberFormatException(binary);

        return binaryToDecimal(binary, binary.length(), 2, 0);
    }

    private int binaryToDecimal(String binary, int index, int radix, int decimal) {
        if (index == 0)
            return decimal;

        index--;
        int number = binary.charAt(index) == '0' ? 0 : 1;
        decimal += (number * Math.pow(radix, binary.length() - index - 1));

        return binaryToDecimal(binary, index, radix, decimal);
    }
}
