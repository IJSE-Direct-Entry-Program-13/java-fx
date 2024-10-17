package lk.ijse.dep13.fx.controller;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {
    public Label lblCursor;
    public AnchorPane root;

    public void rootOnMouseExited(MouseEvent mouseEvent) {
        double x = root.getWidth() / 2 - lblCursor.getWidth() / 2;
        double y = root.getHeight() / 2 - lblCursor.getHeight() / 2;
        lblCursor.setLayoutX(x);
        lblCursor.setLayoutY(y);
    }

    public void rootOnMouseMoved(MouseEvent mouseEvent) {
        double x = mouseEvent.getX() - lblCursor.getWidth() / 2;
        double y = mouseEvent.getY() - lblCursor.getHeight() / 2;
        lblCursor.setLayoutX(x);
        lblCursor.setLayoutY(y);
    }
}
