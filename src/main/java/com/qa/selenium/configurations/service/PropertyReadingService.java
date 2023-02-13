package com.qa.selenium.configurations.service;

import com.qa.selenium.configurations.annotation.LazyAutowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Lazy
@Service
public class PropertyReadingService {


    @LazyAutowired
    private ApplicationContext applicationContext;

    @LazyAutowired
    private ResourceLoader resourceLoader;

    public String getProperty(String key){
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("environment.properties"));
            if(!properties.isEmpty() || !properties.containsKey("environment") || !properties.getProperty("environment").isEmpty())
                properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("application-"+properties.getProperty("environment")+".properties"));
            else
                properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }


}
