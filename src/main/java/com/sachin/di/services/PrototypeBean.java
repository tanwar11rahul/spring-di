package com.sachin.di.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {
    public PrototypeBean(){
        System.out.println("......Creating Prototype Bean......... ");
    }
    public String getMyScope(){
        return "......Prototype Bean........";
    }
}
