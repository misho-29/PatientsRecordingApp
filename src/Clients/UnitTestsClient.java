package Clients;

import Models.Doctor;
import Models.Patient;
import Models.Record;
import RequestClasses.*;
import RequestClasses.RequestResponseClasses.BooleanResponse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

public class UnitTestsClient {
    private static final String hostname = "127.0.0.1";
    private static final int portNumber = 44444;

    Socket clientSocket = new Socket(hostname, portNumber);
    OutputStream outputStream = clientSocket.getOutputStream();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    InputStream inputStream = clientSocket.getInputStream();
    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

    public UnitTestsClient() throws IOException {
    }

    @Test
    public void addDoctorRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        AddDoctorRequest addDoctorRequest = new AddDoctorRequest();
        addDoctorRequest.Doctor.setFirstName("DobriiDoqtar");
        addDoctorRequest.Doctor.setLastName("Aibalit");

        objectOutputStream.writeObject(addDoctorRequest);// gagzavnaa
        addDoctorRequest = (AddDoctorRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("Server response: " + addDoctorRequest.Response.IsCompleted);

        assertEquals(true , addDoctorRequest.Response.IsCompleted);
    }

    @Test
    public void addPatientRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        AddPatientRequest addPatientRequest = new AddPatientRequest();
        addPatientRequest.Patient.setFirstName("lasha");
        addPatientRequest.Patient.setLastName("khoriashvili");

        objectOutputStream.writeObject(addPatientRequest);// gagzavnaa
        addPatientRequest = (AddPatientRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("Server response: " + addPatientRequest.Response.IsCompleted);

        assertEquals(true , addPatientRequest.Response.IsCompleted);
    }

    @Test
    public void addRecordRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        Patient patient = new Patient();
        patient.setFirstName("lasha");
        patient.setLastName("khoriashvili");
        patient.setId(10101);

        Doctor doctor = new Doctor();
        doctor.setFirstName("DobriiDoqtar");
        doctor.setLastName("Aibalit");
        doctor.setId(20202);

        AddRecordRequest addRecordRequest = new AddRecordRequest();
        addRecordRequest.Record.setDoctor(doctor);
        addRecordRequest.Record.setPatient(patient);
        addRecordRequest.Record.setRecordDateTime(LocalDateTime.now());

        objectOutputStream.writeObject(addRecordRequest);// gagzavnaa
        addRecordRequest = (AddRecordRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("Server response: " + addRecordRequest.Response.IsCompleted);

        assertEquals(true , addRecordRequest.Response.IsCompleted);
    }

    @Test
    public void DeleteRecordRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        Patient patient = new Patient();
        patient.setFirstName("lasha");
        patient.setLastName("khoriashvili");
        patient.setId(10101);

        Doctor doctor = new Doctor();
        doctor.setFirstName("DobriiDoqtar");
        doctor.setLastName("Aibalit");
        doctor.setId(20202);

        DeleteRecordRequest deleteRecordRequest = new DeleteRecordRequest();
        deleteRecordRequest.Record.setId(3);
        deleteRecordRequest.Record.setDoctor(doctor);
        deleteRecordRequest.Record.setPatient(patient);
        deleteRecordRequest.Record.setRecordDateTime(LocalDateTime.now());

        objectOutputStream.writeObject(deleteRecordRequest);// gagzavnaa
        deleteRecordRequest = (DeleteRecordRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("Server response: " + deleteRecordRequest.Response.IsCompleted);

        assertEquals(true , deleteRecordRequest.Response.IsCompleted);
    }

    @Test
    public void GetDoctorsRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        GetDoctorsRequest getDoctorsRequest = new GetDoctorsRequest();

        //cxrilshi eqimebis aryolis shemtxvevashic testi chabarebulad chaitvleba, tuki tavad methodi gamartulad mushaobs

        objectOutputStream.writeObject(getDoctorsRequest);// gagzavnaa
        getDoctorsRequest = (GetDoctorsRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("is List of doctors empty?: " + getDoctorsRequest.Response.Doctors.isEmpty());

        assertNotEquals(null,getDoctorsRequest.Response.Doctors);
    }

    @Test
    public void GetPatiensRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        GetPatientsRequest getPatientsRequest = new GetPatientsRequest();

        //cxrilshi pacientebis aryolis shemtxvevashic testi chabarebulad chaitvleba, tuki tavad methodi gamartulad mushaobs

        objectOutputStream.writeObject(getPatientsRequest);// gagzavnaa
        getPatientsRequest = (GetPatientsRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("is List of Patients epmty?: " + getPatientsRequest.Response.Patients.isEmpty());

        assertNotEquals(null,getPatientsRequest.Response.Patients);
    }

    @Test
    public void GetRecordsRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        GetRecordsRequest getRecordsRequest = new GetRecordsRequest();

        //cxrilshi pacientebis aryolis shemtxvevashic testi chabarebulad chaitvleba, tuki tavad methodi gamartulad mushaobs

        objectOutputStream.writeObject(getRecordsRequest);// gagzavnaa
        getRecordsRequest = (GetRecordsRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("is List of Records epmty?: " + getRecordsRequest.Response.Records.isEmpty());

        assertNotEquals(null,getRecordsRequest.Response.Records);
    }

    @Test
    public void UpdatePatientRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        UpdatePatientRequest updatePatientRequest = new UpdatePatientRequest();
        updatePatientRequest.Patient.setId(1);
        updatePatientRequest.Patient.setFirstName("lasha1");
        updatePatientRequest.Patient.setLastName("khoriashvili1");

        objectOutputStream.writeObject(updatePatientRequest);// gagzavnaa
        updatePatientRequest = (UpdatePatientRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("Server response: " + updatePatientRequest.Response.IsCompleted);

        assertEquals(true , updatePatientRequest.Response.IsCompleted);
    }

    @Test
    public void UpdateDoctorsRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        UpdateDoctorRequest updateDoctorRequest = new UpdateDoctorRequest();
        updateDoctorRequest.Doctor.setId(1);
        updateDoctorRequest.Doctor.setFirstName("lasha1");
        updateDoctorRequest.Doctor.setLastName("khoriashvili1");

        objectOutputStream.writeObject(updateDoctorRequest);// gagzavnaa
        updateDoctorRequest = (UpdateDoctorRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("Server response: " + updateDoctorRequest.Response.IsCompleted);

        assertEquals(true , updateDoctorRequest.Response.IsCompleted);
    }

    public static void main(String[] args) throws UnknownHostException,IOException,ClassNotFoundException {

    }
}
