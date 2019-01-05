package test.serialize;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    String street;
    String country;

    public void setStreet(String street){
        this.street = street;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getStreet(){
        return this.street;
    }

    public String getCountry(){
        return this.country;
    }

    @Override
    public String toString() {
        return new StringBuffer(" Street : ")
                .append(this.street)
                .append(" Country : ")
                .append(this.country).toString();
    }
}