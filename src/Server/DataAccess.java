package Server;

import Models.Doctor;
import Models.Patient;
import Models.Record;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DataAccess {

    private DataAccess(){}

    public static ArrayList<Doctor> getDoctors(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM doctors");

            ArrayList<Doctor> doctors = new ArrayList<Doctor>();

            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setFirstName(resultSet.getString("first_name"));
                doctor.setLastName(resultSet.getString("last_name"));
                doctors.add(doctor);
            }
            return doctors;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<Doctor>();
        }
    }

    public static ArrayList<Patient> getPatients(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM patients");

            ArrayList<Patient> patients = new ArrayList<Patient>();

            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("id"));
                patient.setFirstName(resultSet.getString("first_name"));
                patient.setLastName(resultSet.getString("last_name"));
                patients.add(patient);
            }
            return patients;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<Patient>();
        }
    }

    public static ArrayList<Record> getRecords(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM records INNER JOIN patients ON patients.id = records.patient_id INNER JOIN doctors ON doctors.id = records.doctor_id");

            ArrayList<Record> records = new ArrayList<Record>();

            while (resultSet.next()) {
                // prepare patient for records
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("patient_id"));
                patient.setFirstName(resultSet.getString("patients.first_name"));
                patient.setLastName(resultSet.getString("patients.last_name"));

                // prepare doctor for records
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("doctor_id"));
                doctor.setFirstName(resultSet.getString("doctors.first_name"));
                doctor.setLastName(resultSet.getString("doctors.last_name"));

                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setRecordDateTime(resultSet.getObject("datetime", LocalDateTime.class));
                record.setPatient(patient);
                record.setDoctor(doctor);
            }
            return new ArrayList<Record>();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<Record>();
        }
    }


    public static boolean setDoctor(Doctor doctor) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "UPDATE doctors SET first_name = ?, last_name = ? where id = ? ";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, doctor.getFirstName());
            preparedStmt.setString(2, doctor.getLastName());
            preparedStmt.setInt   (3, doctor.getId());

            preparedStmt.executeUpdate();

            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean setPatient(Patient patient) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "UPDATE patients SET first_name = ?, last_name = ? where id = ? ";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, patient.getFirstName());
            preparedStmt.setString(2, patient.getLastName());
            preparedStmt.setInt   (3, patient.getId());

            preparedStmt.executeUpdate();

            return true;
        } catch (Exception e){
            return false;
        }

    }


    public static boolean createDoctor(Doctor doctor){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "INSERT INTO doctors(first_name, last_name) VALUES (?, ?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, doctor.getFirstName());
            preparedStmt.setString(2, doctor.getLastName());

            preparedStmt.executeUpdate();

            return true;
        } catch (Exception e){
            return false;
        }

    }

    public static boolean createPatient(Patient patient){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "INSERT INTO patients(first_name, last_name) VALUES (?, ?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, patient.getFirstName());
            preparedStmt.setString(2, patient.getLastName());

            preparedStmt.executeUpdate();

            return true;
        } catch (Exception e){
            return false;
        }

    }

    public static boolean createRecord(Record record){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "INSERT INTO records(patient_id, doctor_id, datetime) VALUES (?, ?, ?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, record.getPatient().getId());
            preparedStmt.setInt(2, record.getDoctor().getId());
            preparedStmt.setObject(3, record.getRecordDateTime());

            preparedStmt.executeUpdate();

            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean deleteRecord(Record record){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "DELETE FROM records WHERE id = ?";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, record.getId());

            preparedStmt.executeUpdate();

            return true;
        } catch (Exception e){
            return false;
        }

    }
}
