package com.andrewpg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button convertBtn;

    @FXML
    private ComboBox<?> optionsCB;

    @FXML
    private Button saveBtn;

    @FXML
    private TextArea textTA;

    @FXML
    private TextField valueTF;

    @FXML
    void convert(ActionEvent event) {
        try {
            double result = Double.parseDouble(valueTF.getText()) / 4500;
            textTA.setText(textTA.getText() + result + " DE COP a USD\n");
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Se ha introducido un número inválido");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void save(ActionEvent event) {

    }
}
