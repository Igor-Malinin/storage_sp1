package com.example.storage_sp.domain;


public class Storage {
    private int storageSize = 2;
    private Box[] box = new Box[storageSize];

    {

        for(int i = 0; i < storageSize; i++)
        {
            box[i] = new Box(5);
        }

    }

    public boolean addItem(String brandN, String description){
        for(int i = 0; i < storageSize; i++){
            if(box[i].hasSpace()){
                box[i].addItem(new Item(brandN, description));
                return true;
            }
        }
        throw new IllegalArgumentException("No space, new item does not added");
    }
    public Item takeItem(int ID){
        for(int i = 0; i < storageSize; i++){
            if(box[i].contains(ID)){
                Item retItem = box[i].deleteItem(ID);
                return retItem;
            }
        }
        throw new IllegalArgumentException("No such item");
    }

    public Item getItemFS(int ID) {
        Item retItem;
        for (int i = 0; i < storageSize; i++) {
            retItem = box[i].getItem(ID);
            if (retItem != null)
                return retItem;
        }
        throw new IllegalArgumentException("No such item");
    }

}
