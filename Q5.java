// Implement a stack using arrays with methods for push, pop, and peek operations

class Stack {
    private int[] arr;
    private int top;
    private int size;


    public Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1; 
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to pop");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Q5 {
    public static void main(String[] args) {
        Stack s = new Stack(5);

        s.push(10);
        s.push(20);
        s.push(30);
        s.display();

        System.out.println("Peek element: " + s.peek());

        System.out.println("Popped: " + s.pop());
        s.display();

        s.push(40);
        s.push(50);
        s.push(60); 
        s.display();
    }
}
