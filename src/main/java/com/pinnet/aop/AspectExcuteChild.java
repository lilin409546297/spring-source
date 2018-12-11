package com.pinnet.aop;

public class AspectExcuteChild implements AspectExcuteParent{

    public void test() {
        System.out.println("test");
    }

//    public static void main(String[] args) {
//        AspectBean.init();
//        AspectExcuteParent aspectExcuteParent = (AspectExcuteParent) AspectBean.getBean(AspectExcuteParent.class);
//        aspectExcuteParent.test();
//
//    }
}
