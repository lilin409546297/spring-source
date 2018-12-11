package com.pinnet.bean;

import org.springframework.beans.factory.InitializingBean;

/**
 * Funtion: TODO.
 * <p>
 * Author: lWX559685
 * Date: 2018/8/2 19:10
 */
public class InitializingBeanTest implements InitializingBean{
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }
}
