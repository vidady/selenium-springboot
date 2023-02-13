package com.qa.selenium.page;

import com.qa.selenium.configurations.service.PropertyReadingService;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePage {

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected PropertyReadingService propertyReadingService;

    @PostConstruct
    private void init(){
        PageFactory.initElements(this.webDriver,this);
    }
    public abstract boolean isAt();


}
