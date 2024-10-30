package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

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
    public DatePicker dtPicker;
    public Label lblPreview;
    public ToggleButton tglBold;
    public ToggleButton tglItalic;
    public Label lblPreviewText;
    public CheckBox chkItalic;
    public CheckBox chkBold;
    public RadioButton rdMale;
    public RadioButton rdFemale;
    public Button btnClearSelection;
    public Button btnGetGender;
    public Button btnSetMale;
    public Button btnSetFemale;
    public ToggleGroup tglGender;

    public void btnClearSelectionOnAction(ActionEvent actionEvent) {
        tglGender.selectToggle(null);
    }

    public void btnGetGenderOnAction(ActionEvent actionEvent) {
        System.out.println(tglGender.getSelectedToggle());
    }

    public void btnSetMaleOnAction(ActionEvent actionEvent) {
        //rdMale.setSelected(true);
        tglGender.selectToggle(rdMale);
    }

    public void btnSetFemaleOnAction(ActionEvent actionEvent) {
        tglGender.selectToggle(rdFemale);
    }

    public void chkBoldOnAction(ActionEvent actionEvent) {
        updatePreviewText();
    }

    public void chkItalicOnAction(ActionEvent actionEvent) {
        updatePreviewText();
    }

    private void updatePreviewText() {
        lblPreviewText.setStyle("%s;%s".formatted(
                chkBold.isSelected() ? "-fx-font-weight: bold" : "-fx-font-weight: normal",
                chkItalic.isSelected()? "-fx-font-style: italic": "-fx-font-style: normal"));
    }

    public void tglBoldOnAction(ActionEvent actionEvent) {
        updatePreview();
    }

    public void tglItalicOnAction(ActionEvent actionEvent) {
        updatePreview();
    }

    private void updatePreview() {
        lblPreview.setStyle("%s;%s".formatted(tglBold.isSelected() ? "-fx-font-weight: bold" : "-fx-font-weight: normal",
                tglItalic.isSelected()? "-fx-font-style: italic": "-fx-font-style: normal"));
    }

    public void initialize() {
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
        btnShowHide.setTooltip(new Tooltip(txtPlainPassword.isVisible() ? "Hide password" : "Show Password"));
        //dtPicker.setValue(LocalDate.now());
        dtPicker.setValue(LocalDate.of(2000, 5, 3));
    }

    public void dtPickerOnAction(ActionEvent actionEvent) {
        System.out.println(dtPicker.getValue());
    }

    public void btnShowHideOnAction(ActionEvent actionEvent) {
        txtPlainPassword.setVisible(!txtPlainPassword.isVisible());
        txtPassword.setVisible(!txtPassword.isVisible());
        ((ImageView) btnShowHide.getGraphic()).setImage(new Image("/icon/%s".formatted(txtPlainPassword.isVisible() ? "show.png" : "hide.png")));
        btnShowHide.getTooltip().setText(txtPlainPassword.isVisible() ? "Hide password" : "Show Password");
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
