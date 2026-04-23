package com.bunshock.note_app_for_it_frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private StackPane contentArea;

    @FXML
    private ImageView imgLogo;

    @FXML
    private Label lblWelcome;

    @FXML
    private Label lblUsername;

    @FXML
    private void handleShowGenerator() {
        System.out.println("Cambiando a vista de generación de notas...");
    }

    public void initialize() {
        // Hardcoded for now until implementing AD integration
        lblWelcome.setText("Hola, Leandro!");
        lblUsername.setText("Usuario: leandro.mantovani");
    }

}