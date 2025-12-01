// Write a class to implement a circular linked list with methods to insert an element at the head, insert an element at the tail, delete an element by value, and traverse the list to print all elements

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;


    public void insertAtHead(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode; 
        head = newNode;     
    }


    public void insertAtTail(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head; 
    }

    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        Node prev = null;

        if (head.data == value) {
         
            if (head.next == head) {
                head = null;
                return;
            }

            Node last = head;
            while (last.next != head) {
                last = last.next;
            }

            last.next = head.next; 
            head = head.next;      
            return;
        }

        do {
            prev = temp;
            temp = temp.next;

            if (temp.data == value) {
                prev.next = temp.next;
                return;
            }
        } while (temp != head);

        System.out.println("Value " + value + " not found!");
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        System.out.print("Circular Linked List: ");

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }
}

public class Q3 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        System.out.println("RASHI YADAV "); 
        System.out.println("2401350003 ");

        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtTail(30);
        list.insertAtTail(40);

        list.traverse();

        list.deleteByValue(20);
        list.traverse();

        list.deleteByValue(40);
        list.traverse();
    }
}
