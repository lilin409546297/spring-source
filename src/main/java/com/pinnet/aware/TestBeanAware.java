package com.pinnet.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * BeanNameAware/BeanClassLoaderAware/BeanFactoryAware类似
 */
public class TestBeanAware implements BeanNameAware{

    private String beanName;
    @Override
    public void setBeanName(String beanName) {
        System.out.println(beanName);
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
