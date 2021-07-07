package com.example.storage_sp;

import com.example.storage_sp.domain.Storage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StorageSpApplication {

    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.addItem("HP", "16:9, 1920x1080, full hd");
        storage.addItem("AOC", "16:9, 2700x1570, full hd");
        storage.addItem("DELL", "16:9, 1920x1080, hd");
        storage.addItem("RAZER", "16:9, 1920x1080, full hd");
        storage.addItem("SONY", "16:9, 3200x2600, 4k");

        storage.takeItem(3);

        storage.addItem("SAMSUNG", "16:9, 3200x2600, 4k");
        SpringApplication.run(StorageSpApplication.class, args);
    }

}
