package main.mrtodoDB;

import main.constrClasses.User;

import java.sql.*;

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
    // using User class as parameter
    public void registerUser(User user) {

        // using DB constants creating statement to pass through to database
        String write = "INSERT INTO " + DBconstants.MRTODO_USERS + "(" + DBconstants.U_FIRSTNAME + ","
                + DBconstants.U_LASTNAME + "," + DBconstants.U_USERNAME + "," + DBconstants.U_PASSWORD + ")"
                + "VALUES(?, ?, ?, ?)";

        try {

            PreparedStatement pStatement = getDBConnection().prepareStatement(write);

            // statement -> set string for db entry
            pStatement.setString(1, user.getFirstName());
            pStatement.setString(2, user.getLastName());
            pStatement.setString(3, user.getUserName());
            pStatement.setString(4, user.getUserPassword());

            pStatement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    // method to get a valid user
    // will print to console if user is required to implement a valid user
    public ResultSet getValidUser (User user) {

        ResultSet resSet = null;

        if (!user.getUserName().equals("") || !user.getUserPassword().equals("")) {

            // QUERY selecting all from MrToDo_users table where user = * and pass = *
            String que = "SELECT * FROM " + DBconstants.MRTODO_USERS + " WHERE " + DBconstants.U_USERNAME + "=? AND " +
                    DBconstants.U_PASSWORD + "=?";

            // try/catch for errors
            try {
                PreparedStatement pStatement = getDBConnection().prepareStatement(que);

                pStatement.setString(1, user.getUserName());
                pStatement.setString(1, user.getUserPassword());

                // execution of pStatement
                resSet = pStatement.executeQuery();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {

            System.out.println("Enter a valid username and password!");

        }

        // return query results
        return resSet;
    }


    // read information from database


    // update information in database


    // delete information from database




}
