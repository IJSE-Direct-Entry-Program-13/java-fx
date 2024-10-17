package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep13.fx.controller.MainViewController;

import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url1 = this.getClass().getResource("/view/MainView.fxml");
        URL url2 = AppInitializer.class.getResource("/view/MainView.fxml");

        URL url3 = new URL("http://192.168.8.100:80/MainView.fxml");

        AnchorPane container = FXMLLoader.load(url3);

        Scene mainScene = new Scene(container);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Hello Java FX");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
