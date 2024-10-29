package lk.ijse.dep13.fx.controller;

import javafx.scene.control.Label;
import javafx.scene.input.*;

public class MainSceneController {
    public void lblOnDragDetected(MouseEvent mouseEvent) {
        Label lbl = (Label) mouseEvent.getSource();
        Dragboard dragboard = lbl.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(lbl.getStyle());
        dragboard.setDragView(lbl.snapshot(null, null));
        dragboard.setContent(clipboardContent);
        mouseEvent.consume();
    }

}
