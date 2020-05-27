package main.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.*;
import javafx.scene.layout.AnchorPane;
import main.screenAnimations.ErrorShaker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * FROM AN EMPTY TODO LIST ADDING
 * A TODO TO USER LIST
 * TAKES USER TO ADD FORM SCREEN
 */
public class AddToDoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane todoPane;

    @FXML
    private Label taskFreeMsg;

    @FXML
    private ImageView addTaskButton;

    public static int uID;

    @FXML
    void initialize() {
        assert todoPane != null : "fx:id=\"todoPane\" was not injected: check your FXML file 'addToDo.fxml'.";
        assert taskFreeMsg != null : "fx:id=\"taskFreeMsg\" was not injected: check your FXML file 'addToDo.fxml'.";
        assert addTaskButton != null : "fx:id=\"addTaskButton\" was not injected: check your FXML file 'addToDo.fxml'.";

        addTaskButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // shake to confirm user clicking add item
            ErrorShaker taskButtonShake = new ErrorShaker(addTaskButton);
            taskButtonShake.errorShake();

            // remove fields
            // change position and opacity (invis)
            addTaskButton.relocate(0, 20);
            taskFreeMsg.relocate(0, 20);
            addTaskButton.setOpacity(0);
            taskFreeMsg.setOpacity(0);

            // try/catch to open addFrom inside of addToDo Screen
            try {
                // loading add form screen
                AnchorPane addFormPane = FXMLLoader.load(getClass().getResource("/main/screens/addForm.fxml"));

                // setting UID
                AddToDoController.uID = getUID();

                todoPane.getChildren().setAll(addFormPane);

            } catch (IOException e) {
                e.printStackTrace();
            }


        });

    }

    // sets userID based on increment from DB, at the time User registers
    public void setUID(int uID) {
        this.uID = uID;
    }

    // gets uID
    public int getUID() {
        return this.uID;
    }
}
