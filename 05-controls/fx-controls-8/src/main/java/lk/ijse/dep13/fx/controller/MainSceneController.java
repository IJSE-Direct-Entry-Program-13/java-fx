package lk.ijse.dep13.fx.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep13.fx.tm.Customer;

public class MainSceneController {
    public AnchorPane root;
    public TableView<Customer> tblCustomers;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnAdd;
    public Button btnDelete;

    public void initialize(){
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList<Customer> customerList = tblCustomers.getItems();
//        customerList.add(new Customer(1, "Kasun", "Galle"));
//        customerList.add(new Customer(2, "Nuwan", "Panadura"));
//        customerList.add(new Customer(3, "Ruwan", "Moratuwa"));

        btnDelete.setDisable(true);

        tblCustomers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            if (newValue != null) {
                System.out.println("%s-%s".formatted(newValue.getName(), newValue.getAddress()));
            }
        });
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        ObservableList<Customer> customerList = tblCustomers.getItems();
        int selectedCustomerIndex = tblCustomers.getSelectionModel().getSelectedIndex();
        customerList.remove(selectedCustomerIndex);
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        int id = Integer.valueOf(txtId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();

        Customer customer = new Customer(id, name, address);
        ObservableList<Customer> customerList = tblCustomers.getItems();
        customerList.add(customer);

        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtId.requestFocus();
    }


}
