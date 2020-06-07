package Models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Record implements Serializable {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor doctor) {
        Doctor = doctor;
    }

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient patient) {
        Patient = patient;
    }

    public LocalDateTime getRecordDateTime() {
        return RecordDateTime;
    }

    public void setRecordDateTime(LocalDateTime recordDateTime) {
        RecordDateTime = recordDateTime;
    }

    private int Id;
    private Doctor Doctor;
    private Patient Patient;
    private LocalDateTime RecordDateTime;
}
