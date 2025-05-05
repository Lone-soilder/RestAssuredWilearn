package com.Lone_soilder.LockPractice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    public final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();

        try {
            System.out.println("outer Method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner method");
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantExample reentrantExample = new ReentrantExample();
        reentrantExample.outerMethod();
    }
}
