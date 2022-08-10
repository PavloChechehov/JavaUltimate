package com.pch;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo2 {

    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread(lock1, lock2);
        t1.setName("Thread-1");
        WorkerThread t2 = new WorkerThread(lock2, lock1);
        t1.setName("Thread-2");

        Printer printer = new Printer(t1, t2);

        t1.start();
        t2.start();
        printer.start();
    }
}
