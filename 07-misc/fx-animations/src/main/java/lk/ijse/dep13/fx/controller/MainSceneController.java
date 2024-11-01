package lk.ijse.dep13.fx.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MainSceneController {

    public Button btnStart;
    public Button btnStop;
    public Label lblPreview;
    Timeline tl;

    public void btnStartOnAction(ActionEvent event) {
        var keyFrame1 = new KeyFrame(Duration.millis(100), (e)->{
            lblPreview.setTextFill(Color.RED);
        });
        var keyFrame2 = new KeyFrame(Duration.millis(200), (e)->{
            lblPreview.setTextFill(Color.GREEN);
            lblPreview.setRotate(45);
        });
        var keyFrame3 = new KeyFrame(Duration.millis(300), (e)->{
            lblPreview.setTextFill(Color.BLUE);
            lblPreview.setRotate(0);
            lblPreview.setScaleY(1.5);
            lblPreview.setScaleX(1.5);
        });
        var keyFrame4 = new KeyFrame(Duration.millis(400), (e)->{
            lblPreview.setTextFill(Color.ORANGE);
            lblPreview.setRotate(-45);
            lblPreview.setScaleY(1);
            lblPreview.setScaleX(1);
        });
        var keyFrame5 = new KeyFrame(Duration.millis(500), (e)->{
            lblPreview.setTextFill(Color.BLACK);
        });

        tl = new Timeline(keyFrame1, keyFrame2, keyFrame3, keyFrame4, keyFrame5);
        //tl.setDelay(Duration.seconds(2));
        tl.setCycleCount(-1);
        tl.playFromStart();
    }

    public void btnStopOnAction(ActionEvent event) {
        tl.stop();
    }

}
