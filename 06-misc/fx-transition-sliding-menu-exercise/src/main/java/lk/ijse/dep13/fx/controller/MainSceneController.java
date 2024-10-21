package lk.ijse.dep13.fx.controller;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MainSceneController {

    public ImageView imgMenu;
    public Label lblDashboard;
    public Label lblLogOut;
    public Label lblSettings;
    public AnchorPane mainMenu;
    public AnchorPane root;

    public void initialize() {
        mainMenu.setTranslateX(-mainMenu.getPrefWidth());
    }

    public void imgMenuOnMouseClicked(MouseEvent event) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(500), mainMenu);
        tt.setFromX(-mainMenu.getPrefWidth());
        tt.setToX(0);
        tt.playFromStart();
        event.consume();
    }

    public void rootOnMouseClicked(MouseEvent event) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(500), mainMenu);
        tt.setFromX(0);
        tt.setToX(-mainMenu.getPrefWidth());
        tt.playFromStart();
    }

    public void lblMenuOnMouseEntered(MouseEvent mouseEvent) {
        Label lblMenu = (Label) mouseEvent.getTarget();
        lblMenu.setStyle("-fx-text-fill: red;");
    }

    public void lblMenuOnMouseExited(MouseEvent mouseEvent) {
        Label lblMenu = (Label) mouseEvent.getTarget();
        lblMenu.setStyle("-fx-text-fill: white;");
    }
}
