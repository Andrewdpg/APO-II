package com.andrewpg.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactList {

    // Globales
    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    private ContactList() {
    }

    private static ContactList instance = null;

    public ObservableList<Contact> getContacts() {return contacts;}

    public static ContactList getInstance() {
        if (instance == null) instance = new ContactList();
        return instance;
    }
}
