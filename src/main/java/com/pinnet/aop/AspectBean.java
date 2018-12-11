package com.pinnet.aop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AspectBean {
    private static final Map<Class, Object> map = new ConcurrentHashMap<Class, Object>();

    public static Object getBean(Class clazz) {
        return map.get(clazz);
    }

    public static void init() {
        AspectExcuteChild child = new AspectExcuteChild();
        AspectInvoke aspectInvoke = new AspectInvoke(child);
        AspectExcuteParent proxy = (AspectExcuteParent) aspectInvoke.getProxy();
        map.put(AspectExcuteParent.class, proxy);
    }
}
