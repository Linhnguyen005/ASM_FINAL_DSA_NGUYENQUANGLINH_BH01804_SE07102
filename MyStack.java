package ASm;

public class MyStack {
    private Node top;

    public MyStack() {
        this.top = null;
    }

    public void push(Student data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public Student pop() {
        if (top == null) return null;

        Student data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
