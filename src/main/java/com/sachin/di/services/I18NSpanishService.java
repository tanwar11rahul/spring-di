package com.sachin.di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile({"SP", "default"})
//@Service("I18nService")
public class I18NSpanishService implements GreetingService{

    @Override
    public String sayGreeting(){
        return "Hola Munda!";
    }
}
