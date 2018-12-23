package tutorial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class popWindow {
    public static void display(String title, String message){
        Button button;
        Stage window = new Stage();

        //modality.APPLICATION_MODAL is to limit the user action unless the pop window got taken care
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);

        button = new Button("Close");
        button.setOnAction(e -> window.close());

        VBox layout =  new VBox(10);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        //showAndWait for it to be hidden or closed before returning to the caller window
        //So that you has to close this popWindow to go back to the main window.
        //limit user action unless this popWindow is close.
        window.showAndWait();
    }
}

