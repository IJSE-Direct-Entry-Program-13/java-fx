package lk.ijse.dep13.fx.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainSceneController {
    public ListView<String> lst1;
    public TextField txt1;
    public Button btnAdd1;
    public Button btnDelete1;

    public void initialize(){
        btnDelete1.setDisable(true);
        lst1.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            // btnDelete1.setDisable(newValue.intValue() == -1);
            // btnDelete1.setDisable(lst1.getSelectionModel().getSelectedIndex() == -1);
            btnDelete1.setDisable(lst1.getSelectionModel().isEmpty());
        });
    }

    public void btnAdd1OnAction(ActionEvent actionEvent) {
        ObservableList<String> items = lst1.getItems();
        items.add(txt1.getText().strip());
        txt1.clear();
        txt1.requestFocus();
    }

    public void btnDelete1OnAction(ActionEvent actionEvent) {
        ObservableList<String> items = lst1.getItems();
        int selectedItemIndex = lst1.getSelectionModel().getSelectedIndex();
        items.remove(selectedItemIndex);
        lst1.getSelectionModel().clearSelection();
//        String selectedItem = lst1.getSelectionModel().getSelectedItem();
//        items.remove(selectedItem);
    }
}
