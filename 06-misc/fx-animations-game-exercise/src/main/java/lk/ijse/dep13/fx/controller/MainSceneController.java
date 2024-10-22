package lk.ijse.dep13.fx.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainSceneController {
    public AnchorPane root;
    public Rectangle ground;
    public Pane character;
    int t = 0;
    int imageIndex = 1;
    int dx = 0;
    boolean jump = true;

    public void initialize() throws InterruptedException {
//        while (character.getLayoutY() < root.getPrefHeight() - ground.getHeight() - character.getHeight()){
//            character.setLayoutY(character.getLayoutY() + 10);
//            Thread.sleep(100);
//        }
        //int dy = 10;
        final double gravity = 7;
        var keyFrame1 = new KeyFrame(Duration.millis(1000 / 27.), (e) -> {
            double dy = gravity * t++;
            if (((character.getLayoutY() + dy) < root.getHeight() - ground.getHeight() - character.getHeight())) {
                character.setLayoutY(character.getLayoutY() + dy);
            } else {
                if (jump) imageIndex = 1;
                jump = false;
                t = 0;
                character.setLayoutY(root.getHeight() - ground.getHeight() - character.getHeight());
            }
            if (jump){
                character.setLayoutX(character.getLayoutX() + dx);
                character.setStyle(getImage("/image/jump/Jump%%20(%d).png".formatted(imageIndex++)));
                if (imageIndex > 12) imageIndex = 1;
            }
            else if (dx != 0) {
                character.setLayoutX(character.getLayoutX() + dx);
                character.setStyle(getImage("/image/run/Run%%20(%d).png".formatted(imageIndex++)));
                if (imageIndex > 8) imageIndex = 1;
            } else {
                character.setStyle(getImage("/image/idle/Idle%%20(%d).png".formatted(imageIndex++)));
                if (imageIndex > 10) imageIndex = 1;
            }
        });
        Timeline tl = new Timeline(keyFrame1);
        tl.setDelay(Duration.millis(500));
        tl.setCycleCount(-1);
        Platform.runLater(tl::playFromStart);
    }

    private String getImage(String path) {
        return """
                -fx-background-image: url("%s");
                -fx-background-size: cover;
                -fx-background-repeat: no-repeat;
                -fx-background-position: bottom;
                """.formatted(path).strip();
    }

    public void rootOnKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.SPACE) {
            if (!jump){
                imageIndex = 1;
                character.setLayoutY(character.getLayoutY() - 175);
                jump = true;
            }
        } else if (keyEvent.getCode() == KeyCode.LEFT) {
            if (dx == 0){
                imageIndex = 1;
                character.setScaleX(-1);
            }
            dx = -20;
        } else if (keyEvent.getCode() == KeyCode.RIGHT) {
            if (dx == 0){
                imageIndex = 1;
                character.setScaleX(1);
            }
            dx = 20;
        }
    }

    public void rootOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.RIGHT) {
            imageIndex = 1;
            dx = 0;
        }
    }
}
