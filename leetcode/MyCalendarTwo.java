package leetcode;

import java.util.ArrayList;
import java.util.List;

class Book {
    int start;
    int end;
    int count;
}

public class MyCalendarTwo {

    int min = 0;
    int max = 0;
    private List<Book> bookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (start >= max || end <= min) {
            //modifyBookingTable(start, end);
            return true;
        }

        //if (checkIfCanbeBooked(start, end)) {
        //    modifyBookingTable(start, end);
        //    return true;
        //}

        return false;
    }

    public static void main(String args[]) {
        // Your MyCalendarTwo object will be instantiated and called as such:
        MyCalendarTwo calendar = new MyCalendarTwo();
        System.out.println(calendar.book(10, 20));
    }
}
