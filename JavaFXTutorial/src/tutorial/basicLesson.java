package tutorial;

/***********************************************************
 * Self-taught note for learning basic JavaFx knowledge
 * Author: Runquan Ye
 * Date:Jan./21/2019
 * JavaFx Tutorial 01 - Create Basic Window
 * JavaFx Tutorial 02 - EventHandler
 * JavaFx Tutorial 0e - Lambda Expression
 ***********************************************************/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class basicLesson extends Application implements EventHandler<ActionEvent> {

    Button button, button2, button3;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //In JavaFX the entire window is 'Stage'.
        //The content inside of the window is 'Scene'

        //set the window title, primaryStage is the main window
        primaryStage.setTitle("JavaFX Tutorial");

        //set the layout
        VBox mainPane = new VBox();

        button = new Button();
        button.setText("Click Me");

        button2 = new Button();
        button2.setText("Something New");

        button3 = new Button();
        button3.setText("Awesome");

        //Add the button to the Actionevent Handler
        //Here has multiple way to hold up the button to the event listener
        button.setOnAction(this);

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This is another way to hold up the button to the action listener");
            }
        });

        //use the lamda to code action even easier
        button3.setOnAction(e -> System.out.println("This way even easier."));

       //add the elements into the main scene
        mainPane.getChildren().add(button);
        mainPane.getChildren().add(button2);
        mainPane.getChildren().add(button3);
        mainPane.setAlignment(Pos.CENTER);

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
