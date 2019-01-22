package tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/***********************************************************
 * Self-taught note for learning basic JavaFx knowledge
 * Author: Runquan Ye
 * Date:Jan./21/2019
 * JavaFx Tutorial 09 - GridPane
 ***********************************************************/
public class userLoginPane extends Application{
    Stage window;
    private String storedName, storedPassword;

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws  Exception{
        window = primaryStage;
        window.setTitle("User Login");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10,10));

        //set the virtical space is 8px
        grid.setVgap(8);

        //set the horizonal space is 8px
        grid.setHgap(10);

        Label userName = new Label("User Name:");
        GridPane.setConstraints(userName, 0, 0);

        //if you want to have a default input for the inputName,
        //TextField inputName = new TextField("Jerry");  <-- like this, the default input userName is "Jerry"
        TextField inputName = new TextField("Jerry");
        GridPane.setConstraints(inputName, 1, 0);

        Label password = new Label("Password:");
        GridPane.setConstraints(password, 0, 1);

        TextField inputassword = new TextField();
        inputassword.setPromptText("password");  //set the grey indicate word on the TextField
        GridPane.setConstraints(inputassword, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            storedName = inputName.getText();
            storedPassword = inputassword.getText();
            System.out.print("User Name: " + storedName + "\nPassword: " + storedPassword);
        });

        GridPane.setConstraints(loginButton, 1, 2);

        //add everything into the grid
        grid.getChildren().addAll(userName, inputName, password, inputassword, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);

        window.show();
    }
}
