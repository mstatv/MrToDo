package main.mrtodoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for Database Processes
 * -> establish connection
 * -> read / write
 * -> update
 * -> delete
 */
public class DBHandler extends DBconfig {

    Connection connectToDB;

    // establishes connection with DB
    public Connection getDBConnection() throws ClassNotFoundException, SQLException {

        // creates string URL using variables from DBconfig file
        String connectionParam = "jdbc:mysql://" + host + ":" + port + "/" + name;

        Class.forName("com.mysql.jdbc.Driver");

        connectToDB = DriverManager.getConnection(connectionParam, user, password);

        return connectToDB;

    }

    // write information to database


    // read information from database


    // update information in database


    // delete information from database




}
