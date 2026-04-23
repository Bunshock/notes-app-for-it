package com.bunshock.note_app_for_it_frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ViewFactory {

    private VBox uEntregaView;

    public VBox getUEntregaView() {
        if (uEntregaView == null) {
            try {
                uEntregaView = FXMLLoader.load(getClass().getResource("profiles/UEntrega.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return uEntregaView;
    }
}
