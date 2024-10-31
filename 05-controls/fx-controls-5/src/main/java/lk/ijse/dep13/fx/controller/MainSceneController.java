package lk.ijse.dep13.fx.controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MainSceneController {
    public MenuItem mnNewDocument;
    public MenuItem mnExit;

    public CheckMenuItem mnCheckMenuItem1;
    public CheckMenuItem mnCheckMenuItem2;
    public CheckMenuItem mnCheckMenuItem3;

    public ToggleGroup tglRadioMenuItem;

    public RadioMenuItem mnRadioMenuItem1;
    public RadioMenuItem mnRadioMenuItem2;
    public RadioMenuItem mnRadioMenuItem3;
    public TextArea txtEditor;
    public ToggleButton tglBold;
    public ToggleButton tglItalic;

    public void initialize(){
        mnCheckMenuItem3.setSelected(true);
        updateStyle();

        tglRadioMenuItem.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        mnCheckMenuItem1.selectedProperty().bindBidirectional(tglBold.selectedProperty());
        mnCheckMenuItem2.selectedProperty().bindBidirectional(tglItalic.selectedProperty());

        ChangeListener subscriber = (observableValue, oldValue, newValue) -> { updateStyle(); };
        tglBold.selectedProperty().addListener(subscriber);
        tglItalic.selectedProperty().addListener(subscriber);
    }

    public void mnNewDocumentOnAction(ActionEvent actionEvent) {
        txtEditor.clear();
    }

    public void mnCheckMenuItem1OnAction(ActionEvent actionEvent) {
        //updateStyle();
    }

    public void mnCheckMenuItem2OnAction(ActionEvent actionEvent) {
        //updateStyle();
    }

    public void mnCheckMenuItem3OnAction(ActionEvent actionEvent) {
        updateStyle();
    }

    private void updateStyle(){
        String style = "-fx-font-weight: %s; -fx-font-style: %s; -fx-font-size: %s;"
                .formatted(
                        mnCheckMenuItem1.isSelected() ? "bold": "normal",
                        mnCheckMenuItem2.isSelected() ? "italic": "normal",
                        mnCheckMenuItem3.isSelected() ? "2em": "1em"
                );
        txtEditor.setStyle(style);
    }

    public void mnExitOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }
}
