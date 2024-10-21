package lk.ijse.dep13.fx.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainSceneController {
    public AnchorPane root;
    public Rectangle ground;
    public ImageView character;
    int t = 0;
    int imageIndex = 1;
    int dx = 0;

    public void initialize() throws InterruptedException {
//        while (character.getLayoutY() < root.getPrefHeight() - ground.getHeight() - character.getHeight()){
//            character.setLayoutY(character.getLayoutY() + 10);
//            Thread.sleep(100);
//        }
        //int dy = 10;
        final double gravity = 7;
        var keyFrame1 = new KeyFrame(Duration.millis(1000 / 27.), (e) -> {
            double dy = gravity * t++;
            if (((character.getLayoutY() + dy) < root.getPrefHeight() - ground.getHeight() - character.getFitHeight())) {
                character.setLayoutY(character.getLayoutY() + dy);
            } else {
                t = 0;
                character.setLayoutY(root.getPrefHeight() - ground.getHeight() - character.getFitHeight());
            }
            if (dx != 0) {
                character.setLayoutX(character.getLayoutX() + dx);
//                character.setImage(new Image("/image/run/Run (%d).png".formatted(imageIndex++)));
//                if (imageIndex > 8) imageIndex = 1;
            } else {
                character.setImage(new Image("/image/idle/Idle (%d).png".formatted(imageIndex++)));
                if (imageIndex > 10) imageIndex = 1;
            }
        });
        Timeline tl = new Timeline(keyFrame1);
        tl.setDelay(Duration.millis(500));
        tl.setCycleCount(-1);
        tl.playFromStart();
    }

    public void rootOnKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.SPACE) {
            character.setLayoutY(character.getLayoutY() - 175);
        } else if (keyEvent.getCode() == KeyCode.LEFT) {
            //if (dx == 0) imageIndex = 1;
            dx = -10;
        } else if (keyEvent.getCode() == KeyCode.RIGHT) {
            //if (dx == 0) imageIndex = 1;
            dx = 10;
        }
    }

    public void rootOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.RIGHT) {
            //imageIndex = 1;
            dx = 0;
        }
    }
}
