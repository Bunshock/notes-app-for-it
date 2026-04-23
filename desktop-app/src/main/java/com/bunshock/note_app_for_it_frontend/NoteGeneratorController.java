package com.bunshock.note_app_for_it_frontend;

import org.controlsfx.control.SearchableComboBox;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class NoteGeneratorController {

    @FXML
    private SearchableComboBox<String> profileSelector;
    
    @FXML
    private StackPane dynamicContentArea;
    
    private ViewFactory viewFactory;

    public void setViewFactory(ViewFactory viewFactory) {
        this.viewFactory = viewFactory;
        // Default profile selection
        profileSelector.setValue("Usuario - Entrega");
    }

    public void initialize() {
        // Populate the profiles
        profileSelector.setItems(FXCollections.observableArrayList(
            "Usuario - Entrega",
            "Usuario - Devolución",
            "Usuario - Préstamo",
            "Usuario - Fin de contrato (Entrega)",
            "Proveedor - Entrega"
        ));

        // Listen for changes
        profileSelector.valueProperty().addListener((obs, oldVal, newVal) -> {
            updateFormProfile(newVal);
        });
    }

    private void updateFormProfile(String profileName) {
        if (profileName == null) return;

        // Swapping logic
        // TODO: Make this scalable by using a Map<String, Node> to store preloaded views instead of hardcoding cases
        switch (profileName) {
            case "Usuario - Entrega":
                dynamicContentArea.getChildren().setAll(viewFactory.getUEntregaView());
                break;
            case "Usuario - Devolución":
                // dynamicContentArea.getChildren().setAll(viewFactory.getUDevolucionView());
                break;
            case "Usuario - Préstamo":
                // dynamicContentArea.getChildren().setAll(viewFactory.getUPrestamoView());
                break;
            case "Usuario - Fin de contrato (Entrega)":
                // dynamicContentArea.getChildren().setAll(viewFactory.getUFinContratoEntregaView());
                break;
            case "Proveedor - Entrega":
                // dynamicContentArea.getChildren().setAll(viewFactory.getPEntregaView());
                break;
            default:
                System.out.println("Perfil no implementado aún.");
        }
    }
}