package com.example.storage_sp;

import com.example.storage_sp.domain.Storage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StorageSpApplication {

    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.addItem(0, "HP", "16:9, 1920x1080, full hd");
        storage.addItem(1, "AOC", "16:9, 2700x1570, full hd");
        storage.addItem(2,"DELL", "16:9, 1920x1080, hd");
        storage.addItem(3,"RAZER", "16:9, 1920x1080, full hd");
        storage.addItem(4,"SONY", "16:9, 3200x2600, 4k");

        //storage.takeItem(3);
        //storage.addItem("SAMSUNG", "16:9, 3200x2600, 4k");


        SpringApplication.run(StorageSpApplication.class, args);
    }

}
