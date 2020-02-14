package com.zaynukov.dev;

import com.zaynukov.dev.service.people.MyServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.zaynukov.dev")
public class MainBeanByClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainBeanByClass.class);
        MyServiceImpl myService = context.getBean(MyServiceImpl.class);
        myService.sayAnything();
    }
}
