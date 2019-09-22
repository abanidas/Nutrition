package com.abani.capstone.nutrients.NutrientsFoodApi.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @GetMapping(value = "/")
    public String loadDefault(){
        return "<h1>Rest API for Nutrition Guide</h1>";
    }
}
