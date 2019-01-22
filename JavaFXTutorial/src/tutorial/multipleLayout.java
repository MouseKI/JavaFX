package tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/***********************************************************
 * Self-taught note for learning basic JavaFx knowledge
 * Author: Runquan Ye
 * Date:Jan./21/2019
 * JavaFx Tutorial 08 - Embedding Layouts
 ***********************************************************/
public class multipleLayout extends Application{

    Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)throws  Exception {

        window = primaryStage;
        window.setTitle("Multiple Layout");

        HBox topMenu = new HBox();
        Button button1 = new Button("File");
        Button button2 = new Button("Edit");
        Button button3 = new Button("View");
        topMenu.getChildren().addAll(button1, button2, button3);

        VBox leftMenu = new VBox();
        Button buttonA = new Button("Title A");
        Button buttonB = new Button("Title B");
        Button buttonC = new Button("Title C");
        leftMenu.getChildren().addAll(buttonA, buttonB, buttonC);


        BorderPane mainPane = new BorderPane();
        mainPane.setTop(topMenu);
        mainPane.setLeft(leftMenu);


        Scene scene = new Scene(mainPane, 300, 250);
        window.setScene(scene);
        window.show();
    }

}
