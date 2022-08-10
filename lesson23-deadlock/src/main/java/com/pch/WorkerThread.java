package com.pch;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;

import static java.lang.System.out;

@RequiredArgsConstructor
public class WorkerThread extends Thread {


    private final Lock lock1;
    private final Lock lock2;

    @Override
    @SneakyThrows
    public void run() {
        out.println(this.getName() + " - start running...");

        //lock1
        lock1.lock();

        out.println(this.getName() + " - acquired " + lock1);

        Thread.sleep(10);


        out.println(this.getName() + ": " + this.getState());

        //lock2
        lock2.lock();

        out.println(this.getName() + " - acquired " + lock2 +" in "+ lock1);

        lock2.unlock();
        //unlock2

        out.println(this.getName() + " - unlock" + lock2 +" in "+ lock1);

        lock1.unlock();
        //unlock1
        out.println(this.getName() + " - unlock " + lock1);

    }

}
