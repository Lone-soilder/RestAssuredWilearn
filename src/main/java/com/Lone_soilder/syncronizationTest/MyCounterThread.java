package com.Lone_soilder.syncronizationTest;

public class MyCounterThread extends Thread{

    private Counter counter;

    public MyCounterThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i=0 ; i< 1000 ; i++){
            counter.increment();
        }
    }
}
