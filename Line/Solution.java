package Line;

import java.util.Scanner;

public class Solution {
    private String[] elems;
    private int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = scanner.nextInt();
        int size = scanner.nextInt();

        // initialize FIFO with size
        Solution fifo = new Solution();
        fifo.initialize(size);

        scanner.nextLine();
        while (commands > 0) {
            commands--;
            String[] line = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "OFFER":
                    // push
                    System.out.println(fifo.offer(line[1]));
                    break;
                case "TAKE":
                    // pop
                    System.out.println(fifo.take());
                    break;
                case "SIZE":
                    // return size
                    System.out.println(fifo.size());
                    break;
                default:
                    break;
            }
        }
    }

    public void initialize(int size) {
        this.elems = new String[size];
    }

    public boolean offer(String elem) {
        if (size >= this.elems.length)
            return false;
        this.elems[size] = elem;
        this.size++;
        return true;
    }

    public String take() {
        if (this.size <= 0)
            return "";

        this.size--;
        String elem = this.elems[0];
        fifonize();
        return elem;
    }

    private void fifonize() {
        for (int i = 1; i < this.elems.length; i++) {
            this.elems[i - 1] = this.elems[i];
        }
    }

    public int size() {
        return this.size;
    }
}