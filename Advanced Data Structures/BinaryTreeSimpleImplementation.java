/*In a Binary tree, elements are added in a sorted order. The topmost node is called a root. and the other nodes are parent node and
child node. The value of the left child  is always smaller than the parent. The value of the right child is always greater than the
parent node. This file just has the simple implementation of the binary tree.*/


public class BinaryTree {
    class Node {
        int value; //the data that needs to be given.
        Node leftChild = null;// initialising the values of left and right child to null.
        Node rightChild = null;
        Node(int value) {
            this.value = value; 
        }
    }
    protected Node root = null; // initialising root to null
  
}
