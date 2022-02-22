package com.sachin.di.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World --constructor";
    }

}
