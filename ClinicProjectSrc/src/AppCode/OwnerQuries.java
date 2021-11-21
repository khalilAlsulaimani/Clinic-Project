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
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alsul
 */
public class OwnerQuries {

    private static final String URL = "jdbc:mysql://localhost:3306/clinicdb";
    private final String user = "root";
    private final String pass = "3638";
    private Connection connection;

    private PreparedStatement getOwner;
    private PreparedStatement editUsername;
    private PreparedStatement editPassword;
    private PreparedStatement getOwnerName;
    private PreparedStatement editName;
    private PreparedStatement isFirstLogin;
    private PreparedStatement changeisFirstLogin;

    public OwnerQuries() {
        try {
            connection = DriverManager.getConnection(URL, user, pass);
            getOwner = connection.prepareStatement("SELECT * FROM  clinicdb.owner WHERE username = ?");
            editUsername = connection.prepareStatement("UPDATE  clinicdb.owner SET username =? where username = ?  ");
            editPassword = connection.prepareStatement("UPDATE  clinicdb.owner SET password =? where username = ?  ");
            getOwnerName = connection.prepareStatement("SELECT fullName FROM clinicdb.owner WHERE username = ?");
            editName = connection.prepareStatement("UPDATE clinicdb.owner SET fullName = ? WHERE username = ? ");
            isFirstLogin = connection.prepareStatement("SELECT isFirstLogin from clinicdb.owner WHERE username = ?");
            changeisFirstLogin = connection.prepareStatement("UPDATE clinicdb.owner SET isFirstLogin = 0 WHERE username=?");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isFirstLogin(String username) {
        try {
            isFirstLogin.setString(1, username);
            ResultSet result = isFirstLogin.executeQuery();
            result.next();
            int res = result.getInt("isFirstLogin");
            if (res == 0) {
                return false;
            } else {
                System.out.print("true");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManngerQuries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public void changeisFirstLogin(String username) {
        try {
            changeisFirstLogin.setString(1, username);
            changeisFirstLogin.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ManngerQuries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(String username, String password) {
        try {
            getOwner.setString(1, username);
            ResultSet resultSet = getOwner.executeQuery();

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

    public Owner getOwner(String username) {

        try {
            getOwner.setString(1, username);
            ResultSet resultSet = getOwner.executeQuery();

            if (resultSet.next()) {
                Owner result = new Owner(resultSet.getInt("id"), resultSet.getString("fullname"), username, resultSet.getString("password"));
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

    public int editName(String username, String name) {

        try {
            editName.setString(1, name);
            editName.setString(2, username);
            editName.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(OwnerQuries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public String getOwnerName(String username) {

        try {
            getOwnerName.setString(1, username);
            ResultSet result = getOwnerName.executeQuery();
            if (result.next()) {
                return result.getString("fullName");
            }

        } catch (SQLException ex) {
            Logger.getLogger(OwnerQuries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
