package lk.ijse.dep13.fx;

import javafx.application.Application;
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
        // URL url = getClass().getResource("/scene/MainScene.fxml");
        // AnchorPane container = FXMLLoader.load(getClass().getResource("/scene/MainScene.fxml"));
        // Scene mainScene = new Scene(FXMLLoader.load(getClass().getResource("/scene/MainScene.fxml")));
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/scene/MainScene.fxml"))));
        primaryStage.setTitle("Java FX Transitions");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
