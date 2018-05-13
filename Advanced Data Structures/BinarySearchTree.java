


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
