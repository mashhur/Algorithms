package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    private List<Book> bookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
    }

    public static void main(String args[]) {
        MyCalendarTwo calendar = new MyCalendarTwo();
        /*
        System.out.println(calendar.book(10,20)); // true
        System.out.println(calendar.book(50,60)); // true
        System.out.println(calendar.book(10,40)); // true
        System.out.println(calendar.book(5, 15)); // false
        System.out.println(calendar.book(5, 10)); // true
        System.out.println(calendar.book(25,55)); // true
        */
        System.out.println(calendar.book(10, 20)); // true
        System.out.println(calendar.book(30, 40)); // true
        System.out.println(calendar.book(35, 45)); // true
        System.out.println(calendar.book(10, 40)); // false
        // [10,20] [30,40],[35,45] -> [10,40]
        // [10,20->1], [30,35->1], [35,40->2], [40,45->1]
    }

    public boolean book(int start, int end) {
        // TODO
        return true;
    }
}