package LinkedList;

public class LinkedList {

    Node head = null;
    int size = 0;

    void insertAtHead(int data) {
        Node node = new Node(data);
        node.next= head;
        head=node;
    }

    void instertAtTail(int data) {
        Node node = new Node(data);

        if(head == null) head = node;
        Node curr = head;

        while(curr.next != null) curr = curr.next;

        size++;
        curr.next = node;
    }

    void printLinkedList() {
        Node curr = head;
        System.out.println("Printing LinkedList.LinkedList -");
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    void deleteByValue(int data) {
        if (head == null) return;
        if(head.data == data) head = head.next;
        Node curr = head;

        while(curr.next != null) {
            if(curr.next.data == data) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }

    }


    public int getSize() {
        return size;
    }

}

class Node {
    int data;
    Node next;

    public Node (int data) {
        this.data = data;
        this.next = null;
    }
}

class LLMain {
    public static void main(String []args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(1);
        ll.insertAtHead(2);
        ll.insertAtHead(3);
        ll.insertAtHead(4);
        ll.insertAtHead(5);
        ll.insertAtHead(6);
        // delete operation
        ll.deleteByValue(6);

        ll.printLinkedList();
    }
}