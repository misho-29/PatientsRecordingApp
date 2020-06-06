package Models;

import java.io.Serializable;

public class Person implements Serializable {
    public String getFirtsName() {
        return FirstName;
    }

    public void setFirsName(String firsName) {
        FirstName = firsName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String FirstName;
    public String LastName;
}
