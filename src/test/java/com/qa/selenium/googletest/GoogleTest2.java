package com.qa.selenium.googletest;

import com.qa.selenium.SpringBaseTestNGTest;
import com.qa.selenium.page.google.GooglePage;
import com.qa.selenium.configurations.service.ScreenShotService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class GoogleTest2 extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private WebDriver driver;

    @Autowired
    private ScreenShotService screenShotService;



    @Test
    public void googleTest2(Method method) throws IOException {
        this.googlePage.goTo();
        this.googlePage.getSearchComponent().search("spring boot");
        screenShotService.takeScreenShot(method+Thread.currentThread().getName());
        driver.quit();

    }






}
