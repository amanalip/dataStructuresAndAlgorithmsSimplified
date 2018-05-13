/*
1) Binary search tree is an extension of binary tree data structure.
2) In a Binary search tree, elements are added in a sorted order. Binary tree intends solve the "preserving the order of data entry"
problem.
3) The value of the left child  is always smaller than the parent. The value of the right child is always greater than the parent node.

Note: This file has to updated with preorder and post order traversals.
*/
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
