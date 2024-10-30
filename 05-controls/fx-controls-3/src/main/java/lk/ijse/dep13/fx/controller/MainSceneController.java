package lk.ijse.dep13.fx.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;

public class MainSceneController {
    public Spinner spnrInput;
    public AnchorPane root;
    public Button btnCustomize;
    public Spinner<Integer> spnrPadding;
    public Label lblPreview;
    public ColorPicker clrBackground;
    public ColorPicker clrBorder;
    public ImageView imgPreview;
    public Label lblImagePreview;
    public Button btn2;
    public Button btn1;

    public void btnCustomizeOnAction(ActionEvent actionEvent) {
        ObservableList<Node> children = spnrInput.getChildrenUnmodifiable();
        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            if (child instanceof TextField) {
                child.setStyle("-fx-border-color: black;");
            } else {
                child.setStyle("-fx-background-color: lightblue; -fx-border-color: black");
            }
        }
    }

    public void clrBackgroundOnAction(ActionEvent actionEvent) {
        Color backgroundColor = clrBackground.getValue();
        lblPreview.setBackground(Background.fill(backgroundColor));
    }

    public void clrBorderOnAction(ActionEvent actionEvent) {
        Color borderColor = clrBorder.getValue();
        // lblPreview.setBorder(Border.stroke(borderColor));
        lblPreview.setBorder(new Border(new BorderStroke(borderColor, BorderStrokeStyle.SOLID,
                new CornerRadii(0), new BorderWidths(5, 2, 5, 2))));
    }

    public void initialize(){
        spnrPadding.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        spnrPadding.valueProperty().addListener((observable, oldValue, newValue) -> {
            lblPreview.setPadding(new Insets(0, newValue, 0, newValue));
        });

        ImageView browseIcon = new ImageView(new Image("/icon/search.png", 16,16, true, true));

        MenuItem mnBrowseImage = new MenuItem("Browse Image", browseIcon);
        MenuItem mnClearImage = new MenuItem("Clear Image");
        ContextMenu contextMenu = new ContextMenu(mnBrowseImage, mnClearImage);
        lblImagePreview.setContextMenu(contextMenu);

        mnBrowseImage.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Browse Image");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files",
                    "*.jpeg", "*.jpg", "*.gif", "*.png"));
            File imageFile = fileChooser.showOpenDialog(root.getScene().getWindow());
            if (imageFile == null) return;
            Image image = new Image(imageFile.toURI().toString());
            imgPreview.setImage(image);
        });

        mnClearImage.setOnAction(event -> { imgPreview.setImage(null);});

//        System.out.println(clrBackground.getTooltip());
//        System.out.println(clrBorder.getTooltip());
//        System.out.println(spnrPadding.getTooltip());

        Tooltip tooltip = new Tooltip("Click to change background color");
        tooltip.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");
        clrBackground.setTooltip(tooltip);
        clrBorder.setTooltip(new Tooltip("Click to change border color"));
        spnrPadding.setTooltip(new Tooltip("Click to change the padding"));

//        Mnemonic mnemonic1 = new Mnemonic(btn1, new KeyCodeCombination(KeyCode.B, KeyCombination.ALT_ANY));
//        Mnemonic mnemonic2 = new Mnemonic(btn2, new KeyCodeCombination(KeyCode.C,KeyCombination.ALT_ANY));
//
//        Platform.runLater(()->{
//            root.getScene().addMnemonic(mnemonic1);
//            root.getScene().addMnemonic(mnemonic2);
//        });
    }

    public void btn1OnAction(ActionEvent actionEvent) {
        System.out.println("Button1 Clicked");
    }

    public void btn2OnAction(ActionEvent actionEvent) {
        System.out.println("Button2 Clicked");
    }
}
