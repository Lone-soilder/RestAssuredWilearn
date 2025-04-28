package com.Lone_soilder.LockPractice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SBIAccount {

    private int balance = 100 ;

    private Lock lock = new ReentrantLock();

    public int getBalance() {
        return balance;
    }

    public void  withdraw(int amount)  {
        String threadName = Thread.currentThread().getName();

        System.out.println( threadName + " attempting to withdraw Rs." + amount);

        try {
            if (lock.tryLock(1000 , TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    System.out.println(threadName + "proceeding with withdraw ");
                    try {
                        System.out.println("wait for 3s.");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(threadName + "completed withdraw , remaining balance is Rs."+ balance);
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                        System.out.println("exception in thread execution captured");
                    }
                    finally {
                        lock.unlock();
                    }

                }else {
                    System.out.println(threadName + "insufficient balance");
                }
            }else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock , will try next time");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
