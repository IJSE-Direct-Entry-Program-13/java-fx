package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.dep13.fx.util.AppRouter;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene mainScene = new Scene(AppRouter.getContainer(AppRouter.Routes.MAIN));
        System.out.printf("MainScene: %s%n", mainScene);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Java FX Controls");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
