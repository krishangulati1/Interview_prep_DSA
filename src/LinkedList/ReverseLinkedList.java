package LinkedList;

public class ReverseLinkedList {
    static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;  // save next
            curr.next = prev;       // reverse pointer
            prev = curr;            // move prev forward
            curr = next;            // move curr forward
        }
        return prev;
    }
    // [1]→[2]→[3]→null  becomes  null←[1]←[2]←[3]

    public static void main(String []args){
        LinkedList ll = new LinkedList();
        ll.instertAtTail(1);
        ll.instertAtTail(2);
        ll.instertAtTail(3);
        ll.instertAtTail(4);

        //Update the value of the head after reversal
        ll.head = reverseLinkedList(ll.head);
        ll.printLinkedList();

    }
}
