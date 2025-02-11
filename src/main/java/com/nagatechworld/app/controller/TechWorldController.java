package com.nagatechworld.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechWorldController {

    @GetMapping("/techworld")
    public String techWorld(){
        return "welcome to nagaTechWorld";
    }

}
