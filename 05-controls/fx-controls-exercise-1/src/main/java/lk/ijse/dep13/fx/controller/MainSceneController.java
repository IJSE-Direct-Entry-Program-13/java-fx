package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainSceneController {

    public Button btnClear;
    public Button btnValidate;
    public TextField txtId;
    public TextField txtName;
    public TextField txtNic;

    public void initialize(){
        txtId.textProperty().addListener((observable, oldValue, newValue) -> {
            txtId.getStyleClass().remove("error");
            txtId.getStyleClass().remove("success");
            if (newValue.startsWith("C")){
                txtId.getStyleClass().add("success");
            }else{
                txtId.getStyleClass().add("error");
            }
        });
    }

    public void btnClearOnAction(ActionEvent event) {

    }

    public void btnValidateOnAction(ActionEvent event) {

    }

}
