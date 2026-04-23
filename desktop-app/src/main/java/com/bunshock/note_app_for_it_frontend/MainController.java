package com.bunshock.note_app_for_it_frontend;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private StackPane contentArea;
    private ViewFactory viewFactory = new ViewFactory();

    @FXML
    private ImageView imgLogo;

    @FXML
    private Label lblWelcome;

    @FXML
    private Label lblUsername;

    @FXML
    private void handleShowGenerator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NoteGeneratorView.fxml"));
            Parent view = loader.load();
            
            // Get the controller of the view we just loaded
            NoteGeneratorController controller = loader.getController();
            // Inject the factory instance
            controller.setViewFactory(this.viewFactory); 
            
            contentArea.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        // Hardcoded for now until implementing AD integration
        lblWelcome.setText("Hola, Leandro!");
        lblUsername.setText("Usuario: leandro.mantovani");

        // On startup, show the note generator view by default
        handleShowGenerator();
    }

}