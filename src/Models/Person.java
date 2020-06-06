package Models;

import java.io.Serializable;

public class Person implements Serializable {
    public String getFirsName() {
        return FirsName;
    }

    public void setFirsName(String firsName) {
        FirsName = firsName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String FirsName;
    public String LastName;
}
