package com.pch.homework;

public class StringDemo {
    public static void main(String[] args) {
        String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko",
                "c", "10", "11", "12", "13", "14", "15", "16"};
        printString(input, 5);

    }

    private static void printString(String[] arr, int numColumn) {
        //max = 4 spaces, 5 columns
        int[] maxLengthColumn = new int[numColumn];
        for (int i = 0; i < arr.length; i++) {
            int column = i % numColumn;
            if (maxLengthColumn[column] < arr[i].length()) {
                maxLengthColumn[column] = arr[i].length();
            }
        }


        for (int i = 0; i < arr.length; i++) {
            int column = i % numColumn;
            if (i != 0 && column == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ".repeat(maxLengthColumn[column] - arr[i].length() + 4));

        }

    }
}
