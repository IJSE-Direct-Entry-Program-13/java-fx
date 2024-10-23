package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.dep13.fx.util.AppRouter;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(AppRouter.getContainer(AppRouter.Routes.MAIN)));
        primaryStage.setResizable(false);
        primaryStage.setTitle("FX Scene Navigation Exercise");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
