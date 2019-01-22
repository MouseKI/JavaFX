package tutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/************************************************************************
 * Self-taught note for learning basic JavaFx knowledge
 * Author: Runquan Ye
 * Date:Jan./21/2019
 * JavaFx Tutorial 05 Part1 - Create Alert Boex(Pop Windown)
 * JavaFx Tutorial 06 Part1 - Communicating Between Windows(Confirm Box)
 * JavaFx Tutorial 07 Part1 - Close Program Properly
 ************************************************************************/
public class multipleWindows extends Application  {

    Stage window;
    Button alertButton, comfireButton, closeButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Multiple Windows");

        // run the pop window
        alertButton = new Button("Alert");
        alertButton.setOnAction(e -> popWindow.display("Alert", "There is an Error!!!"));

        //run the Confirm Box
        comfireButton = new Button("Comfire");
        comfireButton.setOnAction(e -> {
            boolean result = comfirmBox.display("Comfire", "Do you want to go shopping?");
            System.out.println(result);
        });

        //for closeing window action
        closeButton = new Button("Close Window");
        closeButton.setOnAction(e -> {
            //e.consume() is that it will not be processed in the default manner by the source which originated it.
            //so that it will process the following code instead the originated code
            e.consume();
            closeWindow();

        });

        //setOnCloseRequest is when user click the red "X" button to triger the action
        //this line of code make sure user do red "X" button will have the same action respond
        window.setOnCloseRequest(e -> closeWindow());

        VBox layout = new VBox();
        layout.getChildren().addAll(alertButton, comfireButton, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene mainScene = new Scene(layout, 300, 300);

        window.setScene(mainScene);

        //display the window
        window.show();
    }


    private void closeWindow(){
        System.out.println("Close the window");

        //use the comfirm box again to make sure the user want to exit the program
        Boolean comfirmClosing = comfirmBox.display("Confirm Exiting", "Are you sure to exit the program");

        if(comfirmClosing == true)
            //close the window
            window.close();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
