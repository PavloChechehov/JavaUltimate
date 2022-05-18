package com.pch;


import java.util.Objects;

public class DemoApp2 {
    public static void main(String[] args) {
        var head = createLinkedList(4, 3, 9, 1);
        printReversed(head);
    }

    /**
     * Creates a list of linked {@link Node} objects based on the given array of elements and returns a head of the list.
     *
     * @param elements an array of elements that should be added to the list
     * @param <T>      elements type
     * @return head of the list
     */
    /*public static <T> Node<T> createLinkedList(T... elements) {
    Objects.requireNonNull(elements);
    Objects.checkIndex(0, elements.length);
    var head = new Node<>(elements[0]);
    var current = head;
    for (int i = 1; i < elements.length; i++) {
        current.next = new Node<>(elements[i]);
        current = current.next;
    }
    return head;
}*/
    public static <T> Node<T> createLinkedList(T... elements) {

        Node<T> node = new Node<T>(elements[0]);
        Node<T> head = node;
        for (int i = 1; i < elements.length; i++) {
            T element = elements[i];
            node.next = new Node<>(element);
        }

        return head;
    }

    /**
     * Prints a list in a reserved order using a recursion technique. Please note that it should not change the list,
     * just print its elements.
     * <p>
     * Imagine you have a list of elements 4,3,9,1 and the current head is 4. Then the outcome should be the following:
     * 1 -> 9 -> 3 -> 4
     *
     * @param head the first node of the list
     * @param <T>  elements type
     */
    public static <T> void printReversed(Node<T> head) {
        Objects.requireNonNull(head);
        System.out.println(head.element);
        printRecursively(head.next);
    }

    private static void printRecursively(Node<?> node) {
        if (node != null) {
            printRecursively(node.next);
            System.out.print(node.element + " -> ");
        }
    }
}




