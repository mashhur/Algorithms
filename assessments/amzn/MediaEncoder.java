package assessments.amzn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MediaEncoder {

    public static void main(String args[]) {

        //test();

        List<Integer> files = new ArrayList<>();
        /*files.add(8);
        files.add(4);
        files.add(6);
        files.add(12);

        System.out.println(minimumTime(4, files)); */

        files.add(1);
        files.add(2);
        files.add(5);
        files.add(10);
        files.add(35);
        files.add(89);


        System.out.println(minimumTime(6, files));

        /*list<Integer> files = new ArrayList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int file : files) {
            queue.add(file);
        }


        while (queue.isEmpty() == false) {
            int first = queue.peek(); queue.remove(first);
            int second = queue.peek(); queue.remove(second);
        }*/

    }

    static int minimumTime(int numOfSubFiles, List<Integer> files) {
        int sum = 0;
        final int maxFileSize = 1000000;

        if (numOfSubFiles < 2 || numOfSubFiles > maxFileSize)
            return sum;
        if (files.size() <= 0 || files.size() > numOfSubFiles)
            return sum;

        // track file sizes in a priority queue (PQ)
        // get first 2 elems of PQ and remove them
        // sum 2 elems and add to PQ
        // add sum to main sum

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int file : files) {
            queue.add(file);
        }

        while (queue.isEmpty() == false) { // O(N)
            Integer first = queue.peek(); queue.remove(first);
            Integer second = queue.peek();
            if (second != null) {
                int partSum = first + second;
                queue.remove(second); // O(LogN)
                queue.add(partSum); // O(1)
                sum += partSum;
            }
        }

        return sum;
    }


    private static void test() {
        // Creating an empty PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // Use add() method to add elements into the Queue
        queue.add(10);
        queue.add(15);
        queue.add(30);
        queue.add(20);
        queue.add(5);

        // Displaying the PriorityQueue
        System.out.println("Initial PriorityQueue: " + queue);

        // Fetching the element at the head of the queue
        System.out.println("The element at the head of the"
                + " queue is 1: " + queue.peek());

        queue.remove(queue.peek());

        System.out.println("The element at the head of the"
                + " queue is 2: " + queue.peek());

        queue.remove(queue.peek());

        System.out.println("The element at the head of the"
                + " queue is 3: " + queue.peek());

        // Displaying the Queue after the Operation
        System.out.println("Final PriorityQueue: " + queue);
    }

    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList) {

        List<List<Integer>> result = new ArrayList<>();

        // sum up forward & return route distances
        // cache sum value keying up with route id
        // list summed distances by reverse order
        // get summer distances from max side

        TreeMap<Integer, List<List<Integer>>> routeMap = new TreeMap<>(Collections.reverseOrder());

        for (List<Integer> forwardRoutes : forwardRouteList) {
            for (List<Integer> returnRoutes : returnRouteList) {
                int sum = forwardRoutes.get(1) + returnRoutes.get(1);

                if (routeMap.containsKey(sum) == false) {
                    routeMap.put(sum, new ArrayList<>());
                }

                // save route keys
                List<Integer> pairs = new ArrayList<>();
                pairs.add(forwardRoutes.get(0));
                pairs.add(returnRoutes.get(0));

                routeMap.get(sum).add(pairs);
            }
        }

        // find summed distances
        for (int sum : routeMap.keySet()) {
            if (sum <= maxTravelDist) {
                result = routeMap.get(sum);
                break;
            }
        }

        return result;
    }
}
