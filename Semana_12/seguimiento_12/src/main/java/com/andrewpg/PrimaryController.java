package com.andrewpg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.andrewpg.exception.WrongPasswordException;
import com.andrewpg.model.Vault;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button primaryButton;

    @FXML
    private HBox row;

    @FXML
    void openVault(ActionEvent event) throws IOException {
        try {
            Vault.checkPassword(readPassword());
            App.setRoot("secondary");
        } catch (WrongPasswordException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.contentTextProperty().set(e.getMessage());
            alert.showAndWait();
        }
    }

    String readPassword() {
        String pass = "";
        for (Object field : row.getChildren().toArray()) {
            pass += ((PasswordField) field).getText();
        }
        return pass;
    }

    @FXML
    void initialize() throws IOException {
        Vault.initVault();
        initRowFields();
    }

    void initRowFields(){
        Object[] fields = row.getChildren().toArray();
        for (int i = 0; i < fields.length; i++) {
            PasswordField current = ((PasswordField) fields[i]);
            PasswordField next = i < fields.length - 1 ? (PasswordField) fields[i + 1] : null;
            PasswordField previous = i > 0 ? (PasswordField) fields[i - 1] : null;
            current.textProperty().addListener((observable, oldT, newT) -> {
                if (newT.length() > 1)
                    current.setText(newT = oldT);
                if (newT.length() == 1) {
                    if (next != null)
                        next.requestFocus();
                    else{
                        row.requestFocus();
                        try {
                            openVault(null);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (previous != null)
                    previous.requestFocus();
            });
        }
    }
}
