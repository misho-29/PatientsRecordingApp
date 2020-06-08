package Server;

import Models.Doctor;
import Models.Patient;
import Models.Record;
import RequestClasses.*;

import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RunnableSocket implements Runnable {
    protected Socket clientSocket = null;

    public RunnableSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            while(true) {
                Request request = (Request) objectInputStream.readObject();
                RequestAction requestAction = request.RequestAction;
                System.out.println("Client Says: " + request.RequestAction);
                switch(requestAction) {
                    case ADDDOCTOR:
                        // code block
                        AddDoctorRequest addDoctorRequest = (AddDoctorRequest)request;
                        addDoctorRequest.Response.IsCompleted = DataAccess.createDoctor(addDoctorRequest.Doctor);
                        objectOutputStream.writeObject(addDoctorRequest);
                        break;
                    case ADDPATIENT:
                        AddPatientRequest addPatientRequest = (AddPatientRequest)request;
                        addPatientRequest.Response.IsCompleted = DataAccess.createPatient(addPatientRequest.Patient);
                        objectOutputStream.writeObject(addPatientRequest);
                        break;
                    case ADDRECORD:
                        AddRecordRequest addRecordRequest = (AddRecordRequest)request;
                        addRecordRequest.Response.IsCompleted = DataAccess.createRecord(addRecordRequest.Record);
                        objectOutputStream.writeObject(addRecordRequest);
                        break;
                    case UPDATEDOCTOR:
                        UpdateDoctorRequest updateDoctorRequest = (UpdateDoctorRequest)request;
                        updateDoctorRequest.Response.IsCompleted = DataAccess.setDoctor(updateDoctorRequest.Doctor);
                        objectOutputStream.writeObject(updateDoctorRequest);
                        break;
                    case UPDATEPATIENT:
                        UpdatePatientRequest updatePatientRequest = (UpdatePatientRequest)request;
                        updatePatientRequest.Response.IsCompleted = DataAccess.setPatient(updatePatientRequest.Patient);
                        objectOutputStream.writeObject(updatePatientRequest);
                        break;
                    case DELETERECORD:
                        DeleteRecordRequest deleteRecordRequest = (DeleteRecordRequest)request;
                        deleteRecordRequest.Response.IsCompleted = DataAccess.deleteRecord(deleteRecordRequest.Record);
                        objectOutputStream.writeObject(deleteRecordRequest);
                        break;
                    case GETDOCTORS:
                        GetDoctorsRequest getDoctorsRequest = (GetDoctorsRequest)request;
                        getDoctorsRequest.Response.Doctors = DataAccess.getDoctors();
                        objectOutputStream.writeObject(getDoctorsRequest);
                        break;
                    case GETPATIENTS:
                        GetPatientsRequest getPatientsRequest = (GetPatientsRequest)request;
                        getPatientsRequest.Response.Patients = DataAccess.getPatients();
                        objectOutputStream.writeObject(getPatientsRequest);
                        break;
                    case GETRECORDS:
                        GetRecordsRequest getRecordsRequest = (GetRecordsRequest)request;
                        getRecordsRequest.Response.Records = DataAccess.getRecords();
                        objectOutputStream.writeObject(getRecordsRequest);
                        break;
                    default:
                        // code block
                }
            }
        } catch (IOException  e) {

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
            System.exit(1);
        }

    }
}
