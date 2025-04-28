package com.Lone_soilder.learningConcurrency;

//When multiple threads access shared resources,
// you need to ensure that the resource is accessed by only one thread at a time to prevent data inconsistency.
// This is done using synchronization.
// Without synchronized: You risk race conditions and data inconsistency.
// Without join(): The main thread may not wait for other threads to complete, leading to incomplete results.
//import groovyjarjarantlr4.runtime.tree.TreeAdaptor;

class Counter {
    private int count = 0;

    public  void incrementCount(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
public class MySyncClass {

    public static void main(String[] args) {

        Counter counter = new Counter();
        Thread thread1 = new Thread( () -> {
            for (int i=1 ; i<= 1000 ; i++){
                //System.out.println("thread 1 is increasing");
                counter.incrementCount();
            }
        });

        Thread thread2 = new Thread( ()->{
            for (int i=1 ; i<=1000 ;i++){
                //System.out.println("thread 2 is increasing");
                counter.incrementCount();
            }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
            //Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(e);
        }

        System.out.println("final count =" + counter.getCount());
    }
}
