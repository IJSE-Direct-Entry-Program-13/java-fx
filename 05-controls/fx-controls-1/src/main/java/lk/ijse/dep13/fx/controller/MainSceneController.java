package lk.ijse.dep13.fx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.MalformedURLException;

public class MainSceneController {
    public Label lblHorizontal;
    public Label lblVertical;
    public Slider sldrHorizontal;
    public Slider sldrVertical;
    public AnchorPane root;
    public TextField txtInput;
    public Spinner spnrInput;
    public MediaView mdPreview;
    public Button btnOpen;

    public void initialize() throws MalformedURLException {

//        Media media = new Media("file:/home/ranjith-suranga/Desktop/videoplayback.mp4");
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mdPreview.setMediaPlayer(mediaPlayer);
//        mediaPlayer.play();

//        ChangeListener observer1 = (observableValue, previous, current) -> {
//            System.out.println(observableValue);
//            System.out.println(previous);
//            System.out.println(current);
//        };
//        ChangeListener observer2 = (observableValue, previous, current) -> {
//            lblHorizontal.setText(current.toString());
//        };
//        ChangeListener observer3 = (observableValue, previous, current) -> {
//            System.out.println("Observer 3 got notified");
//        };
//        ChangeListener observer4 = (observableValue, previous, current) -> {
//            System.out.println("prev=%s, current=%s".formatted(previous, current));
//        };
//
//        //txtInput.textProperty().addListener(observer4);
        txtInput.textProperty().addListener((observableValue, previous, current) -> {
            System.out.printf("prev=%s, current=%s %n", previous, current);
        });
//        sldrHorizontal.valueProperty().addListener(observer1);
//        sldrHorizontal.valueProperty().addListener(observer2);
//        sldrHorizontal.valueProperty().addListener(observer3);

        sldrHorizontal.valueProperty().addListener((observableRef, previous, current) -> {
            lblHorizontal.setText("%.2f".formatted(current.doubleValue()));
        });

        sldrVertical.valueProperty().addListener((observableRef, previous, current) -> {
            lblVertical.setText("%.2f".formatted(current.doubleValue()));
        });


        //spnrInput.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,5,2));
        spnrInput.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 5, 5));


//        sldrHorizontal.valueProperty().addListener((observableValue, oldValue, newValue) -> {
//            spnrInput.getValueFactory().setValue(newValue.doubleValue());
//        });
//
//        spnrInput.valueProperty().addListener((observableValue, oldValue, newValue) -> {
//            sldrHorizontal.setValue((double) newValue);
//        });

        //sldrHorizontal.valueProperty().bind(spnrInput.valueProperty());
        sldrHorizontal.valueProperty().bindBidirectional(sldrVertical.valueProperty());
    }

    public void btnOpenOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open video file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("mp4 files", "*.mp4"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("avi files", "*.avi"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("mkv files", "*.mkv"));
        File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (file != null) {
            Media media = new Media(file.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mdPreview.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }
    }

}

