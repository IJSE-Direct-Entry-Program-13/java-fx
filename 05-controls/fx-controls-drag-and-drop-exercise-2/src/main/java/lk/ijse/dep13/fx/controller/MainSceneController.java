package lk.ijse.dep13.fx.controller;

import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainSceneController {
    public VBox container1;
    public Label lblTitle;
    public AnchorPane root;
    public VBox container2;

    public void onDragDropped(DragEvent dragEvent) {
    }

    public void onDragOver(DragEvent dragEvent) {
    }

    public void onDragDetected(MouseEvent mouseEvent) {
        Label lbl = (Label) mouseEvent.getSource();
        Dragboard dragboard = lbl.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(lbl.getText());
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        dragboard.setDragView(lbl.snapshot(snapshotParameters, null));
        dragboard.setContent(clipboardContent);
        lbl.getParent().getStyleClass().add("source");
    }

    public void onDragDone(DragEvent dragEvent) {
        Label lbl = (Label) dragEvent.getSource();
        lbl.getParent().getStyleClass().remove("source");
    }
}
