package com.pch.homework;

import java.util.ArrayList;
import java.util.List;

public class DemoApp {
    public static void main(String[] args) {

//        new ArrayList<Number>[1];
//        List<? super Number> lists = new ArrayList<>();
//        process(lists);
//
//        lists = new ArrayList<Object>();
//        lists = new ArrayList<Number>();


        Class<Integer> aClass = Integer.class;
//
//
//        Integer i = 2022;
//        Class<? extends Integer> aClass1 = i.getClass();
//
//
//        Double d = 2.22;
//        Class<? extends Double> aClass2 = d.getClass();

        //TODO: Ask about this example???
        SomeClass list1 = newList();
    }


    public static void process(List<? super Number> list) {
        list.add(1);
        list.add(2.0);
//        list.add(new Object()); // TODO: Incorrect


    }


    private static <T extends List<T>> T newList() {
        return (T) new ArrayList<T>();
    }
}

class SomeClass {

}
