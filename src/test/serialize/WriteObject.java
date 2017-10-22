package test.serialize;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject{

    public static void main (String args[]) {

        Address address = new Address();
        address.setStreet("wall street");
        address.setCountry("united states");

        Student student = new Student();
        student.setId(1);
        student.setName("Student Name");

        try {

            FileOutputStream fout = new FileOutputStream("c:\\address.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(address);
            oos.close();

            FileOutputStream fout1 = new FileOutputStream("c:\\student.ser");
            ObjectOutputStream oos1 = new ObjectOutputStream(fout1);
            oos1.writeObject(student);
            oos1.close();

            System.out.println("Done");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}