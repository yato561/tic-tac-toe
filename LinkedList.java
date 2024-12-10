// Node class
class Node {
    int data;
    Node next;

    // Constructor to initialize node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class
class LinkedList {
    Node head;

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to delete a node by key
    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Key not found");
            return;
        }
        prev.next = temp.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        System.out.println("Linked List:");
        list.display();

        list.delete(20);
        System.out.println("After deleting 20:");
        list.display();
    }
}
