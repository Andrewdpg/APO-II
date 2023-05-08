package com.andrewpg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.andrewpg.model.Vault;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SecondaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button changePass;

    @FXML
    private Button closeVault;

    @FXML
    private TextArea textTA;

    @FXML
    void saveVault(ActionEvent event) throws IOException {
        Vault.updateText(textTA.getText());
        Vault.saveVaultConfig();
        App.setRoot("primary");
    }

    @FXML
    void switchToTertiary(ActionEvent event) throws IOException {
        App.setRoot("tertiary");
    }

    @FXML
    void initialize() {
        textTA.setText(Vault.getText());
    }

}
