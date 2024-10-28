package lk.ijse.dep13.fx.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class MainSceneController {
    public AnchorPane root;
    public Button btnFireSomething;
    public TextArea txt;
    public Rectangle shpRectangle;
    public Label lbl2;
    public Label lbl1;
    public Button btnAddClassA;
    public Button btnRemoveClasses;
    public Button btnAddClassB;

    public void btnFireSomethingOnAction(ActionEvent actionEvent) {
        lbl1.setStyle(lbl1.getStyle() + "-fx-border-color: white; -fx-font-size: 40px; -fx-background-color: black");
//        System.out.println("Txt: " + txt.getStyle());
//        System.out.println("Label1: " + lbl1.getStyle());
//        System.out.println("Label2: " + lbl2.getStyle());
//        System.out.println("btnFireSomething: " + btnFireSomething.getStyle());

//        System.out.println(shpRectangle.getScene());
//        System.out.println(txt.getScene());
//        System.out.println(lbl1.getScene());
//        System.out.println(lbl2.getScene());
//        lbl2.setTranslateX(100);
//        lbl2.setTranslateY(100);
//        lbl2.setRotationAxis(new Point3D(0, 1, 0));
//        lbl2.setRotate(45);
        //lbl2.setRotate(45);
        //System.out.println(lbl2.getRotationAxis());
//        lbl1.setScaleX(-2);
//        System.out.println(txt.getScaleX());
//        System.out.println(txt.getScaleY());
//        System.out.println(txt.getRotate());
//        System.out.println(txt.getRotationAxis());
//        System.out.println(txt.getTranslateX());
//        System.out.println(txt.getTranslateY());

//        System.out.println(txt.getParent());
//        System.out.println(shpRectangle.getParent());
//        System.out.println(btnFireSomething.getParent());
//        System.out.println(shpRectangle.getParent() == btnFireSomething.getParent());

//        shpRectangle.setOpacity(0.1);
//        lbl1.setOpacity(0.6);
//        System.out.println(lbl1.getOpacity());
//        System.out.println(shpRectangle.getOpacity());

//        System.out.printf("Label1 (x,y)=(%f, %f) %n", lbl1.getLayoutX(), lbl1.getLayoutY());
//        System.out.printf("Label2 (x,y)=(%f, %f) %n", lbl2.getLayoutX(), lbl2.getLayoutY());
//
//        lbl1.setLayoutX(0);
//        lbl1.setLayoutY(0);
//
//        lbl2.setLayoutX(0);
//        lbl2.setLayoutY(0);
//
//        System.out.printf("Label1 (x,y)=(%f, %f) %n", lbl1.getLayoutX(), lbl1.getLayoutY());
//        System.out.printf("Label2 (x,y)=(%f, %f) %n", lbl2.getLayoutX(), lbl2.getLayoutY());

//        shpRectangle.setLayoutX(0);
//        shpRectangle.setLayoutY(0);
//        txt.setLayoutX(0);
//        txt.setLayoutY(0);

//        System.out.println(shpRectangle.getLayoutX());
//        System.out.println(shpRectangle.getLayoutY());
//        System.out.println(txt.getLayoutX());
//        System.out.println(txt.getLayoutY());

//        root.setCursor(Cursor.CROSSHAIR);
//        btnFireSomething.setCursor(Cursor.HAND);
//        //txt.setCursor(Cursor.WAIT);
//        shpRectangle.setCursor(Cursor.WAIT);

//        System.out.println(root.getCursor());
//        System.out.println(btnFireSomething.getCursor());
//        System.out.println(txt.getCursor());
//        System.out.println(shpRectangle.getCursor());
    }

    public void btnAddClassAOnAction(ActionEvent actionEvent) {
        ObservableList<String> styleClassList = lbl2.getStyleClass();
        if (!styleClassList.contains("first-class")) styleClassList.add("first-class");
        else styleClassList.remove("first-class");
    }

    public void btnAddClassBOnAction(ActionEvent actionEvent) {
        ObservableList<String> styleClassList = lbl2.getStyleClass();
        if (!styleClassList.contains("second-class")) styleClassList.add("second-class");
        else styleClassList.remove("second-class");
    }

    public void btnRemoveClassesOnAction(ActionEvent actionEvent) {
        lbl2.getStyleClass().clear();
    }


}
