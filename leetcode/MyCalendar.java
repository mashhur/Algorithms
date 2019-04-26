package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    private List<Book> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public static void main(String args[]) {
        MyCalendar calendar = new MyCalendar();
        //System.out.println(calendar.book(10,20)); // true
        //System.out.println(calendar.book(15,25)); // false
        //System.out.println(calendar.book(20,30)); // true

        System.out.println(calendar.book(47, 50)); // true
        System.out.println(calendar.book(43, 51)); // false


    }

    public boolean book(int start, int end) {
        for (Book book : bookings) {
            if (start >= book.getStart() && start < book.getEnd()) {
                return false;
            }
            if (end > book.getStart() && end <= book.getEnd()) {
                return false;
            }
            if (start <= book.getStart() && end >= book.getEnd()) {
                return false;
            }
        }
        bookings.add(new Book(start, end));
        return true;
    }
}