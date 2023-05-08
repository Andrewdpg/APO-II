package com.andrewpg;


import java.io.IOException;

import com.andrewpg.model.Contact;
import com.andrewpg.model.ContactList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class PrimaryController {


    @FXML
    private Button addContactBtn;

    @FXML
    private TableColumn<Contact, String> lastnameCol;

    @FXML
    private TableColumn<Contact, String> nameCol;

    @FXML
    private TableColumn<Contact, Integer> phoneCol;

    @FXML
    private TableView<Contact> table;

    @FXML
    private AnchorPane root;

    @FXML
    void addContact(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void initialize(){
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        table.setItems(ContactList.getInstance().getContacts());

    }
}
