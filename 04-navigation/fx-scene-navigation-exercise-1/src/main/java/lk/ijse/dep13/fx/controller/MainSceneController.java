package lk.ijse.dep13.fx.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MainSceneController {

    public ImageView imgCustomer;
    public ImageView imgOrder;
    public ImageView imgSettings;
    public ImageView imgStock;
    public Label lblDescription;
    public AnchorPane root;

    public void imgOnMouseEntered(MouseEvent event) {
        ScaleTransition ft = new ScaleTransition(Duration.millis(200), (ImageView) event.getTarget());
        ft.setFromX(1);
        ft.setFromY(1);
        ft.setToX(1.1);
        ft.setToY(1.1);
        ft.playFromStart();

        ImageView menuItem = (ImageView) event.getTarget();
        if (menuItem == imgCustomer){
            lblDescription.setText("Manage Customers");
        }else if (menuItem == imgOrder){
            lblDescription.setText("Place New Order");
        }else if (menuItem == imgStock){
            lblDescription.setText("Manage Stock");
        }else{
            lblDescription.setText("Configure Settings");
        }
    }

    public void imgOnMouseExited(MouseEvent event) {
        ScaleTransition ft = new ScaleTransition(Duration.millis(200), (ImageView) event.getTarget());
        ft.setFromX(1.1);
        ft.setFromY(1.1);
        ft.setToX(1);
        ft.setToY(1);
        ft.playFromStart();

        lblDescription.setText("Select a menu to proceed");
    }
}
