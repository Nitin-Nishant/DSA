package datastructures.linkedlist;

import datastructures.doublylinkedlist.DoublyLinkedList;

public class TestData {

    public static LinkedList getLinkedList_With_3_Node() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        return linkedList;
    }

    public static DoublyLinkedList getDoublyLinkedList_With_3_Node() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        return doublyLinkedList;
    }
}
