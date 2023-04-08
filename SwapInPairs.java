package swe.LinkedList;

public class SwapInPairs {
    public Node swapPairs(Node head) {
        // 1 -> 2 -> 3 -> 4 -> x
        if (head == null || head.next == null) {
            return head;
        }

        Node dummyNode = new Node(0);
        dummyNode.next = head; // 0 -> 1 -> 2 -> 3 -> 4 -> x
        Node previousNode = dummyNode; // previousNode = 0

        while (head != null && head.next != null) {
            Node first = head; // first = 1
            Node second = head.next; // second = 2

            first.next = second.next;
            second.next = first;

            previousNode = first;
            previousNode.next = second;

            head = first.next;

        }
        return dummyNode.next;
        // Output : 2 -> 1 -> 4 -> 3 -> x
    }
}
