package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Button");
        TextField textField = new TextField();
        ProgressBar progressBar = new ProgressBar();
        TextArea textArea = new TextArea();
        ToggleButton toggleButton = new ToggleButton();
        Slider slider = new Slider();
        Label label = new Label();

        AnchorPane container = new AnchorPane();

        container.getChildren().add(button);
        container.getChildren().add(textField);
        container.getChildren().add(progressBar);
        container.getChildren().add(textArea);

        button.setLayoutX(0);
        button.setLayoutY(250);

        Scene scene = new Scene(container);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Java FX Controls");
        primaryStage.setWidth(350);
        primaryStage.setHeight(350);
        primaryStage.setAlwaysOnTop(true);
        //primaryStage.setResizable(false);
        //primaryStage.setMaximized(true);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
