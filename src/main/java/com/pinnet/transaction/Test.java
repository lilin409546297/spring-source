package com.pinnet.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transaction.xml");
        ITransactionUserService transactionUserService = (ITransactionUserService) context.getBean("transactionUserService");
        TransactionUser transactionUser = new TransactionUser();
        transactionUser.setName("test");
        transactionUser.setAge("25");
        transactionUserService.save(transactionUser);
    }
}
