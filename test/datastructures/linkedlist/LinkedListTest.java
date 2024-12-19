package datastructures.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void append() {
        LinkedList linkedList = new LinkedList();

        // When linked list is empty.
        linkedList.append(1);

        assertEquals(1, linkedList.getLength());
        assertEquals(1, linkedList.getHead().value);
        assertEquals(1, linkedList.getTail().value);

        // When linked list is not empty.
        linkedList.append(2);
        linkedList.append(3);

        assertEquals(3, linkedList.getLength());
        assertEquals(1, linkedList.getHead().value);
        assertEquals(3, linkedList.getTail().value);
    }

    @Test
    void removeLast() {
        LinkedList linkedList = TestData.getLinkedList_With_3_Node();

        // When linked list having 3 node: 1 -> 2 -> 3
        Node result = linkedList.removeLast();

        assertEquals(3, result.value);
        assertEquals(2, linkedList.getLength());
        assertEquals(1, linkedList.getHead().value);
        assertEquals(2, linkedList.getTail().value);

        // When linked list having 2 node: 1 -> 2
        result = linkedList.removeLast();

        assertEquals(2, result.value);
        assertEquals(1, linkedList.getLength());
        assertEquals(1, linkedList.getHead().value);
        assertEquals(1, linkedList.getTail().value);

        // When linked list having 1 node: 1
        result = linkedList.removeLast();

        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals(1, result.value);
        assertEquals(0, linkedList.getLength());
    }

    @Test
    void prepend() {
        LinkedList linkedList = new LinkedList();

        // When linked list is empty.
        linkedList.prepend(1);

        assertEquals(1, linkedList.getLength());
        assertEquals(1, linkedList.getHead().value);
        assertEquals(1, linkedList.getTail().value);

        // When linked list is not empty.
        linkedList.prepend(2);
        linkedList.prepend(3);

        assertEquals(3, linkedList.getLength());
        assertEquals(3, linkedList.getHead().value);
        assertEquals(1, linkedList.getTail().value);
    }

    @Test
    void removeFirst() {
        LinkedList linkedList = TestData.getLinkedList_With_3_Node();

        // When linked list having 3 node: 1 -> 2 -> 3
        Node result = linkedList.removeFirst();

        assertEquals(1, result.value);
        assertEquals(2, linkedList.getLength());
        assertEquals(2, linkedList.getHead().value);
        assertEquals(3, linkedList.getTail().value);

        // When linked list having 2 node: 2 -> 3
        result = linkedList.removeFirst();

        assertEquals(2, result.value);
        assertEquals(1, linkedList.getLength());
        assertEquals(3, linkedList.getHead().value);
        assertEquals(3, linkedList.getTail().value);

        // When linked list having 1 node: 3
        result = linkedList.removeFirst();

        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals(3, result.value);
        assertEquals(0, linkedList.getLength());
    }

    @Test
    void get() {
        LinkedList linkedList = TestData.getLinkedList_With_3_Node();

        // When index is less than 0.
        Node result = linkedList.get(-1);
        assertNull(result);

        // When index is greater than or equal to length.
        result = linkedList.get(3);
        assertNull(result);

        // When correct index is passed.
        result = linkedList.get(0);
        assertEquals(1, result.value);
    }

    @Test
    void set() {
        LinkedList linkedList = TestData.getLinkedList_With_3_Node();

        // When index is less than 0.
        boolean result = linkedList.set(-1,5);
        assertFalse(result);

        // When index is greater than or equal to length.
        result = linkedList.set(3,5);
        assertFalse(result);

        // When correct index is passed.
        result = linkedList.set(1,5);
        assertTrue(result);
        assertEquals(5, linkedList.get(1).value);
    }

    @Test
    void insert() {
        LinkedList linkedList = TestData.getLinkedList_With_3_Node();

        // When index is less than 0.
        boolean result = linkedList.insert(-1,4);
        assertFalse(result);

        // When index is greater than length.
        result = linkedList.insert(4,4);
        assertFalse(result);

        // When correct index is passed.
        result = linkedList.insert(1,4);
        assertTrue(result);
        assertEquals(4, linkedList.getLength());
        assertEquals(4, linkedList.get(1).value);

        // When index is equal to length.
        result = linkedList.insert(4,5);
        assertTrue(result);
        assertEquals(5, linkedList.getLength());
        assertEquals(5, linkedList.get(4).value);

        // When first index is passed.
        result = linkedList.insert(0,6);
        assertTrue(result);
        assertEquals(6, linkedList.getLength());
        assertEquals(6, linkedList.get(0).value);
    }

    @Test
    void remove() {
        LinkedList linkedList = TestData.getLinkedList_With_3_Node();

        // When index is less than 0.
        Node result = linkedList.remove(-1);
        assertNull(result);

        // When index is greater than length.
        result = linkedList.remove(3);
        assertNull(result);

        // When correct index is passed.
        result = linkedList.remove(1);
        assertEquals(2, result.value);
        assertEquals(2, linkedList.getLength());

        // When last index is passed.
        result = linkedList.remove(1);
        assertEquals(3, result.value);
        assertEquals(1, linkedList.getLength());

        // When first index is passed.
        result = linkedList.remove(0);
        assertEquals(1, result.value);
        assertEquals(0, linkedList.getLength());

        // When linked list is empty.
        result = linkedList.remove(0);
        assertNull(result);
    }

    @Test
    void reverse() {
        LinkedList linkedList = TestData.getLinkedList_With_3_Node();

        // After reversing linked list
        linkedList.reverse();

        assertEquals(3,linkedList.get(0).value);
        assertEquals(2,linkedList.get(1).value);
        assertEquals(1,linkedList.get(2).value);
    }

}