package com.example.storage_sp.applications;

import com.example.storage_sp.domain.Box;
import com.example.storage_sp.domain.Item;

import java.util.HashMap;

public class BoxLogic {
    private int shelfs;
    private int capacity = 0;
    private Box box;
    private StorStatus storStatus;


    public BoxLogic(int shelfs){
        this.shelfs = shelfs;
        box = new Box(shelfs);
        storStatus = new StorStatus();
    }

    public int hasSpace(){
        if (box.getCapacity() != box.getSize())
            for(int i = 0; i < shelfs; i++)
                if(box.getItems().get(i) == null)
                    return i;
        return -1;
    }
    public boolean contains(int place){
        for (int i = 0; i < shelfs; i++) {
            if (box.getItems().size() > 0)
                if (box.getItems().get(i) != null && box.getItems().get(i).getPlace() == place)
                    return true;
        }
        return false;
    }
    public boolean contains(String type){
        for (int i = 0; i < shelfs; i++) {
            if (box.getItems().size() > 0)
                if (box.getItems().get(i) != null && box.getItems().get(i).getType() == type)
                    return true;
        }
        return false;
    }
    public void addItem(Item item){
        if (box.getCapacity() == box.getSize())
            throw new IllegalArgumentException("No space, new Item does not added");
        //mainLoop:
        for (int i = 0; i < shelfs; i++) {
            if (box.getItems().get(i) == null) {
                box.getItems().set(i, item);
                box.setCapacity(++capacity);
                storStatus.updateStorageStatus(box.getItems().get(i).getPlace(), item);
                break;
            }
        }
    }

    public Item deleteItem(int place){
        for (int i = 0; i < shelfs; i++) {
            if (box.getItems().get(i) != null && box.getItems().get(i).getPlace() == place) {
                Item retItem = box.getItems().get(i);
                storStatus.updateStorageStatus(box.getItems().get(i).getPlace(), null);
                box.getItems().set(i, null);
                box.setCapacity(--capacity);
                return retItem;
            }

        }
        throw new IllegalArgumentException("This place is empty.");
    }
    public Item deleteItem(String type){
        for (int i = 0; i < shelfs; i++) {
            if (box.getItems().get(i) != null && box.getItems().get(i).getType() == type) {
                Item retItem = box.getItems().get(i);
                storStatus.updateStorageStatus(box.getItems().get(i).getPlace(), null);
                box.getItems().set(i, null);
                box.setCapacity(--capacity);
                return retItem;
            }

        }
        throw new IllegalArgumentException("We do not have items with this type in the storage.");
    }
    public boolean itemIsAdded(int place) {
        for (int i = 0; i < shelfs; i++) {
            if (box.getItems().get(i) != null && box.getItems().get(i).getPlace() == place)
                return true;
        }
        return false;
    }
    public Item getItem(int place){
        for (int i = 0; i < shelfs; i++) {
            if (box.getItems().get(i) != null && box.getItems().get(i).getPlace() == place) {
                return box.getItems().get(i);
            }
        }
        return null;
    }

}
