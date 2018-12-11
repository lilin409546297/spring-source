package com.pinnet.aware;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import javax.annotation.PostConstruct;

public class TestApplicationEventPublisherAware implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

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

    @PostConstruct
    public void test() {
        publisher.publishEvent(new TestEvent(this, "test"));
    }
}
