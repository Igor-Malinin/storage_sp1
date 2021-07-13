package com.example.storage_sp.repository;

import com.example.storage_sp.domain.Item;

import java.util.ArrayList;

public interface StorageInterface {

    boolean addItem(int place, String type, String brandN, String description);

    boolean addItem(String type, String brandN, String description);

    Item takeItem(int place);

    Item takeItem(String type);

    int getShelfs();

    int getIterations();
}
