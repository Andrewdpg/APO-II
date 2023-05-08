package com.andrewpg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.andrewpg.model.Vault;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;

public class TertiaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button primaryButton;

    @FXML
    private HBox rowNew;

    @FXML
    private HBox rowOld;

    @FXML
    void savePassword(ActionEvent event) throws IOException {
        Vault.updatePassword(readOldPassword(), readNewPassword());
        App.setRoot("secondary");
    }

    String readOldPassword() {
        String pass = "";
        for (Object field : rowOld.getChildren().toArray()) {
            pass += ((PasswordField) field).getText();
        }
        return pass;
    }

    String readNewPassword() {
        String pass = "";
        for (Object field : rowNew.getChildren().toArray()) {
            pass += ((PasswordField) field).getText();
        }
        return pass;
    }

    @FXML
    void initialize() {
        initRowOldFields();
        initRowNewFields();
    }

    void initRowOldFields() {
        Object[] fields = rowOld.getChildren().toArray();
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
                    else
                        rowOld.requestFocus();
                } else if (previous != null)
                    previous.requestFocus();
            });
        }
    }
    void initRowNewFields() {
        Object[] fields = rowNew.getChildren().toArray();
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
                    else
                        rowNew.requestFocus();
                } else if (previous != null)
                    previous.requestFocus();
            });
        }
    }
}
