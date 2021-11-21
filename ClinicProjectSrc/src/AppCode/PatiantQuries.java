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
 * /**
 *
 * @author alsul
 */
public class PatiantQuries {

    private static final String URL = "jdbc:mysql://localhost:3306/clinicdb";
    private final String user = "root";
    private final String pass = "3638";
    private Connection connection;

    private PreparedStatement getpatiant;
    private PreparedStatement addpatiant;

    private PreparedStatement getAllpatiant;

    public PatiantQuries() {
        try {
            connection = DriverManager.getConnection(URL, user, pass);

            getpatiant = connection.prepareStatement("SELECT * FROM  clinicdb.patiant WHERE id = ?");
            addpatiant = connection.prepareStatement("INSERT INTO clinicdb.patiant VALUES(?,?,?,?,?)");
            getAllpatiant = connection.prepareStatement("SELECT COUNT(1) as numOfRows FROM  patiant");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Patiant getPatiant(int id) {

        try {
            getpatiant.setInt(1, id);
            ResultSet resultSet = getpatiant.executeQuery();

            if (resultSet.next()) {
                Patiant result = new Patiant(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getInt("doctorID"),
                        resultSet.getInt("age"), resultSet.getInt("number"));
                return result;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int numOfPatiants() {
        int numOfReps = 0;

        try {
            ResultSet result = getAllpatiant.executeQuery();
            result.next();
            numOfReps = result.getInt("numOfRows");
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionQuries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numOfReps;
    }

    public int addPatiant(int id, String fullName,int doctorID, int age, int number) {

        try {
            addpatiant.setInt(1, id);
            addpatiant.setString(2, fullName);
            addpatiant.setInt(3,doctorID);
            addpatiant.setInt(4, age);
            addpatiant.setInt(5, number);
            addpatiant.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PatiantQuries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

}
