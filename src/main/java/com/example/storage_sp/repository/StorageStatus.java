package com.example.storage_sp.repository;

import com.example.storage_sp.domain.Item;

import java.util.HashMap;

public interface StorageStatus {
    void updateStorageStatus(int place, Item item);
    HashMap<Integer, Item> getStorageStatus();
    void getOccupiedPlacesInfo();
}
