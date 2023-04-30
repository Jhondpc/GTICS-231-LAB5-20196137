package com.example.gtics231lab520196137.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String index(){
        return "recursosHumanos";
    }
}
