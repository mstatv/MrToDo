package main.controls;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
    private JFXButton registerButton;

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

            Parent root = loader.getRoot();
            Stage secStage = new Stage();
            secStage.setScene(new Scene(root));
            secStage.showAndWait();

        });

        // actions to be taken when login button is clicked
        loginButton.setOnAction(event -> {

            // if entered username and password are not empty
            // feed user strUserName and strPassword to
            // user login method below
            if (!strUserName.equals("") || !strPassword.equals("")) {

                userLogin(strUserName, strPassword);

            } else {
                System.out.println("Error at User Login.");
            }
        });

    }

    private void userLogin(String user, String password) {
       // check DB -> does user exist?
       // if user exists --> open add ToDo screen
       //
        

    }
}