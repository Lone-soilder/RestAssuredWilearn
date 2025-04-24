package com.Lone_soilder.learningConcurrency;


//Using thread pools helps manage multiple threads efficiently.
//The ExecutorService interface provides methods to manage a pool of threads.

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExmp {
    public static void main(String[] args) {

        //In this example, we create a pool of 5 threads and submit 10 tasks to the pool.
        //The shutdown() method is called to stop accepting new tasks and finish existing ones.
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i=0 ; i<10 ; i++){
            executorService.submit(()->{
                System.out.println("task running :" + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
