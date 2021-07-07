package com.example.storage_sp.domain;

import java.util.List;

public class Box {
    private int capacity = 0;
    private int shelfs;
    private int places;
    private int place;
    private int size;
    private Item[] items;
    private Item singleItem;


    public Box(int shelfs) {
        this.shelfs = shelfs;
        this.size = shelfs;
        items = new Item[shelfs];
    }

    public boolean hasSpace(){
        return capacity != size;
    }
    public boolean contains(int place){
        for (int i = 0; i < shelfs; i++) {
            if (items[i] != null && items[i].getPlace() == place) {
                return true;
            }

        }
        return false;
    }
    public void addItem(Item item){
        if (capacity == size)
            throw new IllegalArgumentException("New Item does not added");
        //mainLoop:
        for (int i = 0; i < shelfs; i++) {
            if (items[i] == null && i == item.getPlace()) {
                items[i] = item;
                capacity++;
                break;
            }
        }
    }
    public Item deleteItem(int place){
        for (int i = 0; i < shelfs; i++) {
            if (items[i] != null && items[i].getPlace() == place) {
                Item retItem = items[i];
                items[i] = null;
                capacity--;
                System.out.println(retItem.getBrandN() + " " + retItem.getDescription());
                return retItem;
            }

        }
        throw new IllegalArgumentException("Item with this ID does not exist.");
    }
    public Item getItem(int place){
        for (int i = 0; i < shelfs; i++) {
            if (items[i] != null && items[i].getPlace() == place) {
                return items[i];
            }
        }
        throw new IllegalArgumentException("No such element");
    }
}
