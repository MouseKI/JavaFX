package tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class multipleWindows extends Application  {

   Stage window;
   Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Multiple Windows");

        button = new Button("Click");
        button.setOnAction(e -> popWindow.display("Alert", "There is an Error!!!"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene mainScene = new Scene(layout, 300, 300);

        window.setScene(mainScene);

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
