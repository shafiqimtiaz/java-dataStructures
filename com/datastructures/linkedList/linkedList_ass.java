package com.datastructures.linkedList;

import java.util.*;

public class linkedList_ass {
    public static class LinkedList<E> {

        private static class Node<E> {
            private E element;
            private Node<E> next;

            public Node(E e, Node<E> n) {
                element = e;
                next = n;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> n) {
                next = n;
            }
        }

        private Node<E> head = null;
        private Node<E> tail = null;

        public boolean isEmpty() {
            return head == null;
        }

        public E first() {
            if (isEmpty()) {
                return null;
            }
            return head.getElement();
        }

        public E last() {
            if (isEmpty()) {
                return null;
            }
            return tail.getElement();
        }

        public void insert(E e) {
            Node<E> n = new Node<>(e, null);
            if (isEmpty()) {
                head = n;
            } else {
                tail.setNext(n);
            }
            tail = n;
        }

        public void printList() {
            Node<E> n = head;
            while (n != null) {
                System.out.print(n.getElement() + " ");
                n = n.next;
            }
        }
    }


    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();

        stringList.insert("A");
        stringList.insert("B");
        stringList.insert("C");
        stringList.insert("D");
        stringList.printList();
    }
}