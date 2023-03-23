package HundredDaysOfJava;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class RemoveDuplicateLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previousNode = dummy;
        ListNode currentNode = head;
        while (currentNode != null) {
            int count = 0;
            while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                count++;
                currentNode = currentNode.next;
            }
            if (count == 0) {
                previousNode = currentNode;
            } else {
                previousNode.next = currentNode.next;
            }
            currentNode = currentNode.next;
        }
        return dummy.next;
    }

}
