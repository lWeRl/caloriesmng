package org.lwerl.caloriesmng;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.format("Hello Topjava Webinar!");
        ConfigurableApplicationContext cac = new ClassPathXmlApplicationContext("/spring/spring-app.xml");
        System.out.println(Arrays.toString(cac.getBeanDefinitionNames()));
        cac.close();
    }
}
