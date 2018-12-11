package com.pinnet.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AspectTest aspectTest = (AspectTest) context.getBean("aspectTest");
        aspectTest.test();
    }
}
