package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TransparentSceneController {

    public Button btnClose;
    public AnchorPane root;

    public void btnCloseOnAction(ActionEvent event) {
        ((Stage)(root.getScene().getWindow())).close();
    }

    double mouseX, mouseY;

    public void rootOnMousePressed(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getSceneX();
        mouseY = mouseEvent.getSceneY();
    }

    public void rootOnMouseDragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - mouseX);
        stage.setY(mouseEvent.getScreenY() - mouseY);
    }

}
