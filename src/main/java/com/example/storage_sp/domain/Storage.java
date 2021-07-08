package com.example.storage_sp.domain;


import java.util.ArrayList;

public class Storage {
    private int storageSize = 2;
    private ArrayList<Box> box = new ArrayList<Box>(storageSize);

    public Storage(){
        for (int i = 0; i < storageSize; i++)
            box.add(null);
        for(int i = 0; i < storageSize; i++)
        {
            box.set(i, new Box(5));
        }

    }

    public boolean addItem(int place, String brandN, String description){
        for(int i = 0; i < storageSize; i++){
            if(box.get(i).hasSpace()){
                box.get(i).addItem(new Item(place, brandN, description));
                return true;
            }
        }
        throw new IllegalArgumentException("No space, new item does not added");
    }
    public Item takeItem(int place){
        for(int i = 0; i < storageSize; i++){
            if(box.get(i).contains(place)){
                Item retItem = box.get(i).deleteItem(place);
                return retItem;
            }
        }
        throw new IllegalArgumentException("No such item");
    }

    public Item getItemFS(int place) {
        Item retItem;
        for (int i = 0; i < storageSize; i++) {
            retItem = box.get(i).getItem(place);
            if (retItem != null)
                return retItem;
        }
        throw new IllegalArgumentException("No such item");
    }

}
