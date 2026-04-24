package com.bunshock.note_app_for_it_frontend.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EquipmentItem {
    private final StringProperty type;
    private final StringProperty serial;
    private final StringProperty observations;

    public EquipmentItem(String type, String serial, String observations) {
        this.type = new SimpleStringProperty(type);
        this.serial = new SimpleStringProperty(serial);
        this.observations = new SimpleStringProperty(observations);
    }

    public StringProperty typeProperty() { return type; }
    public StringProperty serialProperty() { return serial; }
    public StringProperty observationsProperty() { return observations; }
}
