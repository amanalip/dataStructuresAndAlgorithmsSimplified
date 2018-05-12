//We need to keep track of the three main things. The data, head node and tail node.

public class linkedList { // class of the file
    class Node { // class of the node
        int value; //data value
        Node next = null; // next node is always null
        Node(int value) { // default: constructor
            this.value = value // initialises the data value
        }
    }
    protected Node head = null; // protected node value because it is sensitive
    protected Node tail = null;

    public void addToFront(int value) // here we are creating a new function/ method to
    {
        Node newNode = new Node(value); // create a new node here and add the value
        newNode.next = head; /* next node/ pointer of this new node is pointed towards head pointer which was initially alloted to 
        either null or the the first element*/
        head = newNode; /*since we are adding the node at the beginning the head pointer is now 
        updated to the address of the new node.*/
        if (newNode.next == null) { /* this is in a case if there are no elements in the linkedList initially. 
            so this will  allot the tail also to the new node.*/
            tail = newNode;
        }
    }
    public void addToBack(int value) { // In this method we add the new value in the end of the linkedList
        Node newNode = new Node(value); // creating a new value.
        if (tail == null) { // if it is an empty linked list then we redirect head to the address of the new node.
            head = newNode;
        } else {
            tail.next = newNode; //otherwise we point the tail to the newNode.
        }
        tail = newNode; // new node is now updated as the new tail.
    }
    public void addAtIndex(int index, int value) { // this method is meant to add a new value at a particular index.
        if (index < 0) { // exception handling if the index value is less than zero
            throw new IndexOutOfBoundsException();
        } else if (index == 0) { // adding to head
            addToFront(value);
        } else {
            Node newNode = new Node(value); // creating a new node for the data that we need to input
            Node current = head; // creating a new node and equating it to head.
            for (int i = 0; i < index - 1; i++) {
                if (current == null) {
                    throw new IndexOutOfBoundsException();
                }
                current = current.next; // updating the value of the current node
            }
            if (current.next == null) { // adding to tail
                tail.next = newNode
                tail = newNode;
            } else {
                newNode.next = current.next; /* this current node now points at the next node.
                but now the added value should point at the next node. hence, newNode.next is now equal to the current.next.*/
                
                current.next = newNode; // current.next is now appended to the newly added block
            }
        }
    }
    public boolean contains(int value) { /*this method basically checks if a particular value exists in the linked list or not.
        Hence the return type is boolean*/
       
        Node current = head; // creating a node current and initialising it to the head pointer/node
        while (current != null) { // traversing the current node til it hits an empty node(null)
            if (current.value == value) { /* if the value of the current node is equal to the value that is asked, 
                then it returns true. which means that the value exists in the list*/
                
                return true;
            }
            current = current.next; // move the current node to the next node
        }
        return false; // return false current has traversed and didn't find any value. !!
    }

    public int getByIndex(int index) { /* In this method we will try to get the value of the element
    of a node with the help of its index. We give the input as the index of the node*/
        
        if (index < 0) { // if the input is negative then, it will throw an inbulit exception.
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head; // assign the head node to the current node.
            for (int i = 0; i < index; i++) {
                if (current == null || current.next == null) {
                    throw new IndexOutOfBoundsException(); /* if the current node traverses til the end and 
                    doesn't get the index mentioned. then it will throw an exception.
                    For example, if we search index 7 in a 4 data linked list.*/
                
                }
                current = current.next; // update the node.
            }
            return current.value; //return the value at that node.
            // Note: in an array we can directly access the index but in a linked list we have to traverse through the list.
        }
    }

    public void removeFromFront() { // this method removes the value from front/beginning of the linked list
        if (head != null) { // we need to update the head node to the next value. by this the first node will point nowhere.
            head = head.next;
        }
        if (head == null) { // if head is null which means even tail has to be null.
            tail = null;
        }
    }
    public void removeFromBack() { // we have to remove a node from the rear end of this linked list.
        if (head == null) { // empty list
            return;
        } else if (head == tail) { // single element list, update the tail and head to null
            head = null;
            tail = null;
        } else {
            Node current = head; /* we create a new node for traversal and we initailise that to head.
            we will now travel till the next node is tail. we will allocate tail to the previous node and 
            update the next node to null. thus, removing the last element.*/
           
            
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            current.next = null;
        }
    }
    public void removeAtIndex(int index) { // we remove an element at the specified index. 
        if (index < 0) { // if the index is negative, then we throw an inbulit exception
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            removeFromFront(); /*if the index is zero, which means we have to remove the first element.
            hence we call the previous function*/
       
        } else {
            Node current = head; // we create a new node for traversal
            for (int i = 0; i < index - 1; i++) { // we traverse til the respective index. 
                if (current == null || current.next == null) { // if we do not get the required index then we will throw and exception.
                    throw new IndexOutOfBoundsException();
                }
                current = current.next; // update the node
            }
            if (current.next == null) {
                throw new IndexOutOfBoundsException();
            }
            current.next = current.next.next; /* we skip the node we need to remove and direct its
            previous node to the next node available. */
            if (current.next == null) { // if the index node itself is the last node, then we simply assign it to the current node. 
                tail = current;
            }
        }
    }
