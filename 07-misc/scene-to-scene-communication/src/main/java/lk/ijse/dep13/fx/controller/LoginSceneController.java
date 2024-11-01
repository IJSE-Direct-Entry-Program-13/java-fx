package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep13.fx.util.AppRouter;

import java.io.IOException;

public class LoginSceneController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnLogIn;
    public AnchorPane root;

    String[] fullNames = {"Upul Tharanga", "Kasun Sampath", "Nuwan Ramindu"};
    String[] usernames = {"upul", "kasun", "nuwan"};
    String[] passwords = {"upul123", "kasun123", "nuwan123"};
    String[] themes = {"dark", "light", "dark"};

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {
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
                if (usernames[i].equals(username)){
                    if (passwords[i].equals(password)){
                        Stage stage = new Stage();

                        // AnchorPane container = FXMLLoader.load(getClass().getResource("/scene/MainScene.fxml"));
                        FXMLLoader container = AppRouter.getContainer(AppRouter.Routes.MAIN);
                        stage.setScene(new Scene(container.load()));

                        MainSceneController controller = (MainSceneController) container.getController();
                        controller.initData(fullNames[i], themes[i]);

                        stage.setTitle("Main App");
                        stage.show();
                        stage.centerOnScreen();
                        ((Stage) root.getScene().getWindow()).close();
                        return;
                    }else break;
                }
            }
            new Alert(Alert.AlertType.ERROR, "Invalid username or password").showAndWait();
            txtUsername.requestFocus();
            txtUsername.selectAll();
        }
    }
}
