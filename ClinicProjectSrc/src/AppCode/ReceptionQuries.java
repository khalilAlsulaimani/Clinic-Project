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
    private PreparedStatement addReceptionest;

    public ReceptionQuries() {
        try {
            connection = DriverManager.getConnection(URL, user, pass);
            getReceptionist = connection.prepareStatement("SELECT * FROM  clinicdb.receptionist WHERE username = ?");
            editUsername = connection.prepareStatement("UPDATE  clinicdb.receptionist SET username =? where id = ?  ");
            editPassword = connection.prepareStatement("UPDATE  clinicdb.receptionist SET password =? where id = ?  ");
            addReceptionest = connection.prepareStatement("UPDATE clinicdb.receptionist SET manngerID =? WHERE id =?");

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

}
