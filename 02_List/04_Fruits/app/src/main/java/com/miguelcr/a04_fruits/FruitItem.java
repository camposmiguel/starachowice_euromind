package com.miguelcr.a04_fruits;

/**
 * Created by miguelcampos on 30/8/16.
 */
public class FruitItem {
    int icon;
    String name;
    int quantity;

    public FruitItem(int icon, String name, int quantity) {
        this.icon = icon;
        this.name = name;
        this.quantity = quantity;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
