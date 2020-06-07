package Models;

import java.io.Serializable;

public class Person implements Serializable {
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firsName) {
        FirstName = firsName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    private String FirstName;
    private String LastName;
}
