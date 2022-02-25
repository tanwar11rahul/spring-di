package com.sachin.di.config;

import com.sachin.di.datasource.FakeDataSource;
import com.sachin.di.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@PropertySource("classpath:dbconfig.properties")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${dbname.username}") String username,
                                  @Value("${dbname.password}") String password,
                                  @Value("${dbname.dburl}") String dburl){
        FakeDataSource source = new FakeDataSource();
        source.setUsername(username);
        source.setPassword(password);
        source.setDburl(dburl);

        return source;
    }

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
}
