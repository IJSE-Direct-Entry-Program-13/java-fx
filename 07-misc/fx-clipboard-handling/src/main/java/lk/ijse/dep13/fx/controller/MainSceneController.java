package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainSceneController {
    public Button btnReadText;
    public Button btnReadFiles;
    public Button btnSetText;
    public Button btnSetFiles;
    public Button btnClear;

    public void btnReadTextOnAction(ActionEvent actionEvent) {
        Clipboard systemClipboard = Clipboard.getSystemClipboard();
        System.out.println("Found: " + systemClipboard.getString());
        System.out.println("----------");
        // This is a text
    }

    public void btnSetTextOnAction(ActionEvent actionEvent) {
        Clipboard systemClipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString("This is awesome; I am from DEP");
        systemClipboard.setContent(clipboardContent);
        System.out.println("Clipboard updated");
    }

    public void btnSetFilesOnAction(ActionEvent actionEvent) {
        Clipboard systemClipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        ArrayList<String> filePaths = new ArrayList<>();
        filePaths.add("/home/ranjith-suranga/Pictures/Wallpapers/53e6b233da3242a182d6ca059364e2d9.jpg");
        filePaths.add("/home/ranjith-suranga/Pictures/Wallpapers/AwHEaL.jpg");
        clipboardContent.putFilesByPath(filePaths);
        systemClipboard.setContent(clipboardContent);
        System.out.println("Clipboard updated");
    }

    public void btnReadFilesOnAction(ActionEvent actionEvent) {
        Clipboard systemClipboard = Clipboard.getSystemClipboard();
        System.out.println("Found: " + systemClipboard.getFiles());
        System.out.println("--------");
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        Clipboard.getSystemClipboard().clear();
    }
}
