package ASm;

public class MyQueue {
    private Node front, rear;

    public MyQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(Student data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Student dequeue() {
        if (front == null) return null;

        Student data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
