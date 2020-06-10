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
        addDoctorRequest.Doctor.setFirstName("DobriiDoqtat");
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

    public static void main(String[] args) throws UnknownHostException,IOException,ClassNotFoundException {

    }
}
