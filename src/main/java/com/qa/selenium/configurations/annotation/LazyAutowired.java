package com.qa.selenium.configurations.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

@Lazy
@Autowired
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface LazyAutowired {
}
