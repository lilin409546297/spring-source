package com.pinnet.aware;

import org.springframework.context.ApplicationEvent;

/**
 * Funtion: TODO.
 * <p>
 * Author: lWX559685
 * Date: 2018/12/11 14:54
 */
public class TestEvent extends ApplicationEvent {

    private Object object;

    public TestEvent(Object source, Object object) {
        super(source);
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
