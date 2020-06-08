package Clients;

import Models.Doctor;
import Models.Record;
import RequestClasses.*;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class UnitTestsClient {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int portNumber = 44444;
        Socket clientSocket;

        try {
            System.out.println("Client");
            clientSocket = new Socket(hostname, portNumber);

            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            UpdateDoctorRequest updateDoctorRequest = new UpdateDoctorRequest();
            updateDoctorRequest.Doctor.setId(2);
            updateDoctorRequest.Doctor.setFirstName("aaaa");
            objectOutputStream.writeObject(updateDoctorRequest);
            updateDoctorRequest = (UpdateDoctorRequest) objectInputStream.readObject();
            System.out.println("Server response: " + updateDoctorRequest.Response.IsCompleted);

            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
