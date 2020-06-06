package Models;

import java.io.Serializable;

public class Doctor extends Person implements Serializable {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int Id;
}
