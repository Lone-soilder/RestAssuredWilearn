package com.Lone_soilder.MultiThreadingPractice;

// see engineering digest multithreading life cycle video
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("My thread is running.");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //below I am running myThread in main thread
    //REMEMBER - whatever the code written inside in main() , is handled by "main thread".
    //So myThread.start() is calling start() by myThread object but the statement is being executed by main thread.
    // We are trying to print states of myThread in "main thread".
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState()); //NEW - created but not yet ready to run

        myThread.start();
        System.out.println(myThread.getState()); // RUNNABLE - ready to run

        //now trying to stop main thread to give a chance to JVM to run "myThread" automatically.
        Thread.sleep(100); // asking main thread to sleep for 0.01s.
        System.out.println(myThread.getState()); // TIMED_WAITING - my thread is sleeping

        //now mythread is sleeping for 2s so "main thread" is awake now to run
        myThread.join(); // main thread is waiting myThread to be terminated.
        System.out.println(myThread.getState()); //TERMINATED

    }
}
