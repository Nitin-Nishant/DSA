package datastructures.doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    // Non-parameterise constructor
    public DoublyLinkedList() {

    }

    // Parameterise constructor
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // This method is responsible for adding a node at the end.
    public void append(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    // This method is responsible for removing a node from the last position.
    public Node removeLast() {
        if(head == null)
            return null;
        Node temp = tail;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    // This method is responsible for adding a node at the beginning position.
    public void prepend(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    // This method is responsible for removing the first node.
    public Node removeFirst() {
        if(head == null)
            return null;
        Node temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    // This method is responsible for fetching a specific node.
    public Node get(int index) {
        if(index < 0 || index >= length)
            return null;
        Node temp = head;
        if(index < length/2) {
            for(int i=0; i<index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i=length - 1; i>index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    // This method is responsible for updating the value of a specific node.
    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // This method is responsible for adding a node at the specified index.
    public boolean insert(int index, int value) {
        if(index < 0 || index > length)
            return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index);
        Node prev = temp.prev;
        newNode.prev = prev;
        prev.next = newNode;
        newNode.next = temp;
        temp.prev = newNode;
        length++;
        return true;
    }

    // This method is responsible for removing the node from the specified index.
    public Node remove(int index) {
        if(index < 0 || index >= length)
            return null;
        if(index == 0)
            return removeFirst();
        if(index == length - 1)
            return removeLast();
        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    // This function is used to print the LinkedList.
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getHead() {
        if(head != null)
            return head;
        return null;
    }

    public Node getTail() {
        if(tail != null)
            return tail;
        return null;
    }

    public int getLength() {
        return length;
    }

}
