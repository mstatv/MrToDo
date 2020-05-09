package main.controls;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
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
    private JFXButton signupButton;

    @FXML
    void initialize() {
        assert userLoginField != null : "fx:id=\"userLoginField\" was not injected: check your FXML file 'login.fxml'.";
        assert passLoginField != null : "fx:id=\"passLoginField\" was not injected: check your FXML file 'login.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert signupButton != null : "fx:id=\"signupButton\" was not injected: check your FXML file 'login.fxml'.";

        // test to check button status
        loginButton.setOnAction(event -> {
            System.out.println("login clicked...");
        });

    }
}