package com.bunshock.note_app_for_it_frontend.controllers;

import org.controlsfx.control.SearchableComboBox;

import com.bunshock.note_app_for_it_frontend.models.EquipmentItem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ItemDialogController {
    
    @FXML private SearchableComboBox<String> cmbType;
    @FXML private TextField txtSerial;
    @FXML private TextArea txtObs;
    @FXML private Button btnAdd;

    private ObservableList<EquipmentItem> equipmentList;

    public void setEquipmentList(ObservableList<EquipmentItem> list) {
        this.equipmentList = list;
    }

    public void initialize() {
        cmbType.setItems(FXCollections.observableArrayList("Notebook", "Monitor", "Teclado", "Mouse"));
    }

    @FXML
    private void onAddClick() {
        if (cmbType.getValue() != null && !txtSerial.getText().isEmpty()) {
            equipmentList.add(new EquipmentItem(
                cmbType.getValue(), 
                txtSerial.getText(), 
                txtObs.getText()
            ));
            // Close the window
            ((Stage) btnAdd.getScene().getWindow()).close();
        }
    }

    @FXML
    private void onCancelClick() {
        // Close the window without adding
        ((Stage) btnAdd.getScene().getWindow()).close();
    }
}
