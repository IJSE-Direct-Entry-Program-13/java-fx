package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginSceneController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnLogIn;
    public AnchorPane root;

    String[] fullNames = {"Upul Tharanga", "Kasun Sampath", "Nuwan Ramindu"};
    String[] usernames = {"admin", "kasun", "nuwan"};
    String[] passwords = {"admin123", "kasun123", "nuwan123"};
    String[] themes = {"dark", "light", "dark"};

    public void btnLogInOnAction(ActionEvent actionEvent) {
        String username = txtUsername.getText().strip();
        String password = txtPassword.getText().strip();

        if (username.isEmpty()){
            txtUsername.requestFocus();
            txtUsername.selectAll();
        }else if (password.isEmpty()){
            txtPassword.requestFocus();
            txtPassword.selectAll();
        }else{
            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i].equals(username)) {
                    if (passwords[i].equals(password)) {
                        System.out.println("Logged In");
                        return;
                    }else break;
                }
            }
            new Alert(Alert.AlertType.ERROR, "Invalid Username or Password").showAndWait();
            txtUsername.requestFocus();
            txtUsername.selectAll();
        }
    }
}
