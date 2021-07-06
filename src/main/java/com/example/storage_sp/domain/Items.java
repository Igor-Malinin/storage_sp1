package com.example.storage_sp.domain;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private int ID;
    private String type;
    private String brandN;
    private String description;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
