package com.pch.homework;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {

    private final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    protected Integer compute() {
        if (n <= 1) return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci(5);
        Integer compute = fibonacci.compute();
        System.out.println("compute = " + compute);
    }
}
