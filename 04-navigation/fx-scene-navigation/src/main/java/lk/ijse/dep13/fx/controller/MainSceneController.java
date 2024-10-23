package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {
    public Button btnNavigateToSecondaryScene;
    public AnchorPane root;

    public void btnNavigateToSecondarySceneOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        Scene secondaryScene = new Scene(FXMLLoader
                .load(getClass().getResource("/scene/SecondaryScene.fxml")));
        stage.setScene(secondaryScene);
        stage.sizeToScene();
        stage.centerOnScreen();
    }
}
