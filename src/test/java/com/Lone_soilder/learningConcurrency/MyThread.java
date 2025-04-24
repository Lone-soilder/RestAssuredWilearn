package com.Lone_soilder.learningConcurrency;

public class MyThread extends Thread {

    @Override
    public void run() {

        for(int i =0 ; i< 5 ; i++){
            System.out.println("thread is running " + i);
            try{
                Thread.sleep(1000); // will print above statement after 1 sec
            }catch (InterruptedException exception){
                System.out.println(exception);
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();
    }


}
