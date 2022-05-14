package com.pch.homework;

import java.util.Objects;

/**
 * A simple implementation of the Hash Table that allows storing a generic key-value pair. The table itself is based
 * on the array of {@link Node} objects.
 * <p>
 * An initial array capacity is 16.
 * <p>
 * Every time a number of elements is equal to the array size that tables gets resized
 * (it gets replaced with a new array that it twice bigger than before). E.g. resize operation will replace array
 * of size 16 with a new array of size 32. PLEASE NOTE that all elements should be reinserted to the new table to make
 * sure that they are still accessible  from the outside by the same key.
 *
 * @param <K> key type parameter
 * @param <V> value type parameter
 */
public class HashTable<K, V> {

    private int initialCapacity = 16;
    private int size = 0;
    private Node<K, V>[] arr;

    @SuppressWarnings({"unchecked", "rawtype"})
    public HashTable() {
        this.arr = new Node[initialCapacity];
    }

    @SuppressWarnings({"unchecked", "rawtype"})
    public HashTable(int initCapacity) {
        this.initialCapacity = initCapacity;
        this.arr = new Node[initialCapacity];
    }

    /**
     * Puts a new element to the table by its key. If there is an existing element by such key then it gets replaced
     * with a new one, and the old value is returned from the method. If there is no such key then it gets added and
     * null value is returned.
     *
     * @param key   element key
     * @param value element value
     * @return old value or null
     */
    public V put(K key, V value) {
        Objects.requireNonNull(key);

        if (size >= arr.length) {
            resize();
        }

        V v = putVal(key, value);

        if (v != null) {
            return v;
        }

        size++;
        return null;

    }

    private V putVal(K key, V value) {

        int hashKey = calculateHash(key);
        Node<K, V> node = arr[hashKey];

        if (node == null) {
            arr[hashKey] = new Node<>(key, value);
        } else {

            V v = checkAndReplace(key, value, node);
            if (v != null) return v;

            while (node.next != null) {
                node = node.next;
                v = checkAndReplace(key, value, node);
                if (v != null) return v;
            }

            node.next = new Node<>(key, value);

        }

        return null;
    }

    private V checkAndReplace(K key, V value, Node<K, V> node) {
        if (Objects.equals(node.key, key)) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        return null;
    }

    @SuppressWarnings({"unchecked", "rawtype"})
    private void resize() {
        this.initialCapacity *= 2;
        Node<K, V>[] oldArr = arr;
        arr = new Node[initialCapacity];

        for (Node<K, V> node : oldArr) {
            while (node != null) {
                putVal(node.key, node.value);
                node = node.next;
            }
        }
    }

    private int calculateHash(K key) {
        return Math.abs(key.hashCode() % initialCapacity);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints a content of the underlying table (array) according to the following format:
     * 0: key1:value1 -> key2:value2
     * 1:
     * 2: key3:value3
     * ...
     */
    public void printTable() {
        for (int i = 0; i < arr.length; i++) {
            Node<K, V> current = arr[i];
            System.out.print(i + ":");
            while (current != null) {
                System.out.printf("%s:%s", current.key, current.value);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;

            }
            System.out.println();
        }
        System.out.println();
    }

    public V get(K key) {

        for (Node<K, V> node : arr) {
            if (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }

                while (node.next != null) {
                    node = node.next;

                    if (node.key.equals(key)) {
                        return node.value;
                    }

                }
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }
}
