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
import main.constrClasses.ToDo;
import main.constrClasses.User;
import main.mrtodoDB.DBHandler;
import main.screenAnimations.ErrorShaker;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * LOGIN SCREEN CONTROLS
 */
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
    private DBHandler dbHandler = new DBHandler();

    @FXML
    void initialize() {
        assert userLoginField != null : "fx:id=\"userLoginField\" was not injected: check your FXML file 'login.fxml'.";
        assert passLoginField != null : "fx:id=\"passLoginField\" was not injected: check your FXML file 'login.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert registerButton != null : "fx:id=\"signupButton\" was not injected: check your FXML file 'login.fxml'.";

        // login button action
        loginButton.setOnAction(event -> {

            // variables for user name and password
            // retrieved from login screen
            String strUserName = userLoginField.getText().trim();
            String strPassword = passLoginField.getText().trim();

            User user = new User();
            user.setUserName(strUserName);
            user.setUserPassword(strPassword);

            // retrieve valid user from DB
            ResultSet uRow = dbHandler.getValidUser(user);

            // count variable
            int count = 0;

            try {
                while (uRow.next()) {

                    count++;

                    String uFname = uRow.getString("firstName");
                    System.out.println("User: " + uFname);

                }
                if (count == 1) {
                    // success login to console
                    System.out.println("Success ! Let's get ' ToDo 'in");
                    goToAddToDo();

                } else {
                    // failed login attempt...

                    // shake the username login field error effect
                    ErrorShaker uNameErrorShaker = new ErrorShaker(userLoginField);
                    uNameErrorShaker.errorShake();

                    // shake the password login field error effect
                    ErrorShaker uPassErrorShaker = new ErrorShaker(passLoginField);
                    uPassErrorShaker.errorShake();

                    // shake login button
                    ErrorShaker loginButtonErrorShaker = new ErrorShaker(loginButton);
                    loginButtonErrorShaker.errorShake();


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
        
    // open Add ToDo screen
    private void goToAddToDo() {
        
        // to register screen
        registerButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/screens/addToDo.fxml"));

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

    }

}