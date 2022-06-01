package com.pch.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MergeSort<T extends Comparable<? super T>> extends RecursiveTask<List<T>> {

    private final List<T> list;

    public MergeSort(List<T> list) {
        this.list = list;
    }

    @Override
    protected List<T> compute() {
        if (list.size() < 2) {
            return list;
        }

        int halfSize = list.size() / 2;

        List<T> leftPart = new ArrayList<>(list.subList(0, halfSize));
        List<T> rightPart = new ArrayList<>(list.subList(halfSize, list.size()));

        MergeSort<T> m1 = new MergeSort<>(leftPart);
        MergeSort<T> m2 = new MergeSort<>(rightPart);

        m1.fork();
        m2.compute();
        m1.join();

        merge(leftPart, rightPart);

        return list;
    }

    private void merge(List<T> leftPart, List<T> rightPart) {
        int right = 0, left = 0, i = 0;
        while (left < leftPart.size() && right < rightPart.size()) {
            if (leftPart.get(left).compareTo(rightPart.get(right)) < 0) {
                list.set(i++, leftPart.get(left++));
            } else {
                list.set(i++, rightPart.get(right++));
            }

        }

        while (left < leftPart.size()) {
            list.set(i++, leftPart.get(left++));
        }

        while (right < rightPart.size()) {
            list.set(i++, rightPart.get(right++));
        }
    }
}

