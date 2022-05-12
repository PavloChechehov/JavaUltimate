package com.pch.homework;


import static com.pch.Utils.generate;

public class InsertionSort {
    public static void main(String[] args) {
        for (int i = 10; i <= 10_000_000; i*=2) {
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

        for (int i = 1; i < arr.length; i++) {

            int position = i;
            int currentItem = arr[i];

            while (position > 0 && currentItem < arr[position - 1]) {
                arr[position] = arr[position - 1];
                position--;
            }

            arr[position] = currentItem;
        }

        return arr;
    }

}
