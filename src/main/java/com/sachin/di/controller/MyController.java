package com.sachin.di.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String getGreeting() {
        System.out.println("Welcome");
        return "Sachin";
    }
}
