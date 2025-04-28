package com.Lone_soilder.LockPractice;

public class SBIbank {
    public static void main(String[] args) {

        SBIAccount sbiAccount = new SBIAccount();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sbiAccount.withdraw(50);
            }
        };

        Thread t1 = new Thread(runnable , "thread 1");
        Thread t2 = new Thread(runnable , "thread 2");

        t1.start();
        t2.start();

    }
}
