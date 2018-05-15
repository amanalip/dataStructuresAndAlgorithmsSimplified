public class BinarySearchTreeOperations {
    class Node {
        int value; //the data that needs to be given.
        Node leftChild = null; // initialising the values of left and right child to null.
        Node rightChild = null;
        Node(int value) {
            this.value = value; // adding the value to the respective node.
        }
    }
    protected Node root = null; // initialising root to null
    public void visit(Node n) {
        System.out.println(n.value); //This node prints the respective value
    }

    public boolean binaryTreeSearch(Node n, int val) { // method is meant for searching the value in a binary search tree.
        if (n == null) return false; // if no such node exists then return false
        if (n.value == val) { // return true if the such a value exists in the tree
            return true;
        } else if (n.value > val) {
            /* if the value is lesser than a node, recursively search in the left child.
                   since left children are smaller than the parent. this recursive call continues til the time we either
                   get a value. or we don't get it.*/
            return binaryTreeSearch(n.leftChild, val);
        } else {
            return binaryTreeSearch(n.rightChild, val);
            /* in this condition we will recursively call the function and search in the
                       right child of the tree. We search in the right child because the value to be searched is greater 
                       than the required value.*/
        }
    }
/* Note: Again the following method has recursion in it. I will explain recursion in detail in another file, and its path would be 
updated here.*/
    public boolean add(Node n, int val) { // this method adds the value. 
        if (n.value == val) { // if value already exists then no duplication allowed.
            return false;
        } else if (n.value > val) { //if the value is less than parent then add it to the left child.
            if (n.leftChild == null) {
                n.leftChild = new Node(val); // if left child/node doesn't exist create one
                return true;
            } else {
                return add(n.leftChild, val);// otherwise recursively add it to the left subtree
            }
        } else { 
            if (n.rightChild == null) { // if right child is null, create a new value
                n.rightChild = new Node(val);
                return true;
            } else {
                return add(n.rightChild, val); // recursively add to the new subtree
            }
        }
    }
}
