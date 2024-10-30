package lk.ijse.dep13.fx.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.util.List;

public class MainSceneController {

    public ImageView imgDisplay;
    public StackPane dropTarget;
    public Label lblDragSource;

    public void lblDragSourceOnDragDetected(MouseEvent mouseEvent) {
        System.out.println("Drag Detected");
        Dragboard dragboard = lblDragSource.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(lblDragSource.getText());
        WritableImage snapshot = lblDragSource.snapshot(null, null);
        //imgDisplay.setImage(snapshot);
        dragboard.setDragView(snapshot);
        dragboard.setContent(content);
    }

    public void lblDragSourceOnDragDone(DragEvent dragEvent) {
        Object acceptingObject = dragEvent.getAcceptingObject();
        System.out.println(acceptingObject);
        if (acceptingObject != null) {
            lblDragSource.setVisible(false);
        }
    }

    public void dropTargetOnDragOver(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasFiles()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
        System.out.println("Drag Over");
    }

    public void dropTargetOnDragEntered(DragEvent dragEvent) {
        System.out.println("Drag Entered");
    }

    public void dropTargetOnDragExited(DragEvent dragEvent) {
        System.out.println("Drag Exited");
    }

    public void dropTargetOnDragDropped(DragEvent dragEvent) {
        List<File> files = dragEvent.getDragboard().getFiles();
        File firstFile = files.getFirst();
        if (firstFile.getName().endsWith(".jpeg") || firstFile.getName().endsWith(".jpg") ||
                firstFile.getName().endsWith(".png") || firstFile.getName().endsWith(".gif")) {
            Image image = new Image(firstFile.toURI().toString());
            imgDisplay.setImage(image);
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid image file").show();
        }
    }
}
