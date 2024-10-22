package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ModalSceneController {
    public AnchorPane root;
    public Button btnWindowModal;
    public Button btnApplicationModal;

    public void btnWindowModalOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/scene/ModalPreviewScene.fxml"))));
        stage.setTitle("Application Modal");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(root.getScene().getWindow());
        stage.show();
    }

    public void btnApplicationModalOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/scene/ModalPreviewScene.fxml"))));
        stage.setTitle("Application Modal");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
