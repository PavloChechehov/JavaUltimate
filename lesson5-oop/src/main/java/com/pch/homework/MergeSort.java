package com.pch.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {

    public static void main(String[] args) {
//        List<Integer> integers = List.of(8, 4, 5, 1, 9, 10);
        List<Integer> mutableCollection = generateList(100);
        List<Integer> sort = sort(mutableCollection);
        System.out.println(sort);
    }

    public static List<Integer> generateList(int length) {
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(ThreadLocalRandom.current().nextInt(length));
        }
        return list;
    }

    private static <T extends Comparable<T>> List<T> sort(List<T> list) {

        int size = list.size();
        if (size == 1) {
            return list;
        }

        int halfSize = size / 2;

        List<T> leftList = new ArrayList<>(list.subList(0, halfSize));
        List<T> rightList = new ArrayList<>(list.subList(halfSize, size));

        sort(leftList);
        sort(rightList);

        return merge(list, leftList, rightList);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> list,
                                                           List<T> leftList,
                                                           List<T> rightList) {
        int left = 0, right = 0, index = 0;

        while (left < leftList.size() && right < rightList.size()) {
            T leftElem = leftList.get(left);
            T rightElem = rightList.get(right);

            if (leftElem.compareTo(rightElem) <= 0) {
                list.set(index, leftElem);
                left++;
            } else {
                list.set(index, rightElem);
                right++;
            }
            index++;
        }

        while (left < leftList.size()) {
            list.set(index++, leftList.get(left++));
        }

        while (right < rightList.size()) {
            list.set(index++, rightList.get(right++));
        }

        return list;
    }
}
