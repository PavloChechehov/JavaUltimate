package com.pch.homework;

import static com.pch.Utils.generate;

public class BubbleSort {
    public static void main(String[] args) {
        for (int i = 10; i <= 10_000_000; i = i + 10000) {
            int[] arr = generate(i);
            long start = System.currentTimeMillis();
            int[] sort = sort(arr);
            long end = System.currentTimeMillis();
            long duration = end - start;
            System.out.printf("%12d %12d", i, duration);
            System.out.println();
        }
    }

    private static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // j = 1 -> 2 -> 3
            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j - 1] > arr[j]) {
                    int max = arr[j - 1]; //5
                    arr[j - 1] = arr[j];  // 5 -> 2 [2, 2]  | [2, 3, 3]
                    arr[j] = max; // [2, 5]                 | [2, 3, 5]
                }
            }
        }

        return arr;
    }
}
