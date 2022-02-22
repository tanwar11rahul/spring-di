package com.sachin.di.config;

import com.sachin.di.services.*;
import com.sachin.pet.CatService;
import com.sachin.pet.DogService;
import com.sachin.pet.PetService;
import com.sachin.pet.PetServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    @Profile({"EN"})
    @Bean
    I18NEnglishService I18nService(){
        return new I18NEnglishService();
    }

    @Profile({"SP", "default"})
    @Bean("I18nService")
    I18NSpanishService I18nSpanishService(){
        return new I18NSpanishService();
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat"})
    @Bean
    PetService catService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }
}
