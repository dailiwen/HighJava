package org.ddd.section6.example6_13;

import java.util.concurrent.atomic.AtomicInteger;

//org/ddd/thread/threadlocal/UniqueThreadIdGenerator.java
public class UniqueThreadIdGenerator {

    private static final AtomicInteger uniqueId = new AtomicInteger(0);

    private static final ThreadLocal < Integer > uniqueNum = 
        new ThreadLocal < Integer > () {
            @Override 
            protected Integer initialValue() {
                return uniqueId.getAndIncrement();
        }
    };

    public static int getCurrentThreadId() {
        return uniqueId.get();
    }
}  
