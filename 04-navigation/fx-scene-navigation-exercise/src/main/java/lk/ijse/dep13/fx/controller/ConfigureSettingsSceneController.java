package lk.ijse.dep13.fx.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.dep13.fx.util.AppRouter;

import java.io.IOException;

public class ConfigureSettingsSceneController {
    public AnchorPane root;
    public Button btnBack;

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(AppRouter.getContainer(AppRouter.Routes.MAIN)));
        stage.sizeToScene();
        stage.centerOnScreen();
    }
}
