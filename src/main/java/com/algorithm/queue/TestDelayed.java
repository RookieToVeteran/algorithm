package com.algorithm.queue;

import java.time.LocalDateTime;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelayed implements Delayed {


    private long delayTime;
    private Object item;
    public TestDelayed(long delayTime,Object obj){
        this.item = obj;
        LocalDateTime localDateTime = LocalDateTime.now();
        this.delayTime = localDateTime.getSecond() + delayTime;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        LocalDateTime localDateTime = LocalDateTime.now();
        long convert = unit.convert(delayTime - localDateTime.getSecond(), TimeUnit.SECONDS);
        return convert;
    }

    @Override
    public int compareTo(Delayed o) {
        return this.getDelay(TimeUnit.SECONDS)-o.getDelay(TimeUnit.SECONDS) <0 ? -1 : 1;
    }

    public Object getItem(){
        return this.item;
    }
}
