package com.pinnet.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        //增强性的bean容器初始化化
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        InitTest initTest = context.getBean("initTest", InitTest.class);
    }

}
