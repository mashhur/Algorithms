package leetcode;

import java.util.TreeMap;

public class MyCalendarImproved {

    TreeMap<Integer, Integer> calendar;

    public MyCalendarImproved() {
        calendar = new TreeMap<>();
    }

    public static void main(String args[]) {
        MyCalendarImproved calendar = new MyCalendarImproved();
        //System.out.println(calendar.book(10,20)); // true
        //System.out.println(calendar.book(15,25)); // false
        //System.out.println(calendar.book(20,30)); // true

        System.out.println(calendar.book(47, 50)); // true
        System.out.println(calendar.book(43, 51)); // false


    }

    public boolean book(int start, int end) {
        assert start < end;

        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start)
            return false;

        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end)
            return false;

        calendar.put(start, end);
        return true;
    }
}