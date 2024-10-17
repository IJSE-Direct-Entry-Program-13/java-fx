package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane container = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene mainScene = new Scene(container);
        stage.setScene(mainScene);
        stage.setTitle("JavaFX Application");
        stage.show();
        stage.centerOnScreen();
    }
}
