/*
Note:For further operations on binary tree, look into the file "BinarySearchTreeOperations.java" in the current directory.
Theory:
1) Binary search tree is an extension of binary tree data structure.
2) In a Binary search tree, elements are added in a sorted order. Binary tree intends solve the "preserving the order of data entry"
problem.
3) The value of the left child  is always smaller than the parent. The value of the right child is always greater than the parent node.
4) Left subtree is always smaller than the right subtree with respect to a node.

Note: This file has to updated with preorder and post order traversals.
*/
public class BinarySearchTree { 
    class Node {
        int value; //the data that needs to be given.
        Node leftChild = null; // initialising the values of left and right child to null.
        Node rightChild = null; 
        Node(int value) {
            this.value = value;  // adding the value to the respective node.
        }
    }
    protected Node root = null; // initialising root to null
    
    /*Explaination for the following method:
    --Inorder traversal is the way in which we can retrive the element in a sorted order.
    --By the theory of Binary Search tree, the left node is smaller than the parent node and the right node is greater than the parent         
      node. To get the element in the sorted order, we need to first visit the left child, then the parent node and then the right node.
    --The method uses the concept of recursive programming. By recursive programming, I mean the function calls itself til the time
      it is done visiting all the nodes. The advantage of recursive programming paradigm here is that we need not worry about the total
      number of nodes that are there in the tree.
    -- Now observe the single line comments that I have added in the following piece of code. Let us now explore the method:
                Line 1: The method begins. The input parameter is a node. 
                Line 2: If there is no node at that location, return terminate the method.
                Line 3: Now we recursively call the method. We first access the left child of the node till the time all the left 
                        children are visited. But here exists a general confusion! We need to also consider the possibility
                        that a sub-left child might be a parent node to another set of children. So as and when a Left child is 
                        visited we explore its left child and right child. You can visualise it as a way to get to the bottom of the 
                        tree til all the sub trees are visited.
                Line 4: Whenever a node is visited, a function call goes to visit method( Line 6), and the node value is printed out.
                Line 5: A recursive method to visit the right child.
                Line 6: This line prints the value to the console.
                
      -- The general progression of the method is :
                    left child ---> Parent -----> right child. 
                    i.e, First all the left children's value are printed out. Then the parent's value is printed out. And then the 
                    right children values in printed out. 
      -- This is how the values are retrived in sorted order.
    */
    public void inorderTraversal(Node n) { // Line 1
        if (n == null) return; //Line 2
        inorderTraversal(n.leftChild); // Line 3
        visit(n);//line 4
        inorderTraversal(n.rightChild);// line 5
    }
    public void visit(Node n) {
        System.out.println(n.value); // line 6
    }
}
