// Create a linear queue using an array with methods for enqueue, dequeue, and checking if the queue is empty or fuLL

class LinearQueue {
    int[] arr;
    int front, rear, size;

    public LinearQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + value);
            return;
        }

        if (front == -1) { 
            front = 0;
        }

        arr[++rear] = value;
        System.out.println(value + " enqueued.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Nothing to dequeue");
            return -1;
        }

        int value = arr[front++];

        if (front > rear) {
            front = rear = -1;
        }

        return value;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Q7 {
    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(5);

        System.out.println("RASHI YADAV "); 
        System.out.println("2401350003 ");

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.display();
    }
}
