package com.Lone_soilder.MultiThreadingPractice;


//Another way to create a new thread in Java , implement this interface
public class ThirdThread implements Runnable{

    @Override
    public void run() {

        while(true){
            System.out.println("Third thread is running which name is "+ Thread.currentThread().getName());
        }
    }
}
