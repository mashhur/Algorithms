package Leetcode;

class Book {

    int start;
    int end;
    int count;

    public Book(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Book(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}