package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainSceneController {
    public Slider sldrProgress;
    public ProgressBar prgBar;
    public Label lblProgress;
    public AnchorPane root;
    public TextField txtInput;
    public Button btnClear;
    public Button btnFocus;
    public Button btnSelect;
    public HBox passwordContainer;
    public Button btnShowHide;
    public TextField txtPlainPassword;
    public PasswordField txtPassword;

    public void initialize(){
        prgBar.progressProperty().bind(sldrProgress.valueProperty());
        prgBar.progressProperty().addListener((observable, oldValue, newValue) -> {
            lblProgress.setText("%.2f%%".formatted(newValue.doubleValue() * 100));
        });
        sldrProgress.setValue(.25);

        txtInput.caretPositionProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        txtPlainPassword.textProperty().bindBidirectional(txtPassword.textProperty());
        txtPlainPassword.setVisible(false);
        btnShowHide.setTooltip(new Tooltip(txtPlainPassword.isVisible() ? "Hide password": "Show Password"));
    }

    public void btnShowHideOnAction(ActionEvent actionEvent) {
        txtPlainPassword.setVisible(!txtPlainPassword.isVisible());
        txtPassword.setVisible(!txtPassword.isVisible());
        ((ImageView)btnShowHide.getGraphic()).setImage(new Image("/icon/%s".formatted(txtPlainPassword.isVisible() ? "show.png": "hide.png")));
        btnShowHide.getTooltip().setText(txtPlainPassword.isVisible() ? "Hide password": "Show Password");
    }

    public void btnSelectOnAction(ActionEvent actionEvent) {
        txtInput.requestFocus();
        // txtInput.selectAll();
        txtInput.selectRange(0, 2);
        // txtInput.deselect();
    }

    public void btnFocusOnAction(ActionEvent actionEvent) {
        txtInput.requestFocus();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtInput.clear();   // txtInput.setText("");
    }
}
