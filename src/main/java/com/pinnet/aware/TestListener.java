package com.pinnet.aware;

import org.springframework.context.ApplicationListener;

public class TestListener implements ApplicationListener<TestApplicationEventPublisherAware.TestEvent>{

    @Override
    public void onApplicationEvent(TestApplicationEventPublisherAware.TestEvent testEvent) {
        System.out.println("TestEvent is Happen" + testEvent.getObject());
    }
}
