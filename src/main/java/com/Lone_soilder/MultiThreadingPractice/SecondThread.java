package com.Lone_soilder.MultiThreadingPractice;


// one way to crate a thread is to extend the Thread class

public class SecondThread extends Thread{
    @Override
    public void run() {
        //running a infinite loop to see how first(main) thread and second thread run concurrently.
        while(true){
            System.out.println("second thread running.. and it's name is " + Thread.currentThread().getName());
        }
    }
}
