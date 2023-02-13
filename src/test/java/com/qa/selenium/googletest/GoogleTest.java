package com.qa.selenium.googletest;

import com.qa.selenium.SpringBaseTestNGTest;
import com.qa.selenium.configurations.annotation.LazyAutowired;
import com.qa.selenium.page.google.GooglePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleTest extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private WebDriver driver;



    @Test
    public void googleTest(){
        this.googlePage.goTo();
        this.googlePage.getSearchComponent().search("spring boot");

    }









}
