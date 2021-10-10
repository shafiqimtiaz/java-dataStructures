package com.datastructures.linkedList;

public class singlyLinkedList {

    class LinkedList {
        Node head;

        public class Node {
            int value;
            Node next;

            Node(int d) {
                value = d;
                next = null;
            }
        }

        public void insert(int data) {
            Node node = new Node();
            node.data = data;
            node.next = null;

            if (head == null) {
                head = node;
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = node;
            }
        }

    }

    public static void main(String[] args) {

    }
}