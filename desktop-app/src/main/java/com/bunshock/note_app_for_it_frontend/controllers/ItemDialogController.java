package com.bunshock.note_app_for_it_frontend.controllers;

import org.controlsfx.control.SearchableComboBox;

import com.bunshock.note_app_for_it_frontend.models.AssetItem;
import com.bunshock.note_app_for_it_frontend.models.CountableItem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ItemDialogController {
    // Common fields
    @FXML private SearchableComboBox<String> cmbType;
    @FXML private TextField txtBrand, txtModel, txtObs;
    
    // Toggle for Mode
    @FXML private ToggleButton btnModeAsset, btnModeCountable;
    
    // Mode-specific containers
    @FXML private VBox containerAssetFields; // Wraps SN and AF fields
    @FXML private VBox containerCountableFields; // Wraps Quantity field
    @FXML private Spinner<Integer> spinQty;
    @FXML private TextField txtSerial, txtAF;

    @FXML private Button btnAdd;

    private UserNoteController parentController;

    public void setParentController(UserNoteController parent) {
        this.parentController = parent;
    }

    @FXML
    private void handleModeChange() {
        boolean isAsset = btnModeAsset.isSelected();
        
        // Toggle Assets
        containerAssetFields.setVisible(isAsset);
        containerAssetFields.setManaged(isAsset);
        
        // Toggle Countables
        containerCountableFields.setVisible(!isAsset);
        containerCountableFields.setManaged(!isAsset);
        
        // Auto-resize the window to fit the new content
        btnAdd.getScene().getWindow().sizeToScene();
    }

    @FXML
    private void onSave() {
        if (btnModeAsset.isSelected()) {
            parentController.addAsset(new AssetItem(
                cmbType.getValue(), txtBrand.getText(), txtModel.getText(),
                txtSerial.getText(), txtAF.getText(), txtObs.getText()
            ));
        } else {
            parentController.addCountable(new CountableItem(
                cmbType.getValue(), txtBrand.getText(), txtModel.getText(),
                spinQty.getValue(), txtObs.getText()
            ));
        }
        ((Stage) btnAdd.getScene().getWindow()).close();
    }

    @FXML
    private void onCancel() {
        ((Stage) btnAdd.getScene().getWindow()).close();
    }
}