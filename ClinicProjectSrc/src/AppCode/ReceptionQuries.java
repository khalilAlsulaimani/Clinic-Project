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

    public ReceptionQuries() {
        try {
            connection = DriverManager.getConnection(URL, user, pass);
            
            getReceptionist = connection.prepareStatement("SELECT * FROM  clinicdb.receptionist WHERE username = ?");
            editUsername = connection.prepareStatement("UPDATE  clinicdb.receptionist SET username =? where id = ?  ");
            editPassword = connection.prepareStatement("UPDATE  clinicdb.receptionist SET password =? where id = ?  ");
            addMannger = connection.prepareStatement("UPDATE clinicdb.receptionist SET manngerID =? WHERE id =?");
            addReceptionest = connection.prepareStatement("INSERT INTO clinicdb.receptionist VALUES(?,?,?,?,?)");
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

    public Owner getReceptionist(String username) {

        try {
            getReceptionist.setString(1, username);
            ResultSet resultSet = getReceptionist.executeQuery();

            if (resultSet.next()) {
                Owner result = new Owner(resultSet.getInt("id"), resultSet.getString("fullname"), username, resultSet.getString("password"));
                return result;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int editPassword(int id, String username, String password) {
        try {
            getReceptionist.setString(1, username);
            ResultSet resultSet = getReceptionist.executeQuery();

            if (resultSet.next() && login(username, password)) {
                editPassword.setString(1, password);
                editPassword.setInt(2, id);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;

    }

    public int editUsername(int id, String username, String password) {
        try {
            getReceptionist.setString(1, username);
            ResultSet resultSet = getReceptionist.executeQuery();

            if (resultSet.next()) {
                editPassword.setString(1, password);
                editPassword.setInt(2, id);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;

    }
    
    public int NumOfReps(){
        int numOfReps=0;
        
        try{
            ResultSet result = getAllReps.executeQuery();
            result.next();
            numOfReps = result.getInt("numOfRows");
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionQuries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numOfReps;
    }

}
