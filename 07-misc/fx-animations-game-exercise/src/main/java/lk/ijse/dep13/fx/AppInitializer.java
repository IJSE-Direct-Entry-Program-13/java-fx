package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane container = FXMLLoader.load(getClass().getResource("/scene/MainScene.fxml"));
        primaryStage.setScene(new Scene(container));
        container.setFocusTraversable(true);
        container.requestFocus();
        primaryStage.setResizable(false);
        primaryStage.setTitle("JavaFX Animations: Game Exercise");
        primaryStage.show();
        Platform.runLater(primaryStage::centerOnScreen);
    }
}
