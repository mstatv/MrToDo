package main.controls;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import main.mrtodoDB.DBHandler;

import java.net.URL;
import java.util.ResourceBundle;

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

        // instance of DBHandler class
        DBHandler dbHandler = new DBHandler();

        // register button actions on click
        registerButton.setOnAction(event -> {
            dbHandler.registerUser(registerFirstName.getText(), registerLastName.getText(), registerUsername.getText(),
                    registerPassword.getText());

        });


    }

}
