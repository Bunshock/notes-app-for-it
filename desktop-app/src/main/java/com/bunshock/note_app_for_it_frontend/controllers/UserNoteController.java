package com.bunshock.note_app_for_it_frontend.controllers;

import java.io.IOException;

import com.bunshock.note_app_for_it_frontend.models.EquipmentItem;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserNoteController {

    // Note type selection
    @FXML private ToggleGroup typeGroup;
    @FXML private ToggleButton btnTypeEntrega;
    @FXML private ToggleButton btnTypeDevolucion;
    @FXML private ToggleButton btnTypePrestamo;
    @FXML private ToggleButton btnTypeFinContrato;

    // User info fields
    @FXML private TextField txtUserDni;
    @FXML private TextField txtUserName;

    // Equipment table
    @FXML private TableView<EquipmentItem> tblEquipment;
    @FXML private TableColumn<EquipmentItem, String> colType;
    @FXML private TableColumn<EquipmentItem, String> colSerial;
    @FXML private TableColumn<EquipmentItem, String> colObs;
    @FXML private TableColumn<EquipmentItem, Void> colActions;
    
    // Observations
    @FXML
    private TextArea txtObservations;

    public void initialize() {
        // Setup note type toggle group
        typeGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                ToggleButton selectedBtn = (ToggleButton) newToggle;
                String selectedType = selectedBtn.getText();
            }
        });

        btnTypeEntrega.setSelected(true);

        // Setup table columns
        colType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        colSerial.setCellValueFactory(cellData -> cellData.getValue().serialProperty());
        colObs.setCellValueFactory(cellData -> cellData.getValue().observationsProperty());

        // Initialize empty table
        tblEquipment.setItems(FXCollections.observableArrayList());
        
        // Add a listener to DNI to simulate AD lookup later
        txtUserDni.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.length() >= 7) {
                // Future AD Lookup logic here
                txtUserName.setText("Cargando usuario...");
            }
            else {
                txtUserName.clear();
            }
        });
    }

    private void handleNoteTypeChange(String type) {
        System.out.println("Cambiando lógica para perfil: " + type);
    }

    @FXML
    private void handleAddItem() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/bunshock/note_app_for_it_frontend/views/ItemDialogView.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Blocks main window
            stage.setTitle("Agregar Equipamiento");
            stage.setScene(new Scene(root));
            
            // Pass the list to the dialog controller so it can add the item back
            ItemDialogController controller = loader.getController();
            controller.setEquipmentList(tblEquipment.getItems());
            
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRemoveItem() {
        EquipmentItem selected = tblEquipment.getSelectionModel().getSelectedItem();
        if (selected != null) {
            tblEquipment.getItems().remove(selected);
        }
    }

}