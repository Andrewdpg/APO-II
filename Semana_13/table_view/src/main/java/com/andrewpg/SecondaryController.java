package com.andrewpg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.andrewpg.model.Contact;
import com.andrewpg.model.ContactList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SecondaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button newContact;

    @FXML
    private Button secondaryButton;

    @FXML
    void addContact(ActionEvent event) {
        Contact contact = new Contact("Alfa", "Beta", 123456);
        ContactList.getInstance().getContacts().add(contact);
    }

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void initialize() {
    }

}