package swe.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class TestForCycle {
    public Boolean hasCycle(Node head) {
        Set<Node> seen = new HashSet<>();
        Node currentNode = head;
        while (currentNode.next != null) {
            if (seen.contains(currentNode)) {
                return true;
            }
            seen.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }
}
