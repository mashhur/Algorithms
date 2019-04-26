package test.serialize;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;

public class ReadObject {

    public static void main(String args[]) {

        Date date1 = new Date(System.currentTimeMillis() + (1000 * 60 * 10));
        Date date2 = new Date(System.currentTimeMillis() + (1000 * 60 * 11));

        System.out.println(date2.compareTo(date1));

        Address address;
        Student student;

        try {

            FileInputStream fin = new FileInputStream("c:\\address.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            address = (Address) ois.readObject();
            ois.close();

            System.out.println(address);


            FileInputStream fin1 = new FileInputStream("c:\\student.ser");
            ObjectInputStream ois1 = new ObjectInputStream(fin1);
            student = (Student) ois1.readObject();
            ois1.close();

            System.out.println(student);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}