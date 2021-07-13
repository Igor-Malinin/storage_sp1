package com.example.storage_sp.domain;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private int capacity = 0;
    private int shelfs;
    private int size;
    private ArrayList<Item> items;

    public Box(int shelfs) {
        this.shelfs = shelfs;
        this.size = shelfs;
        items = new ArrayList<Item>();
        for (int i = 0; i < shelfs; i++)
            items.add(null);
    }

    /*public boolean itemIsAdded(int place){
        for (int i = 0; i < shelfs; i++) {
            if (items.get(i) != null && items.get(i).getPlace() == place)
                return true;
        }
        return false;
    }*/

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getShelfs() {
        return shelfs;
    }

    public void setShelfs(int shelfs) {
        this.shelfs = shelfs;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
//public Item searchForItem()
}
