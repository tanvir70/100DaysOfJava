package swe.Tree;

class ListTreeNode {
    int val;
    ListTreeNode left;
    ListTreeNode right;
    ListTreeNode next;

    public ListTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}

public class PopulateLevelPointers {
    public ListTreeNode connect(ListTreeNode root) {
        if (root == null) {
            return null;
        }
        ListTreeNode currentNode = root;
        while (currentNode.left != null) {
            ListTreeNode level = currentNode;
            while (level != null) {
                level.left.next = level.right;
                if (level.next != null) {
                    level.right.next = level.next.left;
                }
                level = level.next;
            }
            currentNode = currentNode.left;
        }
        return root;
    }

    public static void main(String[] args) {
        ListTreeNode root = new ListTreeNode(1);
        root.left = new ListTreeNode(2);
        root.right = new ListTreeNode(3);
        root.left.left = new ListTreeNode(4);
        root.left.right = new ListTreeNode(5);
        root.right.left = new ListTreeNode(6);
        root.right.right = new ListTreeNode(7);

        PopulateLevelPointers plp = new PopulateLevelPointers();
        ListTreeNode result = plp.connect(root);

        ListTreeNode current = result;
        while (current != null) {
            ListTreeNode level = current;
            while (level != null) {
                System.out.print(level.val + " -> ");
                level = level.next;
            }
            System.out.println("x");
            current = current.left;
        }
    }
}
/*
Output :
1 -> x
2 -> 3 -> x
4 -> 5 -> 6 -> 7 -> x
 */