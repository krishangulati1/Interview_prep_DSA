package DataStructures.LinkedList;

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
        if(head == null){
            head = node;
            return;
        }

        Node curr = head;
        while(curr.next != null) curr = curr.next;

        size++;
        curr.next = node;
    }

    void printLinkedList() {
        Node curr = head;
        System.out.println("Printing DataStructures.LinkedList.LinkedList.LinkedList.DataStructures.LinkedList.LinkedList.LinkedList -");
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
                size--;
                return;
            }
            curr = curr.next;
        }

    }


    public int getSize() {
        return size;
    }

}

/*
class LLMain {
    // this is for basic DataStructures.LinkedList.LinkedList.LinkedList
    public static void main(String []args) {
        DataStructures.LinkedList.LinkedList.LinkedList ll = new DataStructures.LinkedList.LinkedList.LinkedList();
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
}*/
