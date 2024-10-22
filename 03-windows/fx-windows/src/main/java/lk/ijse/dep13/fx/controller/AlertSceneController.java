package lk.ijse.dep13.fx.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

public class AlertSceneController {

    public Button btnConfirmationAlert;
    public Button btnCustomizedAlert;
    public Button btnNormalAlert;
    public AnchorPane root;

    public void btnNormalAlertOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Information Alert",
                ButtonType.NEXT,ButtonType.APPLY, ButtonType.CLOSE);
//        alert.setTitle("My Title");
//        alert.setHeaderText("This is Crazy");
        alert.show();
//         new Alert(Alert.AlertType.WARNING, "Warning Alert").show();
//        new Alert(Alert.AlertType.ERROR, "Error Alert").show();
//        new Alert(Alert.AlertType.CONFIRMATION, "Confirmation Alert").show();
//        new Alert(Alert.AlertType.NONE, "Simple Alert").show();
    }

    public void btnConfirmationAlertOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to exit",
                ButtonType.YES, ButtonType.NO);
        alert.setTitle("Exit");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            Platform.exit();
        }else{
            System.out.println("Just chill man");
        }
    }

    public void btnCustomizedAlertOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Customized Alert");
        alert.setHeaderText("This is awesome");
        alert.setContentText("I can customize everything here");

        alert.getButtonTypes().add(ButtonType.CANCEL);
        alert.getButtonTypes().add(new ButtonType("Login via Google"));
        alert.getButtonTypes().add(new ButtonType("Login via GitHub"));

        alert.setGraphic(new ImageView(new Image("/image/icon.png", 48,48, true, true)));
        Optional<ButtonType> buttonType = alert.showAndWait();
        System.out.println(buttonType.get());
    }



}
