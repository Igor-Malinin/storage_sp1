package com.example.storage_sp.applications;

import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.Storage;

import java.util.ArrayList;

public class StorageLogic {
    private int boxes;
    private int iterations = 0;
    private Storage storage;

    public StorageLogic(int boxes){
        this.boxes = boxes;
        storage = new Storage(boxes);
    }
    public boolean addItem(int place, String type, String brandN, String description){
        for(int i = 0; i < boxes; i++)
            if(storage.getBoxLogic().get(i).hasSpace() >= 0){
                storage.getBoxLogic().get(i).addItem(new Item(place, type, brandN, description));
                return true;
            }
        throw new IllegalArgumentException("No space, new item does not added");
    }
    public boolean addItem(String type, String brandN, String description) {
        int place[] = new int[boxes];
        for (int i = 0; i < boxes; i++) {
            place[i] = storage.getBoxLogic().get(i).hasSpace();
            if (place[i] >= 0) {
                storage.getBoxLogic().get(i).addItem(new Item(i == 0 ? place[i]: place[i] + storage.getShelfs() * i,
                        type, brandN, description));
                return true;
            }
        }
        throw new IllegalArgumentException("No space, new item does not added");
    }
    public Item takeItem(int place){
        for(int i = 0; i < boxes; i++){
            if(storage.getBoxLogic().get(i).contains(place)){
                Item retItem = storage.getBoxLogic().get(i).deleteItem(place);
                return retItem;
            }
        }
        throw new IllegalArgumentException("This place is empty");
    }
    public Item takeItem(String type){
        for(int i = 0; i < boxes; i++){
            if(storage.getBoxLogic().get(i).contains(type)){
                iterations += i + 1;
                Item retItem = storage.getBoxLogic().get(i).deleteItem(type);
                return retItem;
            }
        }
        throw new IllegalArgumentException("No item with such type");
    }
    public Item getItemFS(int place) {
        Item retItem;
        for (int i = 0; i < boxes; i++) {
            retItem = storage.getBoxLogic().get(i).getItem(place);
            if (retItem != null)
                return retItem;
        }
        throw new IllegalArgumentException("No such item");
    }
    public int getShelfs(){
        return storage.getShelfs();
    }
    public int getIterations(){
        return iterations;
    }
}
