package com.pch.classwork;

public class DemoApp {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4};
        Node<Integer> node = createLinkedList(ints);
        printLinkedList(node);
    }

    /**
     * Creates a linked list based on the input array and returns a head
     */
    public static <T> Node<T> createLinkedList(T... element) {
        T t = element[0];
        Node<T> last = new Node<>(t);

        //[4 -> 3 -> 2 -> 1]
        for (T elem : element) {
            Node<T> node = new Node<>(elem);
            node.next = last;
            last = node;
        }

        return last;
    }

//    public static <T> Node<T> createLinkedList(T... element) {
//        T t = element[0];
//        Node<T> head = new Node<>(t);
//        Node<T> current = head;
//
//        //[4 -> 3 -> 2 -> 1]
//        for (int i = 1; i < element.length; i++) {
//            T elem = element[i];
//            current.next = new Node<>(elem);
//            current = current.next;
//        }
//
//        return head;
//    }

    /**
     * Prints a linked list with arrows like this
     * head:5 -> 7 -> 1 -> 4
     * @param head the first element of the list
     */
    public static void printLinkedList(Node<?> head) {
        System.out.print("head:");
        do {
            System.out.print(head.element + "->");
            head = head.next;
        } while (head != null);
    }
}


