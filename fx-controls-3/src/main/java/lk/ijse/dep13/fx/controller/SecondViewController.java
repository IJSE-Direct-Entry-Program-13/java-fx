package lk.ijse.dep13.fx.controller;

import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondViewController {

    public TextField txtInput;
    public Button btnPrint;

    public void initialize() {
        btnPrint.setOnAction(event ->{
            String inputText = txtInput.getText();
            System.out.println(inputText);
            txtInput.clear();
            txtInput.requestFocus();
        });
    }


}
