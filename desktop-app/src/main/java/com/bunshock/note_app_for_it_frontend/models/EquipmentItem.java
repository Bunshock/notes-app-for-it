package com.bunshock.note_app_for_it_frontend.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EquipmentItem {
    private final StringProperty type;
    private final StringProperty brand;
    private final StringProperty model;
    private final StringProperty observations;

    public EquipmentItem(String type, String brand, String model, String observations) {
        this.type = new SimpleStringProperty(type);
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.observations = new SimpleStringProperty(observations);
    }

    public StringProperty getType() { return type; }
    public StringProperty getBrand() { return brand; }
    public StringProperty getModel() { return model; }
    public StringProperty getObservations() { return observations; }
}
