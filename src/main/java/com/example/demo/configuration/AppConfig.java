package com.example.demo.configuration;

import com.example.demo.DB;
import com.example.demo.DevDB;
import com.example.demo.ProdDB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDEVBean() {
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production", matchIfMissing = true)
    public DB getpRODBean() {
        return new ProdDB();
    }
}
