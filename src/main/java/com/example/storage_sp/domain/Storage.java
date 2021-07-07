package com.example.storage_sp.domain;


public class Storage {

    private Box box= new Box(5);;

    public void addItem(int place, String brandN, String description){
        for(int i = 0; i < 1; i++){
            if(box.hasSpace()){
                box.addItem(new Item(place, brandN, description));
                break;
            }
        }
    }
    public Item takeItem(int place){
        for(int i = 0; i < 1; i++){
            if(box.contains(place)){
                Item retItem = box.deleteItem(place);
                return retItem;
            }
        }
        throw new IllegalArgumentException("There is no such Item");
    }

    public Item getItemFS(int place) {
        return box.getItem(place);
    }
}
