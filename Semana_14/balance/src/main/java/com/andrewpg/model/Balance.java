package com.andrewpg.model;

import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Balance {

    private ObservableList<Register> balance = FXCollections.observableArrayList();

    private Balance() {
    }

    private static Balance instance = null;

    public static Balance getInstance() {
        if (instance == null)
            instance = new Balance();
        return instance;
    }

    public ObservableList<Register> getList() {
        balance.sort((a, b) -> {
            return b.getDate().compareTo(a.getDate());
        });
        return balance;
    }

    public ObservableList<Register> filterBy(RegisterType... types) {
        balance.sort((a,b)->{
            return b.getDate().compareTo(a.getDate());
        });
        ObservableList<Register> filtered = balance;
        for (RegisterType type : types) {
            Predicate<Register> filter = item -> item.getType().equals(type);
            filtered = filtered.filtered(filter);
        }
        return filtered;
    }
}
