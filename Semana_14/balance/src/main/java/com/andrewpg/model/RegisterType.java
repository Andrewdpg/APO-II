package com.andrewpg.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public enum RegisterType {
    GASTO, INGRESO;

    private static ObservableList<RegisterType> items;

    public static ObservableList<RegisterType> getItems() {
        if (items == null) {
            items = FXCollections.observableArrayList();
            items.addAll(RegisterType.values());
        }
        return items;
    }
}
