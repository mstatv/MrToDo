package main.controls;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.cj.protocol.Resultset;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.constrClasses.User;
import main.mrtodoDB.DBHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField userLoginField;

    @FXML
    private JFXPasswordField passLoginField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton registerButton;

    // init DBhandler
    private DBHandler dbHandler;

    @FXML
    void initialize() {
        assert userLoginField != null : "fx:id=\"userLoginField\" was not injected: check your FXML file 'login.fxml'.";
        assert passLoginField != null : "fx:id=\"passLoginField\" was not injected: check your FXML file 'login.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert registerButton != null : "fx:id=\"signupButton\" was not injected: check your FXML file 'login.fxml'.";

        // variables for user name and password
        // retrieved from login screen
        String strUserName = userLoginField.getText().trim();
        String strPassword = passLoginField.getText().trim();

        User user = new User();
        user.setUserName(strUserName);
        user.setUserPassword(strPassword);

        // login button action
        loginButton.setOnAction(event -> {

            // retrieve valid user from DB
            ResultSet uRow = dbHandler.getValidUser(user);

            // count variable
            int count = 0;

            try {
                while (uRow.next()) {

                    count++;

                }
                if (count == 1) {
                    // success login to console
                    System.out.println("Success! Let's get 'ToDo'in");

                }

            } catch (SQLException se) {

                se.printStackTrace();

            }

        });

        // register button action
        registerButton.setOnAction(event -> {
            // to register screen
            registerButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/main/screens/register.fxml"));

            // try/catch for errors
            try {
                loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // prepare and show second stage (register screen)
            Parent root = loader.getRoot();
            Stage secStage = new Stage();
            secStage.setScene(new Scene(root));
            secStage.showAndWait();

        });

    }

}