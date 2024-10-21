package lk.ijse.dep13.fx.controller;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MainSceneController {

    public ImageView imgMenu;
    public Label lblDashboard;
    public Label lblLogOut;
    public Label lblSettings;
    public AnchorPane mainMenu;
    public AnchorPane root;

    public void initialize() {
        mainMenu.setTranslateX(-mainMenu.getPrefWidth() - 2);
    }

    public void imgMenuOnMouseClicked(MouseEvent event) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(500), mainMenu);
        tt.setFromX(-mainMenu.getPrefWidth() - 2);
        tt.setToX(0);
        tt.playFromStart();
        event.consume();
    }

    public void rootOnMouseClicked(MouseEvent event) {
        hideMenu();
    }

    public void rootOnKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ESCAPE) hideMenu();
    }

    private void hideMenu(){
        if (mainMenu.getTranslateX() != 0) return;
        TranslateTransition tt = new TranslateTransition(Duration.millis(500), mainMenu);
        tt.setFromX(0);
        tt.setToX(-mainMenu.getPrefWidth() - 2);
        tt.playFromStart();
    }

    public void lblMenuOnMouseEntered(MouseEvent mouseEvent) {
        Label lblMenu = (Label) mouseEvent.getTarget();
        lblMenu.setTextFill(Color.AQUA);
    }

    public void lblMenuOnMouseExited(MouseEvent mouseEvent) {
        Label lblMenu = (Label) mouseEvent.getTarget();
        lblMenu.setTextFill(Color.WHITE);
    }


}
