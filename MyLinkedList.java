package ASm;

public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(Student data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean remove(String id) {
        if (head == null) return false;

        if (head.data.id.equals(id)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.data.id.equals(id)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public Node get(int index) {
        if (index < 0 || index >= size) return null;

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void bubbleSort() {
        if (head == null || head.next == null) return;

        for (int i = 0; i < size - 1; i++) {
            Node current = head;
            Node next = head.next;
            for (int j = 0; j < size - 1 - i; j++) {
                if (current.data.score > next.data.score) {
                    Student temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                current = next;
                next = next.next;
            }
        }
    }

    public void mergeSort() {
        head = mergeSort(head);
    }

    private Node mergeSort(Node node) {
        if (node == null || node.next == null) return node;

        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node dummy = new Node(null);
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.data.score <= right.data.score) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        tail.next = (left != null) ? left : right;
        return dummy.next;
    }

    private Node getMiddle(Node node) {
        if (node == null) return null;

        Node slow = node;
        Node fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node partition(Node start, Node end) {
        Node pivot = start;
        Node current = start;
        Node prev = start;

        while (current != end) {
            if (current.data.score < pivot.data.score) {
                prev = start;
                Student temp = start.data;
                start.data = current.data;
                current.data = temp;
                start = start.next;
            }
            current = current.next;
        }

        Student temp = pivot.data;
        pivot.data = start.data;
        start.data = temp;

        return prev;
    }
}
