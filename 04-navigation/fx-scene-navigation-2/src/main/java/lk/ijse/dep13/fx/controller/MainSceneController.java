package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep13.fx.util.AppRouter;

import java.io.IOException;

public class MainSceneController {

    public Button btnUserInterface1;
    public Button btnUserInterface2;
    public Button btnUserInterface3;
    public AnchorPane root;
    public AnchorPane routerOutlet;

    public void initialize(){
        btnUserInterface1.fire();
    }

    public void btnOnAction(ActionEvent event) throws IOException {
        Button btn = (Button) event.getTarget();

        AnchorPane container;
        if (btn == btnUserInterface1){
            container = AppRouter.getContainer(AppRouter.Routes.USER_INTERFACE1);
        } else if (btn == btnUserInterface2) {
            container = AppRouter.getContainer(AppRouter.Routes.USER_INTERFACE2);
        }else{
            container = AppRouter.getContainer(AppRouter.Routes.USER_INTERFACE3);
        }

        routerOutlet.getChildren().clear();
        routerOutlet.getChildren().add(container);

        AnchorPane.setTopAnchor(container, 0.0);
        AnchorPane.setRightAnchor(container, 0.0);
        AnchorPane.setBottomAnchor(container, 0.0);
        AnchorPane.setLeftAnchor(container, 0.0);
    }

}
