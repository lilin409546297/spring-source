package com.pinnet.message;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.HierarchicalMessageSource;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Message {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-message.xml");
        ResourceBundleMessageSource messageSource = context.getBean("messageSource", ResourceBundleMessageSource.class);
        String messageZh = messageSource.getMessage("testtest", new Object[]{"数据"}, Locale.CHINESE);
        String messageEn = messageSource.getMessage("testtest", new Object[]{"data"}, Locale.ENGLISH);
        System.out.println(messageZh);
        System.out.println(messageEn);

        ResourceBundle resourceBundle = ResourceBundle.getBundle("message.test", Locale.US);
        String testest = resourceBundle.getString("testtest");
        String format = MessageFormat.format(testest, new Object[]{"data"});
        System.out.println(format);
    }


}
