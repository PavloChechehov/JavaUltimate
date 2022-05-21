package com.pch.homework;

import com.google.common.base.Function;
import com.google.common.base.Supplier;

import java.util.Locale;

public class BytecodeDemo {

    public static void main(String[] args) {

        String hello = "hello";

//        Supplier<String> supplier = new Supplier<>() {
//            @Override
//            public String get() {
//                return hello.toUpperCase();
//            }
//
//        };
//        supplier.get();

//        Supplier<String> supplier = () -> hello.toUpperCase();

        Supplier<String> supplier = hello::toUpperCase;

        System.out.println(supplier.get());

        new BytecodeDemo().newMethod(hello);
    }

    private void newMethod(String hello) {
        Integer integer = new Integer(100);

        System.out.println(hello);
    }
}
