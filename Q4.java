// Implement a doubly linked list with methods to insert an element at the head, insert an element at the tail, delete an element by value, and reverse the list. Ensure that all operations handle edge cases appropriately

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertAtHead(int value) {
        Node newNode = new Node(value);

        if (head == null) { 
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void insertAtTail(int value) {
        Node newNode = new Node(value);

        if (tail == null) { 
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }


    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;


        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value " + value + " not found!");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; 
            return;
        }

        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

  
    public void reverse() {
        if (head == null || head.next == null) return;

        Node current = head;
        Node temp = null;

        while (current != null) {
          
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev; 
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        System.out.print("Doubly Linked List: ");
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Q4 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtTail(30);
        list.insertAtTail(40);

        list.printList();

        list.deleteByValue(20);
        list.printList();

        list.deleteByValue(40);
        list.printList();

        System.out.println("Reversing list...");
        list.reverse();
        list.printList();
    }
}
