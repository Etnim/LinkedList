package collections;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        this.head = null;
    }
    public void addNode(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }
    public void removeFirst(T data) {
        if (head == null) {
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void removeAll(T data) {
        if (head == null) {
            return;
        }
        Node<T> current = head;
        while (current != null && current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.addNode(1);
        intList.addNode(2);
        intList.addNode(3);

        System.out.println("Integer Linked List:");
        intList.printList();

        intList.removeFirst(2);
        System.out.println("After removing first occurrence of 2:");
        intList.printList();

        LinkedList<String> stringList = new LinkedList<>();
        stringList.addNode("banana");
        stringList.addNode("banana");
        stringList.addNode("apple");
        stringList.addNode("banana");
        stringList.addNode("apple");
        stringList.addNode("apple");


        System.out.println("String Linked List:");
        stringList.printList();

        stringList.removeAll("apple");
        System.out.println("After removing all occurrences of 'apple':");
        stringList.printList();
    }
}
