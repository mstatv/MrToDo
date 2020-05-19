package main.controls;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import main.constrClasses.ToDo;
import main.mrtodoDB.DBHandler;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * ADD FORM SCREEN CONTROLS
 */
public class AddFormController {

    private DBHandler dbHandler;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField addToDoField;

    @FXML
    private JFXTextField addDescField;

    @FXML
    private JFXButton saveToDo;

    @FXML
    void initialize() {
        assert addToDoField != null : "fx:id=\"addToDoField\" was not injected: check your FXML file 'addForm.fxml'.";
        assert addDescField != null : "fx:id=\"addDescField\" was not injected: check your FXML file 'addForm.fxml'.";
        assert saveToDo != null : "fx:id=\"saveToDo\" was not injected: check your FXML file 'addForm.fxml'.";

        dbHandler = new DBHandler();

        // action for save todo button
        saveToDo.setOnAction(event -> {
            // todo class instance
            ToDo toDo = new ToDo();

            // calendar object to get time
            Calendar calendar = Calendar.getInstance();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());

            // push to db
            toDo.setTaskDesc("Test"); // test with db change to field
            toDo.setTask("test title"); // test with db change to field
            toDo.setTimeDate(timestamp);
            dbHandler.pushToDo(toDo);
        });



    }

}
