package main.mrtodoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String connectionParam = "jdbc:mysql://" + host + ":" + port + "/" + name + "?useTimezone=true&serverTimezone=UTC" ;

        Class.forName("com.mysql.cj.jdbc.Driver");

        connectToDB = DriverManager.getConnection(connectionParam, user, password);

        return connectToDB;

    }

    // write information to database
    public void registerUser(String first, String last, String username, String pass) {

        // using DB constants creating statement to pass through to database
        String write = "INSERT INTO " + DBconstants.MRTODO_USERS + "(" + DBconstants.U_FIRSTNAME + ","
                + DBconstants.U_LASTNAME + "," + DBconstants.U_USERNAME + "," + DBconstants.U_PASSWORD + ")"
                + "VALUES(?, ?, ?, ?)";

        try {

            PreparedStatement pStatement = getDBConnection().prepareStatement(write);

            // statement -> set string for db entry
            pStatement.setString(1, first);
            pStatement.setString(2, last);
            pStatement.setString(3, username);
            pStatement.setString(4, pass);

            pStatement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    // read information from database


    // update information in database


    // delete information from database




}
