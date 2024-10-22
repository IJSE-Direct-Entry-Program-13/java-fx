package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SecondarySceneController {

    public Button btnClose;
    public AnchorPane root;

    public void btnCloseOnAction(ActionEvent event) {
         Stage stage = (Stage) root.getScene()
                 .getWindow();
         stage.close();
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
