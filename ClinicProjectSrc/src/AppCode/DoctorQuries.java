/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alsul
 */
public class DoctorQuries {

    private static final String URL = "jdbc:mysql://localhost:3306/clinicdb";
    private final String user = "root";
    private final String pass = "3638";
    private Connection connection;

    private PreparedStatement getDoctor;
    private PreparedStatement addDoctor;


    private PreparedStatement getAllDoctors;

    public DoctorQuries() {
        try {
            connection = DriverManager.getConnection(URL, user, pass);

            getDoctor = connection.prepareStatement("SELECT * FROM  clinicdb.doctor WHERE id = ?");
            addDoctor = connection.prepareStatement("INSERT INTO clinicdb.doctor VALUES(?,?,?,?,?)");
            getAllDoctors = connection.prepareStatement("SELECT COUNT(1) as numOfRows FROM  doctor");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public Doctor getDoctor(int id) {

        try {
            getDoctor.setInt(1, id);
            ResultSet resultSet = getDoctor.executeQuery();

            if (resultSet.next()) {
                Doctor result = new Doctor(resultSet.getInt("id"), resultSet.getString("fullname"),resultSet.getInt("paitiontID")
                                           ,resultSet.getString("field"));
                return result;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    

    public int NumOfDoctors() {
        int numOfReps = 0;

        try {
            ResultSet result = getAllDoctors.executeQuery();
            result.next();
            numOfReps = result.getInt("numOfRows");
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionQuries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numOfReps;
    }

}
