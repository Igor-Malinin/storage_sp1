package com.example.storage_sp.applications;

import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.Storage;
import com.example.storage_sp.repository.StorageStatus;

import java.util.HashMap;

public class StorStatus implements StorageStatus {

    private static HashMap<Integer, Item> storageStatus = new HashMap<Integer, Item>();

    public void updateStorageStatus(int place, Item item) {
        this.storageStatus.put(place, item);
    }
    public HashMap<Integer, Item> getStorageStatus(){
        return storageStatus;
    }
    public void getOccupiedPlacesInfo() {
        System.out.println("Occupied places: ");
        for (int i = 0; i < storageStatus.size(); i++) {
            if (storageStatus.get(i) != null)
                System.out.println(storageStatus.get(i).getPlace());
        }
    }




}
