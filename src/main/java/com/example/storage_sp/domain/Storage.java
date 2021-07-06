package com.example.storage_sp.domain;


public class Storage {

    private Shelf[] shelf;

    {
        shelf = new Shelf[4];
        for(int i = 0; i < 4; i++)
        {
            shelf[i] = new Shelf(10,10);
        }
    }

    public void addItem(String type, String brandN, String description){
        for(int i = 0; i < 4; i++){
            if(shelf[i].hasSpace()){
                shelf[i].addItem(new Item(type, brandN, description));
                break;
            }
        }
    }
    public void takeItem(int ID){
        for(int i = 0; i < 4; i++){
            if(shelf[i].contains(ID)){
                shelf[i].deleteItem(ID);
                break;
            }
        }
        throw new IllegalArgumentException("There is no such Item");
    }
}
