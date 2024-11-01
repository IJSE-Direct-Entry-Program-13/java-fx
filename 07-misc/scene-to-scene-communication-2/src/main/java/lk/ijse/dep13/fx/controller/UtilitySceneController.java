package lk.ijse.dep13.fx.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

public class UtilitySceneController {
    public AnchorPane root;
    public Slider sldrRed;
    public Slider sldrGreen;
    public Slider sldrBlue;

    public void initData(SimpleDoubleProperty red, SimpleDoubleProperty green, SimpleDoubleProperty blue){
        sldrRed.valueProperty().bindBidirectional(red);
        sldrGreen.valueProperty().bindBidirectional(green);
        sldrBlue.valueProperty().bindBidirectional(blue);
    }
}
