package swe.LinkedList;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class RemovekthFromLast {
    public Node remoreKth(Node head, int k) {
        Node dummyHead = new Node(-1);
        dummyHead.next = head;

        Node right = dummyHead.next;
        Node left = dummyHead;

        while (k > 0) {
            right = right.next;
            k--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummyHead.next;
    }
}
