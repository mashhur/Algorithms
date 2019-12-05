package codility;

import java.util.HashMap;

public class StepsToZero {

    // Memoization
    // Save <Number, Steps>
    private HashMap<Integer, Integer> memory;

    public static void main(String[] args) {

        StepsToZero instance = new StepsToZero();
        System.out.println(instance.solution("011100"));
    }

    public int solution(String binary) {
        // convert to int
        int number = Integer.valueOf(binary, 2);
        memory = new HashMap<>();

        int steps = 0;
        while (number > 0) {
            steps++;

            if (number % 2 == 0) {
                number = divide(number);
            } else {
                number = subtract(number);
            }

            if (memory.get(number) != null) {
                return steps + memory.get(number);
            } else {
                memory.put(number, steps);
            }
        }

        return steps;
    }

    private int subtract(int number) {
        return number - 1;
    }

    private int divide(int number) {
        return number / 2;
    }

}
