package com.qa.selenium.configurations.config;


import com.qa.selenium.configurations.annotation.LazyConfiguration;
import com.qa.selenium.configurations.annotation.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@LazyConfiguration
public class WebDriverConfig {


    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver getChromeDriver(){
        return new ChromeDriver();
    }


}
