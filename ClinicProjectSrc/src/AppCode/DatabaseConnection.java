/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author alsul
 */
public class DatabaseConnection {
    
    private String dbURL;
    private Connection connection;
    
    DatabaseConnection() throws SQLException {
        dbURL = "jdbc:derby:D:\\db-derby-10.15.2.0-bin\\lib\\testDB;create=true";
        connection = DriverManager.getConnection(dbURL);
    }
    
     
}


