package Models;

import java.time.LocalDateTime;

public class Record {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Models.Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Models.Doctor doctor) {
        Doctor = doctor;
    }

    public Models.Patient getPatient() {
        return Patient;
    }

    public void setPatient(Models.Patient patient) {
        Patient = patient;
    }

    public LocalDateTime getRecordDateTime() {
        return RecordDateTime;
    }

    public void setRecordDateTime(LocalDateTime recordDateTime) {
        RecordDateTime = recordDateTime;
    }

    public int Id;
    public Doctor Doctor;
    public Patient Patient;
    public LocalDateTime RecordDateTime;
}
