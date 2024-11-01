package lk.ijse.dep13.fx.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class MainSceneController {
    public Pane container1;
    public AnchorPane root;
    public Button btnAddLabel;
    public Button btnAddButton;
    public Button btnClearNodes;
    public Button btnChangeDisplayOrder;
    public Button btn;
    public Rectangle rect;
    public Circle circle;

    public void btnClearNodesOnAction(ActionEvent actionEvent) {
        container1.getChildren().clear();
    }

    public void btnAddButtonOnAction(ActionEvent actionEvent) {
        Button button = new Button("My Button");
        ObservableList<Node> children = container1.getChildren();
        children.add(button);
        button.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
            double x = Math.random() * (container1.getWidth() - button.getWidth());
            double y = Math.random() * (container1.getHeight() - button.getHeight());
            button.setLayoutX(x);
            button.setLayoutY(y);
        });
    }

    public void btnAddLabelOnAction(ActionEvent actionEvent) {
        Label label = new Label("My Label");
        ObservableList<Node> children = container1.getChildren();
        children.add(label);
        label.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
            double x = Math.random() * (container1.getWidth() - label.getWidth());
            double y = Math.random() * (container1.getHeight() - label.getHeight());
            label.setLayoutX(x);
            label.setLayoutY(y);
        });
    }

    public void btnChangeDisplayOrderOnAction(ActionEvent actionEvent) {
//        circle.toFront();
//        btn.toFront();
        btn.setViewOrder(0);
        circle.setViewOrder(1);
        rect.setViewOrder(2);
    }
}
