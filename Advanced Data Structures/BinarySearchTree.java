

/*Binary tree is a type of tree data structure.In a Binary tree, elements are added in a sorted order. The topmost node is called a root.
and the other nodes are parent node and child node. The value of the left child  is always smaller than the parent. The value of the
right child is always greater than the parent node. This file just has the simple implementation of the binary tree. Binary tree intends
solve the "preserving the order of data entry" problem.*/

public class BinarySearchTree {
    class Node {
        int value;
        Node leftChild = null;
        Node rightChild = null;
        Node(int value) {
            this.value = value;
        }
    }
    protected Node root = null;
    public void inorderTraversal(Node n) {
        if (n == null) return;
        inorderTraversal(n.leftChild);
        visit(n);
        inorderTraversal(n.rightChild);
    }
    public void visit(Node n) {
        System.out.println(n.value);
    }
}
