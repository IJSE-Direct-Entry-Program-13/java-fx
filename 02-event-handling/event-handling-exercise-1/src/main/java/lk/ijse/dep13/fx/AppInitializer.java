package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = getClass().getResource("/scene/MainScene.fxml");
        AnchorPane container = FXMLLoader.load(url);
        Scene mainScene = new Scene(container);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Event Handling Exercise - 1");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
