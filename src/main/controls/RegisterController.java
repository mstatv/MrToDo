package main.controls;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import main.constrClasses.User;
import main.mrtodoDB.DBHandler;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * REGISTER SCREEN CONTROLS
 */
public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField registerFirstName;

    @FXML
    private JFXTextField registerLastName;

    @FXML
    private JFXTextField registerUsername;

    @FXML
    private JFXPasswordField registerPassword;

    @FXML
    private JFXButton registerButton;

    @FXML
    void initialize() {
        assert registerFirstName != null : "fx:id=\"registerFirstName\" was not injected: check your FXML file 'register.fxml'.";
        assert registerLastName != null : "fx:id=\"registerLastName\" was not injected: check your FXML file 'register.fxml'.";
        assert registerUsername != null : "fx:id=\"registerUsername\" was not injected: check your FXML file 'register.fxml'.";
        assert registerPassword != null : "fx:id=\"registerPassword\" was not injected: check your FXML file 'register.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'register.fxml'.";

        // register button actions on click
        registerButton.setOnAction(event -> {
            // call regUser method to register user on click
            regUser();
        });

    }

    // create user method
    private void regUser() {
        // instance of DBHandler class
        DBHandler dbHandler = new DBHandler();

        // local variable declaration
        String fName = registerFirstName.getText();
        String lName = registerLastName.getText();
        String uName = registerUsername.getText();
        String uPass = registerPassword.getText();

        User user = new User(fName, lName, uName, uPass);

        dbHandler.registerUser(user);
    }

}
