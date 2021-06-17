package library.assistant.ui.addbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library.assistant.database.DatabaseHandler;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField title;
    @FXML
    private TextField author;
    @FXML
    private TextField id;
    @FXML
    private TextField publisher;
    @FXML
    private Button save;
    @FXML
    private Button cancel;

    public DatabaseHandler dbhandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbhandler = new DatabaseHandler();
    }

    @FXML
    private void addBook(ActionEvent event){
        String bookID = id.getText(),
        bookTitle = title.getText(),
        bookAuthor = author.getText(),
        bookPublisher = publisher.getText();

        if(bookAuthor.isEmpty()||bookID.isEmpty() ||bookTitle.isEmpty() ||bookPublisher.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter in all fields");
            alert.showAndWait();
            return;
        }

        String query = "INSERT INTO BOOK VALUES (" +
                "'" + bookID + "'," +
                "'" + bookTitle + "'," +
                "'" + bookAuthor + "'," +
                "'" + bookPublisher + "'," +
                "'" + true + "'" +
                ")";

       if(dbhandler.execAction(query)){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText(null);
           alert.setContentText("Success");
           alert.showAndWait();
       }else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setContentText("Fail");
           alert.showAndWait();
       }
    }

    @FXML
    private void cancel(ActionEvent event){

    }
}
