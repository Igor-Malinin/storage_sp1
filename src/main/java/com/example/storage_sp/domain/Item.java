package com.example.storage_sp.domain;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private static int counter = 0;
    private int ID;
    private String brandN;
    private String description;

    public Item(String brandN, String description) {
        this.ID = counter++;
        this.brandN = brandN;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public String getBrandN() {
        return brandN;
    }

    public void setBrandN(String brandN) {
        this.brandN = brandN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
