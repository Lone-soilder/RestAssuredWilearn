package com.Lone_soilder.learningConcurrency;

//start(): Starts the execution of the thread. The JVM calls the run method of the thread.
//run(): Contains the code that constitutes the new thread. You can override this method to define the thread's behavior.
//sleep(long millis): Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.
//join(): Waits for the thread to die. It allows one thread to wait for the completion of another.

public class MyRunnableClass implements Runnable{
    @Override
    public void run() {
        System.out.println("my class is running.");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnableClass());

        thread.run();
    }
}
