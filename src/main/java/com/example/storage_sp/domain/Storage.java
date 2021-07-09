package com.example.storage_sp.domain;


import java.util.ArrayList;

public class Storage {
    private int storageSize = 8;
    private int shelfs = 5;
    private int KPI = 0;
    private ArrayList<Box> box = new ArrayList<Box>(storageSize);

    public Storage(){
        for (int i = 0; i < storageSize; i++)
            box.add(null);
        for(int i = 0; i < storageSize; i++)
        {
            box.set(i, new Box(shelfs));
        }
    }

    public boolean addItem(int place, String type, String brandN, String description){
        for(int i = 0; i < storageSize; i++)
            if(box.get(i).hasSpace() >= 0){
                box.get(i).addItem(new Item(place, type, brandN, description));
                return true;
            }
        throw new IllegalArgumentException("No space, new item does not added");
    }
    public boolean addItem(String type, String brandN, String description) {
        int place[] = new int[storageSize];
        for (int i = 0; i < storageSize; i++) {
            place[i] = box.get(i).hasSpace();
            if (place[i] >= 0) {
                box.get(i).addItem(new Item(i == 0 ? place[i]: place[i] + shelfs * i,
                        type, brandN, description));
                return true;
            }
        }
        throw new IllegalArgumentException("No space, new item does not added");
    }
    public boolean itemIsAdded(int place){
        for(int i = 0; i < storageSize; i++)
            if(box.get(i).itemIsAdded(i))
                return true;
        return false;
    }
    public Item takeItem(int place){
        for(int i = 0; i < storageSize; i++){
            if(box.get(i).contains(place)){
                Item retItem = box.get(i).deleteItem(place);
                return retItem;
            }
        }
        throw new IllegalArgumentException("This place is empty");
    }
    public Item takeItem(String type){
        for(int i = 0; i < storageSize; i++){
            if(box.get(i).contains(type)){
                KPI = i;
                Item retItem = box.get(i).deleteItem(type);
                return retItem;
            }
        }
        throw new IllegalArgumentException("No item with such type");
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

    public int getKPI() {
        return KPI;
    }

    public void setKPI(int KPI) {
        this.KPI = KPI;
    }
}
