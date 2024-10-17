package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SecondSceneController {
    public Button btnClickMe;
    public AnchorPane root;

    public void btnClickMeOnAction(ActionEvent event) {
        System.out.println("Clicked");
        btnClickMe.setLayoutX(Math.random() * root.getWidth());
        btnClickMe.setLayoutY(Math.random() * root.getHeight());
    }

    public void rootOnMouseMoved(MouseEvent event) {
        System.out.printf("x,y = (%.2f, %.2f) %n", event.getX(), event.getY());
    }
}
