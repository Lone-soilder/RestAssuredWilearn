package com.Lone_soilder.MultiThreadingPractice;

public class FirstThread {
    public static void main(String[] args) {
        //this is your main thread which run simultaneously with other thread when you execute this

        //starting the second thread execution
        SecondThread secondThread = new SecondThread();
        secondThread.start();   //start method to initiate a thread

        //starting the third thread execution , have to initiate calling Thread() and giving the object of implemented class of Runnable interface.
        ThirdThread thirdThread = new ThirdThread();
        Thread thread = new Thread(thirdThread);
        thread.start();

        //now run a infinite loop to see the concurrency
        while(true){
            System.out.println("first /main thread running.. and it's name is "+ Thread.currentThread().getName());
        }
    }
}
