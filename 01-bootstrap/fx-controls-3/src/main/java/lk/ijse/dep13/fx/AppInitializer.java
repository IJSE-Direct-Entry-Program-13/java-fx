package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resourceUrl = getClass().getResource("/view/SecondView.fxml");
        AnchorPane container = FXMLLoader.load(resourceUrl);
        Scene mainScene = new Scene(container);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("JavaFX Controls with FXML");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
