package codility;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Elevator {

    class Person {
        int weight;
        int floor;

        public Person(int weight, int floor) {
            this.weight = weight;
            this.floor = floor;
        }

        public int getWeight() {
            return weight;
        }

        public int getFloor() {
            return floor;
        }
    }

    public static void main(String[] args) {
        int[] people = {40,40,100,80,20};
        int[] destinations = {3,3,2,2,3};
        int floor = 3;
        int capacity = 5;
        int weight = 200;

        Elevator elevator = new Elevator();
        System.out.println(elevator.stops(people, destinations, floor, capacity, weight));
    }

    public int stops(int[] people, int[] destinations, int floor, int capacity, int weight) {
        int stops = 0;

        Queue<Person> queue = new LinkedList<>();
        for (int i=0; i<people.length; i++) {
            queue.add(new Person(people[i], destinations[i]));
        }

        while (queue.isEmpty() == false) {
            int fitWeight = 0;
            int fitCapacity = 0;
            HashSet<Integer> targetFloors = new HashSet<>();

            while (fitCapacity < capacity) {
                Person person = queue.peek();
                if (queue.isEmpty())
                    break;

                if (fitWeight + person.getWeight() > weight)
                    break;

                fitCapacity++;
                fitWeight += person.getWeight();
                targetFloors.add(person.getFloor());
                queue.remove();
            }

            stops += (targetFloors.size() + 1);
        }

        return stops;
    }
}
