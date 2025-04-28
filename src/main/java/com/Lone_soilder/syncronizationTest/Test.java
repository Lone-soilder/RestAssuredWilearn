package com.Lone_soilder.syncronizationTest;

public class Test {
    public static void main(String[] args) {

        Counter counter = new Counter();
        MyCounterThread myThread1 = new MyCounterThread(counter);
        MyCounterThread myThread2 = new MyCounterThread(counter);

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        }catch (InterruptedException e){
           e.printStackTrace();
        }
        System.out.println("expected answer is 2000.");
        System.out.println(counter.getCount());

    }
}
