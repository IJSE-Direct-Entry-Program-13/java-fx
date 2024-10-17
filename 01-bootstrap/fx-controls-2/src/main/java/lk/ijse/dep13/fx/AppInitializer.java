package lk.ijse.dep13.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("App Login");
        Label description = new Label("Enter your login credentials");
        Label username = new Label("Username");
        Label password = new Label("Password");
        TextField txtUsername = new TextField();
        PasswordField txtPassword = new PasswordField();
        Button login = new Button("Login");
        Button exit = new Button("Exit");
        HBox hbox1 = new HBox(username, txtUsername);
        HBox hbox2 = new HBox(password, txtPassword);
        HBox hbox3 = new HBox(login, exit);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);
        hbox2.setSpacing(10);
        hbox3.setSpacing(10);

        VBox container = new VBox(title, description, hbox1, hbox2, hbox3);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(10);
        title.setFont(Font.font(16));
//        container.getChildren().add(title);
//        container.getChildren().add(description);
        Scene mainScene = new Scene(container);
        primaryStage.setScene(mainScene);
        primaryStage.setWidth(375);
        primaryStage.setHeight(250);
        primaryStage.setTitle("App Login");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
