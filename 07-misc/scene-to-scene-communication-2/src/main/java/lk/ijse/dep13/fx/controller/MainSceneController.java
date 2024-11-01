package lk.ijse.dep13.fx.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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

    SimpleDoubleProperty red = new SimpleDoubleProperty(100);
    SimpleDoubleProperty green = new SimpleDoubleProperty(220);
    SimpleDoubleProperty blue = new SimpleDoubleProperty(80);

    public void initialize(){
        txtRed.setText(String.valueOf(red.get()));
        txtGreen.setText(String.valueOf(green.get()));
        txtBlue.setText(String.valueOf(blue.get()));
        red.addListener((observable, oldValue, newValue) -> {
            txtRed.setText(String.valueOf(newValue));
            updateBackground();
        });
        green.addListener((observable, oldValue, newValue) -> {
            txtGreen.setText(String.valueOf(newValue));
            updateBackground();
        });
        blue.addListener((observable, oldValue, newValue) -> {
            txtBlue.setText(String.valueOf(newValue));
            updateBackground();
        });
        updateBackground();
    }

    private void updateBackground(){
        root.setStyle("-fx-background-color: rgb(%s,%s,%s);".formatted(
                txtRed.getText(),
                txtGreen.getText(),
                txtBlue.getText()
        ));
    }

    public void btnChangeColorOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader container = AppRouter.getContainer(AppRouter.Routes.UTILITY);
        stage.setScene(new Scene(container.load()));
        UtilitySceneController controller = container.getController();
        controller.initData(red, green, blue);
        stage.setTitle("Change Color");
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(root.getScene().getWindow());
        stage.show();
        stage.setY(root.getScene().getWindow().getY() + root.getScene().getWindow().getHeight() - 100);
    }
}
