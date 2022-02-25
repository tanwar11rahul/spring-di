package com.sachin.di;

import com.sachin.di.config.PropertiesConfig;
import com.sachin.di.controller.*;
import com.sachin.di.datasource.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ConcurrencyThrottleSupport;

import java.lang.reflect.Constructor;

@ComponentScan(basePackages = {"com.sachin.di", "com.sachin.pet"})
@SpringBootApplication
public class DiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.getGreeting();
		System.out.println(greeting);
		System.out.println(ctx.getId());
		System.out.println(ctx.getStartupDate());
		System.out.println(ctx.getDisplayName());
		System.out.println(ctx.getApplicationName());


		System.out.println("..........Property........");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println(".......Setter......");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println(".......Constructor.......");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println(".....Primary....");
		PrimaryController primaryController = (PrimaryController) ctx.getBean("primaryController");
		System.out.println(primaryController.getGreeting());

		System.out.println("......Language...");
		LanguageController languageController = (LanguageController) ctx.getBean("languageController");
		System.out.println(languageController.getGreeting());

		System.out.println("......Pet.....");
		PetController petController = ctx.getBean(PetController.class);
		System.out.println(petController.getPet());

		System.out.println("........Fake Data Url...........");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("username: " + fakeDataSource.getUsername());
		System.out.println("password: " + fakeDataSource.getPassword());
		System.out.println("dburl: " + fakeDataSource.getDburl());

		System.out.println("........Properties config...........");
		PropertiesConfig propertiesConfig = ctx.getBean(PropertiesConfig.class);
		System.out.println("username: " + propertiesConfig.getUsername());
		System.out.println("password: " + propertiesConfig.getPassword());
		System.out.println("dburl: " + propertiesConfig.getDburl());
	}
}
