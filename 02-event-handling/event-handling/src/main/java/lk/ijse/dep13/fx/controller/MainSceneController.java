package lk.ijse.dep13.fx.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {
    public Button btnOk;
    public ListView<?> lstSomething;
    public AnchorPane root;
    public TextField txtInput;

    public void initialize(){
        EventHandler<KeyEvent> keyPressEventHandler = event ->{
            System.out.println("Pressed: " + event.getCode()) ;
        };
        EventHandler<MouseEvent> mouseMoveEventHandler = event ->{
            System.out.printf("(%.2f, %.2f) %n", event.getX(), event.getY());
        };
        EventHandler<MouseEvent> clickEventHandler = event ->{
            System.out.println("Clicked1");
            System.out.println(event.getButton());
            System.out.println(event.getClickCount());
            root.removeEventHandler(MouseEvent.MOUSE_MOVED, mouseMoveEventHandler);
        };
        EventHandler<MouseEvent> clickEventHandler2 = event -> {
            System.out.println("Clicked2");
        };


        btnOk.addEventHandler(MouseEvent.MOUSE_CLICKED, clickEventHandler2);
        btnOk.addEventHandler(MouseEvent.MOUSE_CLICKED, clickEventHandler);
        txtInput.addEventHandler(KeyEvent.KEY_PRESSED, keyPressEventHandler);
        //root.addEventHandler(MouseEvent.MOUSE_MOVED, mouseMoveEventHandler);
        //root.setOnMouseMoved(mouseMoveEventHandler);
        //lstSomething.addEventHandler(MouseEvent.MOUSE_CLICKED, clickEventHandler);
        lstSomething.setOnMouseClicked(event ->{
            System.out.println("Clicked1");
            System.out.println(event.getButton());
            System.out.println(event.getClickCount());
            root.removeEventHandler(MouseEvent.MOUSE_MOVED, mouseMoveEventHandler);
        });
//        lstSomething.setOnMouseClicked(clickEventHandler2);
        btnOk.setOnMouseExited(event ->{
            System.out.println("Yanna giya button eken mouse eka eliyata");
        });
    }
}
