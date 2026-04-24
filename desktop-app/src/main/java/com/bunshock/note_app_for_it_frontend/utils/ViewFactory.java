package com.bunshock.note_app_for_it_frontend.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ViewFactory {

    private VBox userNoteView;
    private VBox providerNoteView;

    public VBox getUserNoteView() {
        if (userNoteView == null) {
            try {
                userNoteView = FXMLLoader.load(getClass().getResource("/com/bunshock/note_app_for_it_frontend/views/UserNoteView.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userNoteView;
    }

    public VBox getProviderNoteView() {
        if (providerNoteView == null) {
            try {
                providerNoteView = FXMLLoader.load(getClass().getResource("/com/bunshock/note_app_for_it_frontend/views/ProviderNoteView.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return providerNoteView;
    }

}
