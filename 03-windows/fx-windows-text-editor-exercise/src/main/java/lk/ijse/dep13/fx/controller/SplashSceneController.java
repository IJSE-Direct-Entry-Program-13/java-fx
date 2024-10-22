package lk.ijse.dep13.fx.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SplashSceneController {
    public AnchorPane root;
    public ProgressBar prg;
    public Label lblStatus;
    public Label lblProgress;

    double progress = 0.1;
    Timeline animationLoop;

    public void initialize() {
        prg.setProgress(0);
        lblProgress.setText("0%");

        var keyFrame = new KeyFrame(Duration.millis(100), e -> {
            if (progress <= 1) {
                prg.setProgress(progress += 0.05);
                lblProgress.setText("%.0f%%".formatted(progress * 100));
            } else {
                animationLoop.stop();
                ((Stage)(root.getScene().getWindow())).close();
                Stage stage = new Stage();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/scene/MainScene.fxml"))));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                stage.setTitle("DEP Text Editor");
                stage.show();
            }
        });
        animationLoop = new Timeline(keyFrame);
        animationLoop.setCycleCount(-1);
        animationLoop.playFromStart();
    }
}
