package com.andrewpg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.andrewpg.exception.EmptyFieldException;
import com.andrewpg.model.Balance;
import com.andrewpg.model.Register;
import com.andrewpg.model.RegisterType;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Register, Double> ammountTC;

    @FXML
    private TextField ammountTF;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<Register, LocalDate> dateTC;

    @FXML
    private TableColumn<Register, String> descriptionTC;

    @FXML
    private TextField descriptionTF;

    @FXML
    private ComboBox<RegisterType> typeCB;

    @FXML
    private TableColumn<Register, RegisterType> typeTC;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableView<Register> table;

    @FXML
    private CheckBox expensesCheck;

    @FXML
    private CheckBox incomeCheck;

    @FXML
    private Label balanceLBL;

    private ArrayList<RegisterType> selected;

    @FXML
    void changeExpenseState(ActionEvent event) {
        if (expensesCheck.isSelected())
            selected.remove(RegisterType.GASTO);
        else
            selected.add(RegisterType.GASTO);
        table.setItems(getFiltered());
    }

    @FXML
    void changeIncomeState(ActionEvent event) {
        if (incomeCheck.isSelected())
            selected.remove(RegisterType.INGRESO);
        else
            selected.add(RegisterType.INGRESO);
        table.setItems(getFiltered());
    }

    @FXML
    void addRegister(ActionEvent event) {
        try {
            if (validateData()) {
                Double ammount = (typeCB.getSelectionModel().getSelectedItem() == RegisterType.GASTO ? -1 : 1)
                        * Math.abs(Double.parseDouble(ammountTF.getText()));
                Balance.getInstance().getList().add(
                        new Register(descriptionTF.getText(),
                                ammount,
                                typeCB.getSelectionModel().getSelectedItem(),
                                datePicker.getValue()));
                table.setItems(getFiltered());
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Los valores númericos son inválidos");
            alert.showAndWait();
        } catch (EmptyFieldException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Revisa las entradas");
            alert.showAndWait();
        }
    }

    @FXML
    void deleteSelected(ActionEvent event) {
        if (table.getSelectionModel().getSelectedItem() != null) {
            Balance.getInstance().getList().remove(table.getSelectionModel().getSelectedItem());
            table.setItems(getFiltered());
        }
    }

    private boolean validateData() throws EmptyFieldException {
        if (descriptionTF.getText().isEmpty() || ammountTC.getText().isEmpty()
                || typeCB.getSelectionModel().getSelectedItem() == null
                || datePicker.getValue() == null) {
            throw new EmptyFieldException("Hay campos vaciós");
        }

        return true;
    }

    @FXML
    void initialize() {
        selected = new ArrayList<>();
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        ammountTC.setCellValueFactory(new PropertyValueFactory<>("ammount"));
        descriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        typeCB.setItems(RegisterType.getItems());
        table.setItems(getFiltered());
    }

    public ObservableList<Register> getFiltered() {
        ObservableList<Register> list = Balance.getInstance().filterBy(selected.toArray(new RegisterType[] {}));
        setBalance(list);
        return list;
    }

    public void setBalance(ObservableList<Register> list) {
        double value = 0.0;
        for (Register register : list) {
            value += register.getAmmount();
        }
        balanceLBL.setText(String.valueOf(value));
    }
}
