package lk.ijse.dep13.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {

    public AnchorPane dropTarget;
    public Label lblDragMe;

    public void lblDragMeOnDragDetected(MouseEvent event) {
        System.out.println("Drag detected");
        Dragboard dragboard = lblDragMe.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString("Hello");
        dragboard.setContent(clipboardContent);
    }

    public void lblDragMeOnDragDone(DragEvent event) {
        System.out.println("Drag done");
        System.out.println(event.getDragboard().getString());
    }

    public void dropTargetOnDragOver(DragEvent event) {
        System.out.println("Drag over");
        event.acceptTransferModes(TransferMode.ANY);
        System.out.println(event.getDragboard().getString());
    }

    public void dropTargetOnDragDropped(DragEvent event) {
        System.out.println("Drag dropped");
        System.out.println(event.getDragboard().getString());
    }

    public void dropTargetOnDragEntered(DragEvent event) {
        System.out.println("Drag entered");
        System.out.println(event.getDragboard().getString());
    }

    public void dropTargetOnDragExited(DragEvent event) {
        System.out.println("Drag exited");
        System.out.println(event.getDragboard().getString());
    }

}
