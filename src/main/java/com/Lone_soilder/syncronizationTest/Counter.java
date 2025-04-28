package com.Lone_soilder.syncronizationTest;

public class Counter {

    private int count = 0;
    public synchronized void increment(){
        System.out.println(Thread.currentThread().getName());
        count++;
    }

    public int getCount() {
        return count;
    }
}
