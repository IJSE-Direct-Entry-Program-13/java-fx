package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class ChooserSceneController {

    public Button btnOpenDirectoryDialog;
    public Button btnOpenFileDialog;
    public Button btnSaveFileDialog;
    public AnchorPane root;

    public void btnSaveFileDialogOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save/Export File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plain Text File", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File", "*.pdf"));
        fileChooser.setInitialDirectory(new File("/opt"));
        fileChooser.setInitialFileName("hello.txt");
        File file = fileChooser.showSaveDialog(root.getScene().getWindow());
        System.out.println(file);
        //fileChooser.showSaveDialog(null);
    }

    public void btnOpenFileDialogOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg", "*.jpg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        //File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        //System.out.println(file);
        List<File> files = fileChooser.showOpenMultipleDialog(root.getScene().getWindow());
        System.out.println(files);
    }

    public void btnOpenDirectoryDialogOnAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Directory");
        directoryChooser.setInitialDirectory(new File("/opt"));
        File file = directoryChooser.showDialog(root.getScene().getWindow());
        System.out.println(file);
    }

}
