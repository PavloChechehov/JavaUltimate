package com.pch;

import lombok.SneakyThrows;

public class DeadLockDemo {


    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    @SneakyThrows
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();

        while (true) {
            System.out.println("Thread 1 State :: " + thread1.getState());
            System.out.println("Thread 2 State :: " + thread2.getState());
            Thread.sleep(500);
        }

    }


    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (LOCK_1) {
                System.out.println("Thread1: Start running in synchronized block with lock 1");
                System.out.println("Thread 1 State :: " + this.getState());
                try {
                    Thread.sleep(10);
                    System.out.println("Thread1: Sleeping for 10 milliseconds");
                    System.out.println("Thread1 State :: " + this.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread1 State :: " + this.getState());
                System.out.println("Thread1: Waiting for lock 2");
                synchronized (LOCK_2) {
                    System.out.println("Thread1: Running in synchronized block with lock 2");
                }

            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (LOCK_2) {
                System.out.println("Thead2: Start running in synchronized block with lock 2");
                System.out.println("Thread2 State :: " + this.getState());

                try {
                    Thread.sleep(10);
                    System.out.println("Thread2: Sleeping for 10 milliseconds");
                    System.out.println("Thread2 State :: " + this.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread1: Waiting for lock 1");
                System.out.println("Thread2 State :: " + this.getState());
                synchronized (LOCK_1) {
                    System.out.println("Thead2: Running in synchronized block with lock 1");
                }

            }
        }
    }

}
