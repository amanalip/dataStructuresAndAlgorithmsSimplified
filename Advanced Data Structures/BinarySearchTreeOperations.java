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
updated here.

When a node is removed from a Binary Search Tree, it must be  replaced with the largest value in its left subtree*/
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
    
    public boolean remove(Node n, Node parent, int val) { /*This method removes a value(val). n stands for the node we are 
    looking at. parent stands for the current subtree's parent node*/
    if (n == null) return false; // if the node doesn't exist. return false
    if (val < n.value) { //if the current node value is greater than the value to be removed, recursively look into left subtree.
        return remove(n.leftChild, n, val);
    } else if (val > n.value) {
        return remove(n.rightChild, n, val);/*if the current node value is greater than the value to be 
        removed, recursively look into left subtree.*/
    } else { // we enter this segment if we have found the value
        if (n.leftChild != null && n.rightChild != null) { // if the node to be removed has non-null left child and right child
            n.value = maxValue(n.leftChild); /*take the maximum value of the left subtree and replace it to the place where
            the previous node is removed*/
            remove(n.leftChild, n, n.value); /*after replacing, remove the replacement's previous location*/
        } else if (parent.leftChild == n) { // this is case in which either of the child is null
            parent.leftChild = (n.leftChild != null) ? n.leftChild : n.rightChild; /* if the left child is not null, then we will have
           then we will make it to the parent's left child. if it is null then we will make the right child to the parent's left child */
        } else {
            parent.rightChild = (n.leftChild != null) ? n.leftChild : n.rightChild; /*if we are looking in the right subtree, then if 
            the left child is not null, then we will have then we will make it to the parent's right child. 
            if it is null then we will make the right child to the parent's right child*/
        }
        return true; /*termination of program*/
    }
}
}
