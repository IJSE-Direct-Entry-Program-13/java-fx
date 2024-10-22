package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainSceneController {

    public Button btnAlerts;
    public Button btnFileDirectoryChooser;
    public Button btnModalWindow;
    public Button btnNewWindow;
    public Button btnTransparentWindow;
    public Button btnUndecoratedWindow;
    public Button btnUtilityWindow;
    public AnchorPane root;

    public void btnNewWindowOnAction(ActionEvent event) throws IOException {
        //Stage stage = new Stage(StageStyle.DECORATED);
        //Stage stage = new Stage(StageStyle.UNIFIED);
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load
                (getClass().getResource("/scene/SecondaryScene.fxml"))));
        stage.setTitle("New Main Window");
        stage.show();
    }

    public void btnUtilityWindowOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setScene(new Scene(FXMLLoader.load
                (getClass().getResource("/scene/SecondaryScene.fxml"))));
        stage.setTitle("New Utility Window");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.show();
    }

    public void btnUndecoratedWindowOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.setScene(new Scene(FXMLLoader.load
                (getClass().getResource("/scene/SecondaryScene.fxml"))));
        stage.setTitle("New Undecorated Window");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.show();
    }

    public void btnTransparentWindowOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.TRANSPARENT);
        AnchorPane container = FXMLLoader.load(getClass().getResource("/scene/TransparentScene.fxml"));
        Scene scene = new Scene(container);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        container.setBackground(Background.fill(Color.TRANSPARENT));
        stage.setTitle("New Transparent Window");
        stage.show();
    }

    public void btnModalWindowOnAction(ActionEvent event) {

    }

    public void btnAlertsOnAction(ActionEvent event) {

    }

    public void btnFileDirectoryChooserOnAction(ActionEvent event) {

    }

}
