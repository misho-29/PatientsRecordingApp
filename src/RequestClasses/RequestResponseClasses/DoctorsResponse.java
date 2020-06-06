package RequestClasses.RequestResponseClasses;

import Models.Doctor;
import Models.Record;

import java.io.Serializable;
import java.util.ArrayList;

public class DoctorsResponse implements Serializable {
    public ArrayList<Doctor> Doctors;
}
