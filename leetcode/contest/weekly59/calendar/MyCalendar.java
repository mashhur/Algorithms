package leetcode.contest.weekly59.calendar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mashhur on 11/19/17.
 */

class Book {
    int start;
    int end;

    Book(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MyCalendar {

    Map<Integer, Book> map = new HashMap<>();

    public static void main(String[] args) {
        MyCalendar mycalendar = new MyCalendar();
        // mycalendar.book(10, 20); returns true
        // mycalendar.book(15, 25); // returns false
        // mycalendar.book(20, 30); // returns true
        //System.out.println(mycalendar.book(10, 20));
        //System.out.println(mycalendar.book(15, 25));
        //System.out.println(mycalendar.book(20, 30));

        //System.out.println(mycalendar.book(48, 50));
        //System.out.println(mycalendar.book(49, 50));


        // [10,20], [50,60],[10,40],[5,15], [5,10], [25,55]
        // [true,   true,   true,   false,  true,   true]
        System.out.println(mycalendar.book2(10, 20));
        System.out.println(mycalendar.book2(50, 60));
        System.out.println(mycalendar.book2(10, 40));
        System.out.println(mycalendar.book2(5, 15));
        System.out.println(mycalendar.book2(5, 10));
        System.out.println(mycalendar.book2(25, 55));
    }

    public boolean book(int start, int end) {
        end = end - 1;
        if (start > end) return false;

        for (Map.Entry<Integer, Book> entry : map.entrySet()) {

            // date mismatch 1
            if (start >= entry.getValue().start && start < entry.getValue().end
                    && end > entry.getValue().end) {
                return false;
            }

            // date mismatch 2
            if (start <= entry.getValue().start && end > entry.getValue().start
                    && end <= entry.getValue().end) {
                return false;
            }

            // date mismatch 3
            if (start <= entry.getValue().start && end >= entry.getValue().end) {
                return false;
            }

            // double booking
            if (start >= entry.getValue().start && end <= entry.getValue().end) {
                return false;
            }
        }
        map.put(map.size(), new Book(start, end));

        return true;
    }

    public boolean book2(int start, int end) {
        end = end - 1;
        if (start > end) return false;

        int start_intersection = 0;
        int end_intersection = 0;
        for (Map.Entry<Integer, Book> entry : map.entrySet()) {

            // date mismatch 1
            if (start <= entry.getValue().start && end > entry.getValue().start
                    && end <= entry.getValue().end) {
                end_intersection++;
            }

            // date mismatch 2
            if (start >= entry.getValue().start && start < entry.getValue().end
                    && end > entry.getValue().end) {
                start_intersection++;
            }

            // double booking
            if (start >= entry.getValue().start && end <= entry.getValue().end) {
                return false;
            }

            if (start_intersection == 2 || end_intersection == 2)
                return false;
        }
        map.put(map.size(), new Book(start, end));

        return true;
    }
}
