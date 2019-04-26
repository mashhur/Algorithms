package hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by mashhur on 2/10/17.
 */
public class PriorityQueueProblem {
    /*
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = in.nextInt();
        in.nextLine();
        PriorityQueue<Student> pr_queue = new PriorityQueue<>();
        while (totalEvents > 0) {
            String event = in.nextLine();
            String[] strArr = event.split(" ");
            if (strArr[0].equals("ENTER")) {
                // insert to queue
                //System.out.println("Add : " + strArr[1]);
                pr_queue.add(new Student(Integer.parseInt(strArr[3]), strArr[1], Double.parseDouble(strArr[2])));
            } else {
                // serve from queue
                Student st_poll = pr_queue.poll();
                //System.out.println("Poll : " + st_poll.getFname());
            }

            totalEvents--;
        }

        if (pr_queue.isEmpty())
            System.out.println("EMPTY");
        while (!pr_queue.isEmpty()) {
            Student st_poll = pr_queue.poll();
            System.out.println(st_poll.getFname());
        }
    }
}


class Student implements Comparable<Student> {
    private int token;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int compareTo(Student student) {
        if (student.getCgpa() > getCgpa()) {
            return 1;
        } else if (student.getCgpa() < getCgpa()) {
            return -1;
        } else {
            int nNameCompare = getFname().compareTo(student.getFname());
            if (nNameCompare == 0) {
                if (student.getToken() > getToken())
                    return 1;
                else if (student.getToken() < getToken())
                    return -1;
                else return 0;
            } else return (nNameCompare > 0) ? 1 : -1;
        }
    }
}