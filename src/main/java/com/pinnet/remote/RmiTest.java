package com.pinnet.remote;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiTest {
    public static void main(String[] args) {
        ApplicationContext server = new ClassPathXmlApplicationContext("spring-rmi-server.xml");
        ApplicationContext client = new ClassPathXmlApplicationContext("spring-rmi-client.xml");
        IRemoteService remoteService = (IRemoteService) client.getBean("remoteService");
        remoteService.show();
    }
}
