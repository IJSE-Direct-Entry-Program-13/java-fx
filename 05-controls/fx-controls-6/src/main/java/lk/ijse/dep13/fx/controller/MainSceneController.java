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
    public TextField txt2;
    public Button btnAdd2;
    public ListView<String> lst2;
    public Button btnDelete2;

    public void initialize(){
        btnDelete1.setDisable(true);
        btnDelete2.setDisable(true);
        lst1.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            // btnDelete1.setDisable(newValue.intValue() == -1);
            // btnDelete1.setDisable(lst1.getSelectionModel().getSelectedIndex() == -1);
            btnDelete1.setDisable(lst1.getSelectionModel().isEmpty());
        });
        lst2.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            // btnDelete1.setDisable(newValue.intValue() == -1);
            // btnDelete1.setDisable(lst1.getSelectionModel().getSelectedIndex() == -1);
            btnDelete2.setDisable(lst2.getSelectionModel().isEmpty());
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

    public void btnDelete2OnAction(ActionEvent actionEvent) {
        ObservableList<String> items = lst2.getItems();
        int selectedItemIndex = lst2.getSelectionModel().getSelectedIndex();
        items.remove(selectedItemIndex);
        lst2.getSelectionModel().clearSelection();
    }

    public void btnAdd2OnAction(ActionEvent actionEvent) {
        ObservableList<String> items = lst2.getItems();
        items.add(txt2.getText().strip());
        txt2.clear();
        txt2.requestFocus();
    }

    public void txt2OnAction(ActionEvent actionEvent) {
        btnAdd2.fire();
    }

    public void txt1OnAction(ActionEvent actionEvent) {
        btnAdd1.fire();
    }
}
