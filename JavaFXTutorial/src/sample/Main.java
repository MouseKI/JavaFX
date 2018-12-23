package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button button;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //In JavaFX the entire window is 'Stage'.
        //The content inside of the window is 'Scene'

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //set the window title, primaryStage is the main window
        primaryStage.setTitle("JavaFX Tutorial");
        primaryStage.setScene(new Scene(root, 300, 275));

        //set the layout
        StackPane mainPane = new StackPane();

        button = new Button();
        button.setText("Click Me");

        //Add the button to the Actionevent Handler
        button.setOnAction(this);
        mainPane.getChildren().add(button);

        //create the
        Scene mainScene = new Scene(mainPane, 300, 250);
        primaryStage.setScene(mainScene);

        //display the window
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button)
            System.out.println("Hello");
    }
}
