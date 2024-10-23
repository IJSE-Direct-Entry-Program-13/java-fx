package lk.ijse.dep13.fx.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ManageCustomerSceneController {
    public AnchorPane root;
    public Button btnBack;

    public void initialize(){
        FadeTransition ft = new FadeTransition(Duration.millis(500), root);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.playFromStart();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/scene/MainScene.fxml"))));
        stage.sizeToScene();
        stage.centerOnScreen();
    }
}
