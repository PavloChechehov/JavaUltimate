package com.pch.homework;

import java.util.Arrays;
import java.util.List;

import static com.pch.Utils.generateList;

public class MergeDemo {

    public static void main(String[] args) {
        List<Integer> integers = generateList(100);

        MergeSort<Integer> mergeSort = new MergeSort<>(integers);
        List<Integer> compute = mergeSort.compute();
        System.out.println("compute = " + compute);
    }

    private static int[] mergeSort(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }

        int halfLength = arr.length / 2;
        int[] leftArr = Arrays.copyOf(arr, halfLength);
        int[] rightArr = Arrays.copyOfRange(arr, halfLength, arr.length);

        mergeSort(leftArr);
        mergeSort(rightArr);

        int left = 0, right = 0, i = 0;
        while (left < leftArr.length && right < rightArr.length) {
            if (leftArr[left] < rightArr[right]) {
                arr[i] = leftArr[left];
                left++;
            } else {
                arr[i] = rightArr[right];
                right++;
            }
            i++;
        }

        System.arraycopy(leftArr, left, arr, i, leftArr.length - left);
        System.arraycopy(rightArr, right, arr, i, rightArr.length - right);

        return arr;
    }
}
