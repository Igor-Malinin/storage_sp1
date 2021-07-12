package com.example.storage_sp.domain;

public class KPI {
    private int boxes = 8;
    private double KPI = 0;
    private double currentCase = 0;
    private double idealCase = 1;


    public double takeItemWithKPI(Storage storage, String type){
        for(int i = 0; i < boxes; i++){
            currentCase += i+1;
            storage.takeItem(type);
        }
        KPI = idealCase/currentCase;
        return KPI;
    }
}
