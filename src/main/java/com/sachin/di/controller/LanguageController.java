package com.sachin.di.controller;

import com.sachin.di.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class LanguageController {
    GreetingService greetingService;

    public LanguageController(@Qualifier("I18nService") GreetingService greetingService){
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
