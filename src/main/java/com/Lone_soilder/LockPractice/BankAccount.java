package com.Lone_soilder.LockPractice;

// the class is using synchronised withdraw method which let both thread to not share the resource balance at a time.
public class BankAccount {

    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int amount){

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " attempting to withdraw Rs." + amount);

        if(balance >= amount){
            System.out.println(threadName + "proceeding with withdraw ");
            try {
                System.out.println("wait for 3s.");
                Thread.sleep(3000);
            }catch (InterruptedException e){

            }
            balance -= amount;
            System.out.println(threadName + "completed withdraw , remaining balance is Rs."+ balance);

        }else {
            System.out.println(threadName + "insufficient balance");
        }
    }
}
