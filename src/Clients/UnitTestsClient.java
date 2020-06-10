package Clients;

import Models.Doctor;
import Models.Record;
import RequestClasses.*;
import RequestClasses.RequestResponseClasses.BooleanResponse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class UnitTestsClient {
    private static final String hostname = "127.0.0.1";
    private static final int portNumber = 44444;

    @Test
    public void addDoctorRequestTest() throws UnknownHostException,IOException,ClassNotFoundException{
        Socket clientSocket;

        clientSocket = new Socket(hostname, portNumber);

        OutputStream outputStream = clientSocket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        InputStream inputStream = clientSocket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        AddDoctorRequest addDoctorRequest = new AddDoctorRequest();
        addDoctorRequest.Doctor.setFirstName("lasha");
        addDoctorRequest.Doctor.setLastName("khoriashvili");

        objectOutputStream.writeObject(addDoctorRequest);// gagzavnaa
        addDoctorRequest = (AddDoctorRequest) objectInputStream.readObject(); //pasuxis migeba
        System.out.println("Server response: " + addDoctorRequest.Response);

        clientSocket.close();

        assertEquals(true , addDoctorRequest.Response.IsCompleted);
    }

    public static void main(String[] args) throws UnknownHostException,IOException,ClassNotFoundException {

    }
}
