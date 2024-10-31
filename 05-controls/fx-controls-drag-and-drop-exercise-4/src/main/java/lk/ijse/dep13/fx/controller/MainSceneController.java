package lk.ijse.dep13.fx.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainSceneController {

    public Button btnAdd;
    public Button btnDelete;
    public Label lblErrorHint;
    public ListView<String> lstContacts;
    public AnchorPane root;
    public TextField txtContact;
    public Label lblContact;

    public void initialize(){
        btnDelete.setDisable(true);
        lblErrorHint.setVisible(false);
        lblContact.setLabelFor(txtContact);
        lstContacts.getItems().addAll("011-1234567", "022-1234567", "033-1234567");

        txtContact.textProperty().addListener((observable, oldValue, newValue) -> {
           lblErrorHint.setVisible(false);
           txtContact.getStyleClass().remove("error");
        });

        lstContacts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(lstContacts.getSelectionModel().getSelectedItem() == null);
        });
    }

    public void btnAddOnAction(ActionEvent event) {
        txtContact.getStyleClass().remove("error");
        lblErrorHint.setVisible(false);

        if (txtContact.getText().isEmpty()) {
            txtContact.requestFocus();
        }else if (!isValidContact(txtContact.getText())){
            lblErrorHint.setText("Invalid contact number");
            lblErrorHint.setVisible(true);
            txtContact.getStyleClass().add("error");
            txtContact.requestFocus();
            txtContact.selectAll();
        }else if(lstContacts.getItems().contains(txtContact.getText())){
            lblErrorHint.setText("Contact number already exists");
            lblErrorHint.setVisible(true);
            txtContact.getStyleClass().add("error");
            txtContact.requestFocus();
            txtContact.selectAll();
        }else{
            lstContacts.getItems().add(txtContact.getText());
            txtContact.clear();
            txtContact.requestFocus();
        }
    }

    private boolean isValidContact(String contact){
        contact = contact.strip();
        if (contact.length() != 11) return false;
        for (int i = 0; i < contact.length() ; i++) {
            if (i == 3) {
                if (contact.charAt(3) == '-') continue;
                return false;
            }
            if (!Character.isDigit(contact.charAt(i))) return false;
        }
        return true;
    }

    public void lstContactsOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnDelete.fire();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        ObservableList<String> contactList = lstContacts.getItems();
        String selectedContact = lstContacts.getSelectionModel().getSelectedItem();
        contactList.remove(selectedContact);
        if (contactList.isEmpty()) txtContact.requestFocus();
    }

    public void lstContactsOnDragDetected(MouseEvent mouseEvent) {
        if (lstContacts.getSelectionModel().getSelectedItem() == null) return;
        if (mouseEvent.getTarget().toString().contains("null")) return;

        Dragboard dragboard = lstContacts.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(lstContacts.getSelectionModel().getSelectedItem());
        dragboard.setContent(clipboardContent);

        Text text = new Text(clipboardContent.getString());
        text.setFont(new Font(16));
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.AQUA);
        dragboard.setDragView(text.snapshot(snapshotParameters, null));

        //selectedIndex = lstContacts.getSelectionModel().getSelectedIndex();
    }

    int previousIndex = -1;
    //int selectedIndex = -1;

    public void lstContactsOnDragOver(DragEvent dragEvent) {
        if(dragEvent.getGestureSource() != lstContacts) return;

        dragEvent.acceptTransferModes(TransferMode.MOVE);
        EventTarget target = dragEvent.getTarget();
        String targetContact;
        if (target instanceof IndexedCell<?> cell) targetContact = cell.getText();
        else if (target instanceof Text text) targetContact = text.getText();
        else return;
        if (targetContact == null) return;

        int index = lstContacts.getItems().indexOf(targetContact);

        if (index != previousIndex){
            if (previousIndex != -1) lstContacts.getItems().remove(previousIndex);
            lstContacts.getItems().add(index, "");
            previousIndex = index;
        }
    }

    public void lstContactsOnDragExited(DragEvent dragEvent) {
        if (previousIndex != -1 ) lstContacts.getItems().remove(previousIndex);
        previousIndex = -1;
    }

    public void lstContactsOnDragDropped(DragEvent dragEvent) {
        int currentIndex = lstContacts.getItems().indexOf(dragEvent.getDragboard().getString());
        lstContacts.getItems().set(previousIndex, dragEvent.getDragboard().getString());
        lstContacts.getSelectionModel().select(previousIndex);
        lstContacts.getItems().remove(currentIndex);
        previousIndex = -1;
    }
}
