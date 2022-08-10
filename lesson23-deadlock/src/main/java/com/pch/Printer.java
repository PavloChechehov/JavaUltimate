package com.pch;

import lombok.SneakyThrows;

public class Printer extends Thread {

    private final Thread[] threads;

    public Printer(WorkerThread... threads) {
        this.threads = threads;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {

            for (Thread thread : threads) {
                System.out.println(thread.getName() + ": "+ thread.getState());
            }
            Thread.sleep(500);
        }
    }
}
