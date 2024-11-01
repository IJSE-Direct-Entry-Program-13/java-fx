package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.dep13.fx.util.AppRouter;

import java.io.IOException;

public class MainSceneController {
    public AnchorPane root;
    public TextField txtRed;
    public TextField txtGreen;
    public TextField txtBlue;
    public Button btnChangeColor;

    public void btnChangeColorOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(AppRouter.getContainer(AppRouter.Routes.UTILITY).load()));
        stage.setTitle("Change Color");
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(root.getScene().getWindow());
        stage.show();
        stage.centerOnScreen();
    }
}
