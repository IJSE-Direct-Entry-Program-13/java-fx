package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("Application started");
        System.out.println("Thread name: " + Thread.currentThread().getName());
        launch(args);
        System.out.println("Nagitta witharai");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Java FX Application Runtime Environment Created");
        System.out.println("Thread name: " + Thread.currentThread().getName());
        Platform.exit();
        System.out.println("------------------------");
        System.out.println("Thread name: " + Thread.currentThread().getName());
        System.out.println("About to exit from Java FX RE");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Application is shutting down");
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}
