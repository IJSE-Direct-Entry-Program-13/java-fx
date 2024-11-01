package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {
    public AnchorPane root;
    public Label lblGreeting;
    public Button btnLogOut;

    public void initData(String fullName, String theme){
        lblGreeting.setText("Welcome %s!".formatted(fullName));
        root.getStyleClass().add(theme);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
    }
}
