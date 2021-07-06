package com.example.storage_sp.domain;

import java.util.List;

public class Shelf {
    private int capacity = 0;
    private int rows;
    private int cols;
    private int size;
    private Item[][] items;


    public Shelf(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.size = rows * cols;
        items = new Item[rows][cols];
    }
    public boolean hasSpace(){
        return capacity != size;
    }
    public void addItem(Item item){
        if (capacity == size)
            throw new IllegalArgumentException("New Item does not added");
        mainLoop:
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(items[i][j] == null){
                    items[i][j] = item;
                    capacity++;
                    break mainLoop;
                }
            }
        }
    }
    public boolean contains(int ID){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(items[i][j] != null && items[i][j].getID() == ID){
                    return true;
                }
            }
        }
        return false;
    }
    public Item deleteItem(int ID){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(items[i][j] != null && items[i][j].getID() == ID){
                    Item retItem = items[i][j];
                    items[i][j] = null;
                    capacity--;
                    return retItem;
                }
            }
        }
        throw new IllegalArgumentException("Item with this ID does not exist.");
    }
    public Item[][] getItems(){
        return items;
    }
}
