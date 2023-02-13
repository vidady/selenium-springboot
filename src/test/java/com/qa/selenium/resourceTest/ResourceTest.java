package com.qa.selenium.resourceTest;

import com.qa.selenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class ResourceTest extends SpringBaseTestNGTest {

    @Value("classpath:data/testdata.csv")
    private Resource resource;

    @Value("file:C:/Study/spring-selenium/selenium/selenium/src/test/resources/data/testdata.csv")
    private Resource absoluteResource;

    @Autowired
    private ResourceLoader resourceLoader;


    @Test
    public void testFile() throws IOException {
        Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);
    }

    @Test
    public void testAbsoluteFile() throws IOException {
        Files.readAllLines(absoluteResource.getFile().toPath()).forEach(System.out::println);
    }

    @Test
    public void testPropertyFileReading() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("application.properties"));
        System.out.println(properties);
    }
}
