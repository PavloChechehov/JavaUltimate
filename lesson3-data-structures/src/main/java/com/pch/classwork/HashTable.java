package com.pch.classwork;

import java.util.List;

public class HashTable<T> {

    public static void main(String[] args) {
        var names = List.of("Andrii", "Serhii", "Nazar", "Taras", "Stas", "Yurii",
                "Tetiana", "Valerii", "Victoriai", "Stas");
        var namesTable = new HashTable<String>();
        names.forEach(namesTable::add);
        namesTable.printTable();
    }

    /**
     * Adds an element to the hash table. Does not support duplicate elements.
     *
     * @param element
     * @return true if it was added
     */

    private int initSize = 4;
    private int size;
    private static final double THRESHOLD = 0.75;
    @SuppressWarnings({"unchecked", "rawtype"})
    private Node<T>[] arr = new Node[initSize];

    public boolean add(T element) {
        int i = calculate(element);

        if (size >= initSize * THRESHOLD) {
            System.out.println("Resizing...");
            resize(initSize * 2);
        }

        Node<T> current = arr[i];
        Node<T> newNode = new Node<>(element);

        if (current == null) {
            arr[i] = newNode;
        } else {
            //check first element on duplication
            if (current.element.equals(element)) {
                return false;
            } else {
                while (current.next != null) {
                    current = current.next;
                    if (current.element.equals(element)) {
                        //check element on duplication
                        return false;
                    }

                }

                current.next = newNode;
                size++;

            }
        }
        return true;
    }

    private int calculate(T element) {
        return Math.abs(element.hashCode() % initSize);
    }

    /**
     * Prints a hash table according to the following format
     * 0: Andrii -> Taras
     * 1: Start
     * 2: Serhii
     * ...
     */
    public void printTable() {
        for (int i = 0; i < arr.length; i++) {
            Node<T> node = arr[i];
            System.out.print(i + ":");
            while (node != null) {

                System.out.print(node.element);
                if (node.next != null) {
                    System.out.print("->");
                }
                node = node.next;

            }
            System.out.println();

        }
    }

    /**
     * Creates a new underlying table with a given size and add all elements to the new table.
     *
     * @param newSize
     */

    @SuppressWarnings({"unchecked", "rawtype"})
    public void resize(int newSize) {
        this.initSize = newSize;
        Node<T>[] oldArr = arr;
        this.arr = new Node[initSize];

        for (int i = 0; i < oldArr.length; i++) {
            Node<T> node = oldArr[i];
            while (node != null) {
                add(node.element);
                node = node.next;
            }
        }
    }
}
