package com.pch;

public class DemoApp {
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
        Node<T> prev = null;

        while (head != null) {
            Node<T> nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        while (prev != null) {
            System.out.println(prev.element);
            prev = prev.next;

        }

    }
}



