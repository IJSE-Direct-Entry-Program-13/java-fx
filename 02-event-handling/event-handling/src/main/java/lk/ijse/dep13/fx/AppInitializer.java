package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("/scene/SecondScene.fxml");
        AnchorPane container = FXMLLoader.load(url);
        Scene scene = new Scene(container);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Event Handling - 1");
        primaryStage.show();
        primaryStage.centerOnScreen();
        System.out.println("End of the start()");
    }
}
