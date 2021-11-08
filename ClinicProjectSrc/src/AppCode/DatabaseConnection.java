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
import java.util.List;

/**
 *
 * @author alsul
 */
public class DatabaseConnection {

    private String dbURL;
    private Connection connection;
    private Statement statement;

    DatabaseConnection() throws SQLException {
        dbURL = "jdbc:derby:D:\\db-derby-10.15.2.0-bin\\lib\\testDB;create=true";
        connection = DriverManager.getConnection(dbURL);
        statement = connection.createStatement();

    }

    public int getNumOfColumns(String table) throws SQLException {
        PreparedStatement columnsQuery;
        columnsQuery = connection.prepareStatement("SELECT * FROM ?");
        columnsQuery.setString(0, table);
        ResultSet result = columnsQuery.executeQuery();

        ResultSetMetaData metaData = result.getMetaData();

        int numOfColumns = metaData.getColumnCount();

        return numOfColumns;
    }

    public void addPaitiant(int id, String name, int doctorID, int age) throws SQLException {
        PreparedStatement addSQL;
        addSQL = connection.prepareStatement("INSERT INTO PAITIANT(id,fullName,doctorID,age) VALUES (?,?,?,?)");
        addSQL.setInt(0, id);
        addSQL.setString(1, name);
        addSQL.setInt(2, doctorID);
        addSQL.setInt(3, age);
        addSQL.executeUpdate();

    }

    public String getName(String table, int id) throws SQLException {
        PreparedStatement nameSQL;
        nameSQL = connection.prepareStatement("SELECT * FROM ? WHERE ID = ?");
        nameSQL.setString(1, table);
        nameSQL.setInt(2, id);
        ResultSet result = nameSQL.executeQuery();
        String name = result.getString("FULLNAME");
        return name;
    }
    
   

}
