package main.controls;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AddToDoController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addTaskButton;

    @FXML
    void initialize() {
        assert addTaskButton != null : "fx:id=\"addTaskButton\" was not injected: check your FXML file 'addToDo.fxml'.";

    }

}
