package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btnClickMe = new Button("Click Me");
        TextField txtInput = new TextField();
        HBox hBox = new HBox();

        for (int i = 0; i < 10; i++) {
            hBox.getChildren().add(new Button("New Button" + i));
        }

        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello Java FX");
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
