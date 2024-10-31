package lk.ijse.dep13.fx.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MainSceneController {
    public ComboBox<String> cmbCountry;
    public TextField txtCountry;
    public Button btnAdd;
    public Label lblSelectedCountry;
    public Button btnClearSelection;

    public void initialize() {
        cmbCountry.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (cmbCountry.getSelectionModel().getSelectedItem() == null){
                lblSelectedCountry.setText("No Selected Country");
            }else {
                lblSelectedCountry.setText("Selected Country: " + newValue);
            }
        });
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        ObservableList<String> countryList = cmbCountry.getItems();
        if (txtCountry.getText().isBlank()){
            txtCountry.requestFocus();
        }else if (countryList.contains(txtCountry.getText().strip())){
            new Alert(Alert.AlertType.ERROR, "Country already exists").showAndWait();
            txtCountry.requestFocus();
            txtCountry.selectAll();
        }else{
            countryList.add(txtCountry.getText().strip());
            txtCountry.clear();
            txtCountry.requestFocus();
        }
    }

    public void btnClearSelectionOnAction(ActionEvent actionEvent) {
        cmbCountry.getSelectionModel().clearSelection();
    }
}
