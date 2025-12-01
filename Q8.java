// Create a circular queue using array with methods for enqueue, dequeue, and checking if the queue is empty or full. Ensure that the circular nature of the queue is maintained after each operation

class CircularQueue {
    int[] arr;
    int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is Full! Cannot enqueue " + value);
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = value;

        if (front == -1) { 
            front = 0;
        }

        size++;
        System.out.println(value + " enqueued.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! Nothing to dequeue.");
            return -1;
        }

        int value = arr[front];
        front = (front + 1) % capacity;
        size--;

        if (size == 0) {
            front = rear = -1;
        }

        return value;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Circular Queue: ");

        int index = front;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[index] + " ");
            index = (index + 1) % capacity;
        }

        System.out.println();
    }
}

public class Q8 {
    public static void main(String[] args) {

        System.out.println("RASHI YADAV "); 
        System.out.println("2401350003 ");

        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        q.enqueue(50);
        q.enqueue(60); 
        q.display();

        q.enqueue(70); 
    }
}

