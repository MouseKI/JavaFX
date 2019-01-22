package tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.security.auth.callback.ChoiceCallback;
import java.awt.*;

/*************************************************************************
 * Self-taught note for learning basic JavaFx knowledge
 * Author: Runquan Ye
 * Date:Jan./21/2019
 * JavaFx Tutorial 11 - Checxbox
 * JavaFx Tutorial 12 - ChoiceBox
 ************************************************************************/
public class conditionSelected extends Application {
    Stage window;
    private String storedName, storedPassword;

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws  Exception{
        window = primaryStage;
        window.setTitle("Selected Condition");

        //checkboxes
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        CheckBox box3 = new CheckBox("Vegetable");
        box3.setSelected(true); // box3 selected by default, the user still can unselected

        //drop down Choice box
        ChoiceBox<String> paymethod = new ChoiceBox<String>();

        //getUtems returns the ObservableList object which you can add items to
        paymethod.getItems().add("Cash");
        paymethod.getItems().add("Membership Credit");
        paymethod.getItems().add("Credit Card");
        paymethod.setValue("Cash"); //this is gona set the initial default value

        //drop down Choice box
        ChoiceBox<Integer> orderAmount = new ChoiceBox<Integer>();

        //getUtems returns the ObservableList object which you can add items to
        orderAmount.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        orderAmount.setValue(1); //this is gona set the initial default value
        //button
        Button button = new Button("Order Now!");
        button.setOnAction( e -> handleOptions(box1, box2, box3, paymethod, orderAmount));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1, box2, box3, paymethod, orderAmount, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);

        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2, CheckBox box3, ChoiceBox<String> pay, ChoiceBox<Integer> amount){
        String message = "User Ordered: \n";
        String payment = pay.getValue();

        if(box1.isSelected())
            message += "Bacon, ";

        if(box2.isSelected())
            message += "Tuna, ";

        if(box3.isSelected())
            message += "Vegetable";

        message += "\nPayment: " + payment + "\nOrder Amount: " + amount.getValue();
        System.out.println(message);
    }
}

