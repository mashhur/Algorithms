package line;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class MaxWindow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        if (size <= 0) { // TODO: consider max 3000000000L value
            System.out.println("Invalid window size.");
            return;
        }
        // a priority queue to hold max values
        PriorityQueue<Long> pQueue = new PriorityQueue<>(size, Collections.reverseOrder());

        scanner.nextLine();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals(""))
                break;

            long stream = Long.parseLong(line);
            if (stream < -3000000000L || stream > 3000000000L) {
                System.out.println("Invalid stream value applied.");
                return;
            }

            if (pQueue.isEmpty() == false)
                System.out.println(pQueue.peek());
            //if (pQueue.size() >= size)
            //pQueue.peek()
            pQueue.add(stream);
        }
    }
}