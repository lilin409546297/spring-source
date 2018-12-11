package com.pinnet.aware;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;

public class TestEmbeddedValueResolverAware implements EmbeddedValueResolverAware {

    private StringValueResolver stringValueResolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver = stringValueResolver;
    }

    public String getProperties (String name) {
        String elName = "${"+ name +"}";
        return stringValueResolver.resolveStringValue(elName);
    }

    @PostConstruct
    public void test() {
        System.out.println(getProperties("name"));
    }
}
