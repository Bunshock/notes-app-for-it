package com.bunshock.note_app_for_it_frontend;

import org.controlsfx.control.SearchableComboBox;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UEntregaController {

    @FXML private TextField txtUserDni;
    @FXML private TextField txtUserName;
    @FXML private SearchableComboBox<String> cmbItemType;
    @FXML private TextField txtSerialNumber;
    @FXML private TextArea txtObservations;

    public void initialize() {
        // Mock data for the searchable combo
        cmbItemType.setItems(FXCollections.observableArrayList(
            "Notebook", "Monitor", "Teclado", "Mouse", "Auriculares", "Cargador"
        ));
        
        // Add a listener to DNI to simulate AD lookup later
        txtUserDni.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.length() >= 7) {
                // Future AD Lookup logic here
                txtUserName.setText("Cargando usuario...");
            }
        });
    }
}