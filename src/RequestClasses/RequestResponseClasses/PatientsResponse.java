package RequestClasses.RequestResponseClasses;

import Models.Patient;

import java.io.Serializable;
import java.util.ArrayList;

public class PatientsResponse implements Serializable {
    public ArrayList<Patient> Patients;
}
