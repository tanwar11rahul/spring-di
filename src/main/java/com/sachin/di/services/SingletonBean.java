package com.sachin.di.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class SingletonBean {

    public SingletonBean(){
        System.out.println("................Creating Singleton Bean......... ");
    }
    public String getMyScope(){
        return "......Singleton Bean........";
    }
}
