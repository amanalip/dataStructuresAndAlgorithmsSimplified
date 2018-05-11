/* Stacks are implemented using linked list. we need only one pointer at the beginning of the list.
*/



import java.util.LinkedList; // we import the linked list class
public class Stack {
    protected LinkedList list = new LinkedList();// we create a linked list object
    public void push(Object value) { // by Push we mean that we have to add the value at the top of the stack. 
        list.addFirst(value); // we use the inbuilt method to add the value on the top of the stack.
    }
    public Object pop() {
        if (list.isEmpty()) // if the list is empty then return the null object.
            return null;
        return list.removeFirst();
    }
    public Object peek() { // peek is a function that just looks at the available value on top and returns it value. 
        return list.getFirst();
    }
}
