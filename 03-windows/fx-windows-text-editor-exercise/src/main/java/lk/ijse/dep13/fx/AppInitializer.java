package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane container = FXMLLoader.load(getClass().getResource("/scene/SplashScene.fxml"));
        container.setBackground(Background.fill(Color.TRANSPARENT));
        Scene splashScene = new Scene(container);
        splashScene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(splashScene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("DEP Text Editor");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
