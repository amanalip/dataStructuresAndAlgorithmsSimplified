// we use linked list to implement queues. We need to have track of the front/first node and the last/tail node.


import java.util.LinkedList; // We implement queues using the linkedlist class implementation
public class Queue {
    protected LinkedList list = new LinkedList(); // creating a new list. 
    public void add(Object value) { // in a queue we need to add a value to the end
        list.add(value); // adds to end
    }
    public Object remove() {
        if (list.isEmpty()){ // if the queue is empty then we have to return the null object
            
            return null;
        }
        return list.removeFirst(); // by the defination of queue we will remove the first node
    }
}
