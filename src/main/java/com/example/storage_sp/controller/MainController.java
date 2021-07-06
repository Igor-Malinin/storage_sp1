package com.example.storage_sp.controller;

import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.Storage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class MainController {
    private Storage storage;

    @GetMapping("/items")
    public List<Item> getAll(){


        return null;
    }


}
