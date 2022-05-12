package com.pch;

import java.util.NoSuchElementException;

public class BinarySearch {
    public static void main(String[] args) {


        int[] arr = {1, 2, 4, 6, 7, 12, 15, 88};
        System.out.println("position of item: " + search(arr, 12));
    }

    private static int search(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr[mid];
            if (guess == item) {
                return mid;
            } else if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        throw new  NoSuchElementException();
    }

}
