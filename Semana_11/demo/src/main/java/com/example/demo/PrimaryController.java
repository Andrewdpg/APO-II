package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Label miLabel;

    @FXML
    private Button button;

    @FXML
    private TextField textFieldE;

    @FXML
    private TextField textFieldP;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        button.setOnAction((evt) -> {
            if (!textFieldP.getText().isEmpty()) {
                System.out.println("logged as: " + textFieldE.getText());
            }
        });
    }
}
