package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep13.fx.util.AppRouter;

import java.io.IOException;

public class MainSceneController {
    public AnchorPane root;
    public Label lblGreeting;
    public Button btnLogOut;

    public void initData(String fullName, String theme){
        lblGreeting.setText("Welcome %s!".formatted(fullName));
        root.getStyleClass().add(theme);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(AppRouter.getContainer(AppRouter.Routes.LOGIN).load()));
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
        ((Stage)(root.getScene().getWindow())).close();
    }
}
