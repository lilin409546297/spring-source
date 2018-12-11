package com.pinnet.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AspectInvoke implements InvocationHandler {

    private Object object;

    public AspectInvoke(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(object, args);
        System.out.println("after");
        return invoke;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), object.getClass().getInterfaces(), this);
    }
}
