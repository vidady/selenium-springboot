package com.qa.selenium.configurations.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Service
public class ScreenShotService {

    @Autowired
    private ApplicationContext applicationContext;



    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenShot(String screenShotName) throws IOException {
        File sourceFile = this.applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,this.path.resolve(screenShotName+".png").toFile());

    }
}
