package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class MainSceneController {

    public Button btnClear;
    public Button btnValidate;
    public TextField txtId;
    public TextField txtName;
    public TextField txtNic;

    public void initialize() {
        txtId.textProperty().addListener((observable, oldId, newId) -> {
            txtId.getStyleClass().remove("error");
            txtId.getStyleClass().remove("success");
            if (isValidId(newId)) txtId.getStyleClass().add("success");
            else txtId.getStyleClass().add("error");
        });

        txtName.textProperty().addListener((observable, oldName, newName) -> {
            txtName.getStyleClass().remove("error");
            txtName.getStyleClass().remove("success");
            if (isValidName(newName)) txtName.getStyleClass().add("success");
            else txtName.getStyleClass().add("error");
        });

        txtNic.textProperty().addListener((observable, oldNic, newNic) -> {
            txtNic.getStyleClass().remove("error");
            txtNic.getStyleClass().remove("success");
            if (isValidNic(newNic)) txtNic.getStyleClass().add("success");
            else txtNic.getStyleClass().add("error");
        });
    }

    private boolean isValidNic(String input){
        return input.matches("\\d{9}[Vv]");
//        input = input.strip().toUpperCase();
//        if (input.length() != 10 || !input.endsWith("V")) return false;
//        for (int i = 0; i < 9; i++) {
//            if (!Character.isDigit(input.charAt(i))) return false;
//        }
//        return true;
    }

    private boolean isValidName(String input){
        return input.matches("[A-Za-z ]+");
//        input = input.strip();
//        if (input.isEmpty()) return false;
//        for (int i = 0; i < input.length(); i++) {
//            if (!(Character.isLetter(input.charAt(i)) || Character.isSpaceChar(input.charAt(i)))) return false;
//        }
//        return true;
    }

    private boolean isValidId(String input) {
        return input.matches("C\\d{3}");
//        input = input.strip();
//        if (input.length() != 4) return false;
//        if (input.charAt(0) != 'C') return false;
//        for (int i = 0; i < 3; i++) {
//            if (!Character.isDigit(input.charAt(i + 1))) return false;
//        }
//        return true;
    }

    public void btnValidateOnAction(ActionEvent event) {
        boolean validate = true;

        if (!isValidNic(txtNic.getText())){
            txtNic.getStyleClass().add("error");
            txtNic.requestFocus();
            validate = false;
        }

        if (!isValidName(txtName.getText())){
            txtName.getStyleClass().add("error");
            txtName.requestFocus();
            validate = false;
        }

        if (!isValidId(txtId.getText())){
            txtId.getStyleClass().add("error");
            txtId.requestFocus();
            validate = false;
        }

        if (validate){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to start again?",
                    ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("Validation OK");
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get() == ButtonType.YES) btnClear.fire();
            txtId.requestFocus();
        }else{
            new Alert(Alert.AlertType.ERROR, "Validation Failed").show();
        }
    }

    public void btnClearOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtNic.clear();
        txtId.requestFocus();
        TextField[] texts = {txtId, txtName, txtNic};
        for (int i = 0; i < texts.length; i++) {
            texts[i].getStyleClass().removeAll("error", "success");
        }
//        txtId.getStyleClass().remove("error");
//        txtId.getStyleClass().remove("success");
//        txtName.getStyleClass().remove("error");
//        txtName.getStyleClass().remove("success");
//        txtNic.getStyleClass().remove("success");
//        txtNic.getStyleClass().remove("error");
    }

}
