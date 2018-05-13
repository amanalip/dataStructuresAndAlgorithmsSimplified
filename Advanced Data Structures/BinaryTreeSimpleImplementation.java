/*Binary tree is a type of tree data structure. The topmost node is called a root, and the other nodes are parent node and its 
respective left child node and right child node. This file just has the simple implementation of the binary tree.*/


public class BinaryTreeSimpleImplementation {
    class Node {
        int value; //the data that needs to be given.
        Node leftChild = null;// initialising the values of left and right child to null.
        Node rightChild = null;
        Node(int value) {
            this.value = value; // adding the value to the respective node.
        }
    }
    protected Node root = null; // initialising root to null
  
}
