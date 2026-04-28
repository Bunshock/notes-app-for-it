package com.bunshock.note_app_for_it_frontend.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CountableItem extends EquipmentItem {
    private final IntegerProperty quantity;

    public CountableItem(String type, String brand, String model, int quantity, String observations) {
        super(type, brand, model, observations);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public IntegerProperty getQuantity() { return quantity; }
}
