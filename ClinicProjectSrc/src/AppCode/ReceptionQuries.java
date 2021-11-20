/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alsul
 */
public class ReceptionQuries {

    private static final String URL = "jdbc:mysql://localhost:3306/clinicdb";
    private final String user = "root";
    private final String pass = "3638";
    private Connection connection;

    private PreparedStatement getReceptionist;
    private PreparedStatement editUsername;
    private PreparedStatement editPassword;
    private PreparedStatement addMannger;
    private PreparedStatement addReceptionest;
    private PreparedStatement getAllReps;
    private PreparedStatement deleteReceptionest;

    public ReceptionQuries() {
        try {
            connection = DriverManager.getConnection(URL, user, pass);

            deleteReceptionest = connection.prepareStatement("DELETE FROM clinicdb.receptionist WHERE username = ?");
            getReceptionist = connection.prepareStatement("SELECT * FROM  clinicdb.receptionist WHERE username = ?");
            editUsername = connection.prepareStatement("UPDATE  clinicdb.receptionist SET username =? where username = ?  ");
            editPassword = connection.prepareStatement("UPDATE  clinicdb.receptionist SET password =? where username = ?  ");
            addMannger = connection.prepareStatement("UPDATE clinicdb.receptionist SET manngerID =? WHERE username =?");
            addReceptionest = connection.prepareStatement("INSERT INTO clinicdb.receptionist VALUES(?,?,NULL,?,?)");
            getAllReps = connection.prepareStatement("SELECT COUNT(1) as numOfRows FROM  receptionist");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        try {
            getReceptionist.setString(1, username);
            ResultSet resultSet = getReceptionist.executeQuery();

            if (resultSet.next()) {
                Owner result = new Owner(resultSet.getInt("id"), resultSet.getString("fullName"), username, resultSet.getString("password"));
                if (password.equals(result.getPassword())) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public Repceptionest getReceptionist(String username) {

        try {
            getReceptionist.setString(1, username);
            ResultSet resultSet = getReceptionist.executeQuery();

            if (resultSet.next()) {
                Repceptionest result = new Repceptionest(resultSet.getInt("id"), resultSet.getString("fullname"), username,
                        resultSet.getString("password"), resultSet.getInt("manngerID"));
                return result;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int editPassword(String username, String password) {
        try {

            editPassword.setString(1, password);
            editPassword.setString(2, username);
            editPassword.executeUpdate();
            return 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;

    }

    public int editUsername(String oldUsername, String newUsername) {

        try {
            editUsername.setString(1, newUsername);
            editUsername.setString(2, oldUsername);
            editUsername.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;

    }

    public int NumOfReps() {
        int numOfReps = 0;

        try {
            ResultSet result = getAllReps.executeQuery();
            result.next();
            numOfReps = result.getInt("numOfRows");

        } catch (SQLException ex) {
            Logger.getLogger(ReceptionQuries.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return numOfReps;
    }

    int addRecptionest(int id, String fullName, String username, String password) {

        try {
            addReceptionest.setInt(1, id);
            addReceptionest.setString(2, fullName);
            addReceptionest.setString(3, username);
            addReceptionest.setString(4, password);
            addReceptionest.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ManngerQuries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int deleteReceptionest(String username) {
        try {
            deleteReceptionest.setString(1, username);
            deleteReceptionest.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;

    }

}
