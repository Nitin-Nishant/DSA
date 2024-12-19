package datastructures.doublylinkedlist;

import datastructures.linkedlist.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void append() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        // When linked list is empty.
        doublyLinkedList.append(1);
        assertEquals(1, doublyLinkedList.getLength());
        assertEquals(1, doublyLinkedList.getHead().value);
        assertEquals(1, doublyLinkedList.getTail().value);

        // When linked list is not empty.
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        assertEquals(3, doublyLinkedList.getLength());
        assertEquals(1, doublyLinkedList.getHead().value);
        assertEquals(3, doublyLinkedList.getTail().value);
    }

    @Test
    void removeLast() {
        DoublyLinkedList doublyLinkedList = TestData.getDoublyLinkedList_With_3_Node();

        // When linked list having 3 node: 1 -> 2 -> 3
        Node result = doublyLinkedList.removeLast();
        assertEquals(3, result.value);
        assertEquals(2, doublyLinkedList.getLength());
        assertEquals(1, doublyLinkedList.getHead().value);
        assertEquals(2, doublyLinkedList.getTail().value);

        // When linked list having 2 node: 1 -> 2
        result = doublyLinkedList.removeLast();
        assertEquals(2, result.value);
        assertEquals(1, doublyLinkedList.getLength());
        assertEquals(1, doublyLinkedList.getHead().value);
        assertEquals(1, doublyLinkedList.getTail().value);

        // When linked list having 1 node: 1
        result = doublyLinkedList.removeLast();
        assertEquals(1, result.value);
        assertNull(doublyLinkedList.getHead());
        assertNull(doublyLinkedList.getTail());
        assertEquals(0, doublyLinkedList.getLength());
    }

    @Test
    void prepend() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        // When linked list is empty.
        doublyLinkedList.prepend(1);
        assertEquals(1, doublyLinkedList.getLength());
        assertEquals(1, doublyLinkedList.getHead().value);
        assertEquals(1, doublyLinkedList.getTail().value);

        // When linked list is not empty.
        doublyLinkedList.prepend(2);
        doublyLinkedList.prepend(3);
        assertEquals(3, doublyLinkedList.getLength());
        assertEquals(3, doublyLinkedList.getHead().value);
        assertEquals(1, doublyLinkedList.getTail().value);
    }

    @Test
    void removeFirst() {
        DoublyLinkedList doublyLinkedList = TestData.getDoublyLinkedList_With_3_Node();

        // When linked list having 3 node: 1 -> 2 -> 3
        Node result = doublyLinkedList.removeFirst();
        assertEquals(1, result.value);
        assertEquals(2, doublyLinkedList.getLength());
        assertEquals(2, doublyLinkedList.getHead().value);
        assertEquals(3, doublyLinkedList.getTail().value);

        // When linked list having 2 node: 2 -> 3
        result = doublyLinkedList.removeFirst();
        assertEquals(2, result.value);
        assertEquals(1, doublyLinkedList.getLength());
        assertEquals(3, doublyLinkedList.getHead().value);
        assertEquals(3, doublyLinkedList.getTail().value);

        // When linked list having 1 node: 3
        result = doublyLinkedList.removeFirst();
        assertEquals(3, result.value);
        assertNull(doublyLinkedList.getHead());
        assertNull(doublyLinkedList.getTail());
        assertEquals(0, doublyLinkedList.getLength());
    }

    @Test
    void get() {
        DoublyLinkedList doublyLinkedList = TestData.getDoublyLinkedList_With_3_Node();

        // When index is less than 0.
        Node result = doublyLinkedList.get(-1);
        assertNull(result);

        // When index is greater than or equal to length.
        result = doublyLinkedList.get(3);
        assertNull(result);

        // When correct index is passed.
        result = doublyLinkedList.get(0);
        assertEquals(1, result.value);
    }

    @Test
    void set() {
        DoublyLinkedList doublyLinkedList = TestData.getDoublyLinkedList_With_3_Node();

        // When index is less than 0.
        boolean result = doublyLinkedList.set(-1,5);
        assertFalse(result);

        // When index is greater than or equal to length.
        result = doublyLinkedList.set(3,5);
        assertFalse(result);

        // When correct index is passed.
        result = doublyLinkedList.set(1,5);
        assertTrue(result);
        assertEquals(5, doublyLinkedList.get(1).value);
    }

    @Test
    void insert() {
        DoublyLinkedList doublyLinkedList = TestData.getDoublyLinkedList_With_3_Node();

        // When index is less than 0.
        boolean result = doublyLinkedList.insert(-1,4);
        assertFalse(result);

        // When index is greater than length.
        result = doublyLinkedList.insert(4,4);
        assertFalse(result);

        // When correct index is passed.
        result = doublyLinkedList.insert(1,4);
        assertTrue(result);
        assertEquals(4, doublyLinkedList.getLength());
        assertEquals(4, doublyLinkedList.get(1).value);

        // When index is equal to length.
        result = doublyLinkedList.insert(4,5);
        assertTrue(result);
        assertEquals(5, doublyLinkedList.getLength());
        assertEquals(5, doublyLinkedList.get(4).value);

        // When first index is passed.
        result = doublyLinkedList.insert(0,6);
        assertTrue(result);
        assertEquals(6, doublyLinkedList.getLength());
        assertEquals(6, doublyLinkedList.get(0).value);
    }

    @Test
    void remove() {
        DoublyLinkedList doublyLinkedList = TestData.getDoublyLinkedList_With_3_Node();

        // When index is less than 0.
        Node result = doublyLinkedList.remove(-1);
        assertNull(result);

        // When index is greater than length.
        result = doublyLinkedList.remove(3);
        assertNull(result);

        // When correct index is passed.
        result = doublyLinkedList.remove(1);
        assertEquals(2, result.value);
        assertEquals(2, doublyLinkedList.getLength());

        // When last index is passed.
        result = doublyLinkedList.remove(1);
        assertEquals(3, result.value);
        assertEquals(1, doublyLinkedList.getLength());

        // When first index is passed.
        result = doublyLinkedList.remove(0);
        assertEquals(1, result.value);
        assertEquals(0, doublyLinkedList.getLength());

        // When doubly linked list is empty.
        result = doublyLinkedList.remove(0);
        assertNull(result);
    }
}