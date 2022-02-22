package com.sachin.di.services;


public class ConstructorInjectedGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World --constructor";
    }

}
