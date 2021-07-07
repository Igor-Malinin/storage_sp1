package com.example.storage_sp.domain;


public class Storage {

    private Box box;

    {
        box = new Box(5);
        /*
        for(int i = 0; i < 1; i++)
        {
            box[i] = new Box(5);
        }
         */
    }

    public void addItem(String brandN, String description){
        for(int i = 0; i < 1; i++){
            if(box.hasSpace()){
                box.addItem(new Item(brandN, description));
                break;
            }
        }
    }
    public Item takeItem(int ID){
        for(int i = 0; i < 1; i++){
            if(box.contains(ID)){
                Item retItem = box.deleteItem(ID);
                return retItem;
            }
        }
        throw new IllegalArgumentException("There is no such Item");
    }

    public Item getItemFS(int ID) {
        return box.getItem(ID);
    }
}
