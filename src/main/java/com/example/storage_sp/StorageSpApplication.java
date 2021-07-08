package com.example.storage_sp;

import com.example.storage_sp.domain.Storage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StorageSpApplication {

    public static void main(String[] args) {


        //storage.takeItem(3);
        //storage.addItem("SAMSUNG", "16:9, 3200x2600, 4k");


        SpringApplication.run(StorageSpApplication.class, args);
    }

}
