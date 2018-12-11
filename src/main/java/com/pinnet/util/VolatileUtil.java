package com.pinnet.util;

import java.util.concurrent.atomic.AtomicBoolean;

public class VolatileUtil {


    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                runnable.run();
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                runnable.stop();
            }
        };
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }

    public static class MyRunnable implements Runnable {

        AtomicBoolean n = new AtomicBoolean(true);
        @Override
        public void run() {
            while (n.get()) {
                System.out.println(n);
            }

        }
        public void stop() {
            n.set(false);
        }
    }
}
