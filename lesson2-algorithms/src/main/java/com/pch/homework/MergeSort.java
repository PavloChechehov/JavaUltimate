package com.pch.homework;

import java.util.Arrays;

import static com.pch.Utils.generate;

public class MergeSort {
    public static void main(String[] args) {
        for (int i = 10; i <= 10_000_000; i *= 2) {
            int[] arr = generate(i);
            long start = System.currentTimeMillis();
            int[] sort = sort(arr);
            long end = System.currentTimeMillis();
            long duration = end - start;
            System.out.printf("%12d %12d", i, duration);
            System.out.println();
        }
    }

    /*
     it is a divide and conquer algorithm
     4 5   2 1   7 6   9 8
     4 5 | 2 1 | 7 6 | 9 8
     4|5 | 2|1 | 7|6 | 9|8
               ||
               \/
     4 5 | 1 2 | 6 7 | 8 9
     1 2 4 5   | 6 7 8 9

     1 2 4 5 6 7 8 9
    */
    /*
     * {1 , 2} { 4 , 5}
     *
     * { 1, 0, 0, 0}
     * { 1, 2, 0, 0}
     *
     * { 1, 2, 4, 0}
     * { 1, 2, 4, 5}

     * */


    private static int[] sort(int[] input) {

        if (input.length == 1) {
            return input;
        }

        int halfLength = input.length / 2;

        int[] leftPart = Arrays.copyOfRange(input, 0, halfLength);
        int[] rightPart = Arrays.copyOfRange(input, halfLength, input.length);

        return merge(input, sort(leftPart), sort(rightPart));
    }

    private static int[] merge(int[] input, int[] sortedLeft, int[] sortedRight) {
        int leftLength = sortedLeft.length;
        int rightLength = sortedRight.length;
        int leftIndex = 0, rightIndex = 0;
        int fullIndex = 0;

        while (leftIndex < leftLength && rightIndex < rightLength) {

            if (sortedLeft[leftIndex] <= sortedRight[rightIndex]) {
                input[fullIndex++] = sortedLeft[leftIndex++];
            } else {
                input[fullIndex++] = sortedRight[rightIndex++];
            }
        }

        System.arraycopy(sortedLeft, leftIndex, input, fullIndex, sortedLeft.length - leftIndex);
        System.arraycopy(sortedRight, rightIndex, input, fullIndex, sortedRight.length - rightIndex);
        return input;
    }
}
