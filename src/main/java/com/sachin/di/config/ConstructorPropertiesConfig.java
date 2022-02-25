package com.sachin.di.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@ConstructorBinding
@ConfigurationProperties("dbname")
public class ConstructorPropertiesConfig {
    private final String username;
    private final String password;
    private final String dburl;

    public ConstructorPropertiesConfig(String username, String password, String dburl) {
        this.username = username;
        this.password = password;
        this.dburl = dburl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDburl() {
        return dburl;
    }
}
