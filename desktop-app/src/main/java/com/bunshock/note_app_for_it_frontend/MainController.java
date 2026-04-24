package com.bunshock.note_app_for_it_frontend;

import java.io.IOException;

import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MainController {

    // UI components
    @FXML
    private ImageView imgLogo;

    // User info labels
    @FXML
    private Label lblWelcome;
    @FXML
    private Label lblUsername;

    // Server status indicators
    @FXML
    private Circle circleAD, circleGLPI;
    @FXML private
    Tooltip tooltipAD, tooltipGLPI;

    // Main content area where views will be swapped
    @FXML
    private StackPane contentArea;
    private ViewFactory viewFactory = new ViewFactory();

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

    // TODO: Add server configuration and management UI in the future, but for now we'll hardcode the checks in the status monitor
    private void startStatusMonitor() {
        ScheduledService<Void> statusService = new ScheduledService<>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<>() {
                    @Override
                    protected Void call() {
                        // Ping checks
                        // boolean adUp = pingServer(<AD_SERVER>); 
                        boolean adUp = true; // Mocking: AD is up
                        boolean adHasPerms = false; // Mocking: No permissions

                        // boolean glpiUp = pingServer(<GLPI_API>);
                        boolean glpiUp = false; // Mocking: GLPI is down
                        
                        // Update UI
                        Platform.runLater(() -> {
                            updateADStatus(adUp, adHasPerms);
                            updateGLPIStatus(glpiUp);
                        });
                        return null;
                    }
                };
            }
        };
        // Refresh every 60 seconds
        statusService.setPeriod(Duration.seconds(60));
        statusService.start();
    }

    private void updateADStatus(boolean online, boolean hasPerms) {
        if (!online) {
            circleAD.setFill(Color.RED);
            tooltipAD.setText("Estado: Desconectado");
        } else if (!hasPerms) {
            circleAD.setFill(Color.ORANGE);
            tooltipAD.setText("Estado: En línea - Sin permisos de lectura");
        } else {
            circleAD.setFill(Color.GREEN);
            tooltipAD.setText("Estado: En línea - Con permisos de lectura");
        }
    }

    private void updateGLPIStatus(boolean online) {
        circleGLPI.setFill(online ? Color.GREEN : Color.RED);
        tooltipGLPI.setText(online ? "Estado: En línea" : "Estado: Desconectado");
    }

    public void initialize() {
        // Start the status monitor for AD and GLPI
        startStatusMonitor();
        
        // Welcome info: Hardcoded for now until implementing AD integration
        lblWelcome.setText("Hola, Leandro!");
        lblUsername.setText("Usuario: leandro.mantovani");

        // On startup, show the note generator view by default
        handleShowGenerator();
    }

}