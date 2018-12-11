package com.pinnet.remote;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpInvokerTest {

    public static void main(String[] args) {
        ApplicationContext client = new ClassPathXmlApplicationContext("spring-httpinvoker-client.xml");
        IRemoteService remoteService = (IRemoteService) client.getBean("remoteService");
        String show = remoteService.show();
        System.out.println(show);
    }
}
