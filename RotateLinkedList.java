package swe.LinkedList;

public class RotateLinkedList {
    public Node rotateRight(Node head, int k) {
        //Input : 1 -> 2 -> 3 -> 4 -> X , k = 2
        if (head == null) {
            return head;
        }
        Node tail = head;
        int sizeOfTheList = 1;
        while (tail.next != null) {
            tail = tail.next;
            sizeOfTheList++;
        }
        k = k % sizeOfTheList;
        if (k == 0) {
            return head;
        }
        tail.next = head;

        int newTailIndex = sizeOfTheList - k;
        Node rotatedNewTail = tail;
        while (newTailIndex > 0) {
            rotatedNewTail = rotatedNewTail.next;
            newTailIndex--;
        }
        Node rotatedNewHead = rotatedNewTail.next;
        rotatedNewTail.next = null;

        return rotatedNewHead;
        //Output: 3 -> 4 -> 1 -> 2 -> X
    }
}
