package com.pinnet.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectHandler {

    @Before("execution(* *.*(..))")
    public void before() {
        System.out.println("before");
    }

    @After("execution(* *.*(..))")
    public void after() {
        System.out.println("after");
    }

    @AfterThrowing("execution(* *.*(..))")
    public void AfterThrow() {
        System.out.println("throw");
    }

}
