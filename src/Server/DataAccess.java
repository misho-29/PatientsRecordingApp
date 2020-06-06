package Server;

import Models.Doctor;
import Models.Patient;
import Models.Record;

import java.sql.*;

public class DataAccess {

    private DataAccess(){}

    // eqimebis arraylists unda abrunebdes
    public static void printDoctors(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM doctors");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                System.out.println(String.format("%d | %s | %s", id, first_name, last_name));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    // pacientebis arraylists unda abrunebdes
    public static void printPatients(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM patients");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                System.out.println(String.format("%d | %s | %s", id, first_name, last_name));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // recordebis arraylists unda abrunebdes, records obieqtshi eqneba doctori da patienti
    public static void printRecords(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM records");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String date = resultSet.getDate("date").toString();
                String time = resultSet.getTime("time").toString();
                int patient_id = resultSet.getInt("patient_id");
                int doctor_id = resultSet.getInt("doctor_id");
                System.out.println(String.format("%d | patient_id - %d | doctor_id - %d | %s  %s", id,  patient_id, doctor_id, date, time));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static boolean setDoctor(Doctor doctor, int id) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "UPDATE doctors SET first_name = ?, last_name = ? where id = ? ";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, doctor.getFirtsName());
            preparedStmt.setString(2, doctor.getLastName());
            preparedStmt.setInt   (3, id);

            preparedStmt.executeUpdate();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean setPatient(Patient patient, int id) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "UPDATE patients SET first_name = ?, last_name = ? where id = ? ";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, patient.getFirtsName());
            preparedStmt.setString(2, patient.getLastName());
            preparedStmt.setInt   (3, id);

            preparedStmt.executeUpdate();
        } catch (Exception e){
            return false;
        }
        return true;
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
            preparedStmt.setString(1, doctor.getFirtsName());
            preparedStmt.setString(2, doctor.getLastName());


            preparedStmt.executeUpdate();
        } catch (Exception e){
            return false;
        }
        return true;
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
            preparedStmt.setString(1, patient.getFirtsName());
            preparedStmt.setString(2, patient.getLastName());


            preparedStmt.executeUpdate();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    // aq recordis obieqtidan amoigeb pacients da mere magis ids, eqimzec egre
    public static boolean createRecord(Record record){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "INSERT INTO records(patient_id, doctor_id, date, time) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, record.getPatientId());
            preparedStmt.setInt(2, record.getDoctorId());
            preparedStmt.setDate(3, record.getDate());
            preparedStmt.setTime(4, record.getTime());


            preparedStmt.executeUpdate();
        } catch (Exception e){
            return false;
        }
        return true;
    }


    public static boolean deleteRecord(int id){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaproject",
                    "root",
                    "toor");

            Statement statement = connection.createStatement();
            String query = "DELETE FROM records WHERE id = ?";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);

            preparedStmt.executeUpdate();
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
