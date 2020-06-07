package Models;

import java.io.Serializable;

public class Patient extends Person implements Serializable {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private int Id;
}
