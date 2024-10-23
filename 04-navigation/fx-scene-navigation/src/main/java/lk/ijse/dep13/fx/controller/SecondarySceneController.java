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

public class SecondarySceneController {
    public AnchorPane root;
    public Button btnNavigateToMainScene;

    public void initialize() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), root);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.playFromStart();
    }

    public void btnNavigateToMainSceneOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        Scene secondaryScene = new Scene(FXMLLoader
                .load(getClass().getResource("/scene/MainScene.fxml")));
        stage.setScene(secondaryScene);
        stage.sizeToScene();
        stage.centerOnScreen();
    }
}
