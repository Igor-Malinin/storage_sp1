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

    public int hasSpace(){
        if (capacity != size)
            for(int i = 0; i < shelfs; i++)
                if(items.get(i) == null)
                    return i;
        return -1;
    }
    public boolean contains(int place){
        for (int i = 0; i < shelfs; i++) {
            if (items.size() > 0)
                if (items.get(i) != null && items.get(i).getPlace() == place)
                    return true;
        }
        return false;
    }
    public boolean contains(String type){
        for (int i = 0; i < shelfs; i++) {
            if (items.size() > 0)
                if (items.get(i) != null && items.get(i).getType() == type)
                    return true;
        }
        return false;
    }
    public void addItem(Item item){
        if (capacity == size)
            throw new IllegalArgumentException("No space, new Item does not added");
        //mainLoop:
        for (int i = 0; i < shelfs; i++) {
            if (items.get(i) == null) {
                items.set(i, item);
                capacity++;
                break;
            }
        }
    }
    public boolean itemIsAdded(int place){
        for (int i = 0; i < shelfs; i++) {
            if (items.get(i) != null && items.get(i).getPlace() == place)
                return true;
        }
        return false;
    }
    public Item deleteItem(int place){
        for (int i = 0; i < shelfs; i++) {
            if (items.get(i) != null && items.get(i).getPlace() == place) {
                Item retItem = items.get(i);
                items.set(i, null);
                capacity--;
                //System.out.println(retItem.getBrandN() + " " + retItem.getDescription());
                return retItem;
            }

        }
        throw new IllegalArgumentException("This place is empty.");
    }
    public Item deleteItem(String type){
        for (int i = 0; i < shelfs; i++) {
            if (items.get(i) != null && items.get(i).getType() == type) {
                Item retItem = items.get(i);
                items.set(i, null);
                capacity--;
                //System.out.println(retItem.getBrandN() + " " + retItem.getDescription());
                return retItem;
            }

        }
        throw new IllegalArgumentException("We do not have items with this type in the storage.");
    }
    public Item getItem(int place){
        for (int i = 0; i < shelfs; i++) {
            if (items.get(i) != null && items.get(i).getPlace() == place) {
                return items.get(i);
            }
        }
        return null;
    }

    //public Item searchForItem()
}
