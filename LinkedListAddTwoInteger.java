package swe.LinkedList;

public class LinkedListAddTwoInteger {
    public Node addTwoNumber(Node one, Node two) {

        Node dummyHead = new Node(0);
        Node outputList = dummyHead;
        int carry = 0;

        while (one != null || two != null) {

            int numberOne = (one != null) ? one.data : 0;
            int numberTwo = (two != null) ? two.data : 0;

            int sum = carry + numberTwo + numberOne;
            carry = sum / 10;
            outputList.next = new Node(sum % 10);

            if (one != null) {
                one = one.next;
            }
            if (two != null) {
                two = two.next;
            }
            outputList = outputList.next;
        }
        if (carry > 0) {
            outputList.next = new Node(carry);
        }
        return dummyHead.next;
    }
}
