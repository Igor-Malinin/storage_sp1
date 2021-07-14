package com.example.storage_sp.domain;


import com.example.storage_sp.applications.BoxLogic;

import java.util.ArrayList;

public class Storage {
    private int boxes;
    private int shelfs = 5;
    private ArrayList<BoxLogic> boxLogic = new ArrayList<BoxLogic>(boxes);

    public Storage(int boxes){
        this.boxes = boxes;
        for (int i = 0; i < boxes; i++)
            boxLogic.add(null);
        for(int i = 0; i < boxes; i++)
        {
            boxLogic.set(i, new BoxLogic(shelfs));
        }
    }

    public int getBoxes() {
        return boxes;
    }

    public void setBoxes(int boxes) {
        this.boxes = boxes;
    }

    public int getShelfs() {
        return shelfs;
    }

    public void setShelfs(int shelfs) {
        this.shelfs = shelfs;
    }

    public ArrayList<BoxLogic> getBoxLogic() {
        return boxLogic;
    }

    public void setBox(ArrayList<BoxLogic> boxLogic) {
        this.boxLogic = boxLogic;
    }
}
