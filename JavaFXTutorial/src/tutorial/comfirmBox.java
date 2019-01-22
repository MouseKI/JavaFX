package tutorial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*************************************************************************
 * Self-taught note for learning basic JavaFx knowledge
 * Author: Runquan Ye
 * Date:Jan./21/2019
 * JavaFx Tutorial 06 Part2 - Communicating Between Windows(Confirm Box)
 ************************************************************************/
public class comfirmBox {
    private static boolean reply;

    public static boolean display(String title, String message){
        Button buttonYes, buttonNo;
        Stage window = new Stage();

        //modality.APPLICATION_MODAL is to limit the user action unless the pop window got taken care
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);

        //create two butons
        buttonYes = new Button("Yes");
        buttonYes.setOnAction(e -> {
            reply = true;
            window.close();
        });

        buttonNo = new Button("No");
        buttonNo.setOnAction(e -> {
            reply = false;
            window.close();
        });

        VBox layout =  new VBox(10);
        layout.getChildren().addAll(label, buttonYes, buttonNo);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        //showAndWait for it to be hidden or closed before returning to the caller window
        //So that you has to close this popWindow to go back to the main window.
        //limit user action unless this popWindow is close.
        window.showAndWait();

        return reply;
    }
}

