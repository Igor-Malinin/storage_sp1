package com.example.storage_sp.controller;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public Shelfs[] shelf = new Shelfs[100];
    public List<Shelfs> shelfsList = new ArrayList<Shelfs>();

    private class Shelfs {
        private int shelfNumber;
        private int rowNum;
        private int colNum;
    }
}
