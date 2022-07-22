package com.example.mbs.impl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ShowController {

    @GetMapping
    public List<String>  getCities(){

        return Collections.emptyList();
    }
}
