package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // primaryStage.initStyle(StageStyle.TRANSPARENT);
        AnchorPane container = FXMLLoader.load(getClass().getResource("/scene/MainScene.fxml"));
        primaryStage.setScene(new Scene(container));
        primaryStage.setTitle("FX Windows (Stages)");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
