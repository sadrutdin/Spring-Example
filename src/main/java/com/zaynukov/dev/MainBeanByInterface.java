package com.zaynukov.dev;

import com.zaynukov.dev.service.my.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.zaynukov.dev")
public class MainBeanByInterface {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainBeanByInterface.class);
        MyService myService = context.getBean(MyService.class);
        myService.sayAnything();
    }
}
