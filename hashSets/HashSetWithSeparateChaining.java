/*In the file HashSet.java, we will have a exception/error if another value of the same length/hash value goes to a place where another 
value exists. To solve this issue we will create an array of linkedList. Also known as Ragged Array(A two dimensional array with variable row lengths).
There is one flaw in this program. That is, what if a particular index has more and more values coming. Then that particular index will grow beyond measure. If an index grows
beyond measure, then searching a value in that increases in its time complexity and we will lose the initial benefits we had of creating a hash set.
The solution to this problem is to resize the length of the hashset automatically to make the whole hashset. Now we can reduce the length of each index in the hashset.
Please find the file "HashSetsWithSelfResizing.java" in the current directory. */
public class HashSetWithSeparateChaining {

    private LinkedList < String > [] buckets; // String Array of linked lists
    public HashSet(int size) { // default constructor
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList < String > (); // each place holder is initialised as a linked list. 
        }
    }
    private int hashCode(String value) { // this method calculates the hashcode. 
        return value.length();
    }
    public boolean add(String value) { // in this method we add a value to the hashset.
        if (!contains(value)) { //sets don't allow repetition of values.
            int index = hashCode(value) % buckets.length; // finding the index of the hashcode. 
            LinkedList < String > bucket = buckets[index]; // we locate the index in the memory, we use it to get the appropriate linked list. Now we assign this linked list's memory location to a dummy variable bucket.
            bucket.addFirst(value); // we add the value at the front of that particular linked list
            return true;
        }
        return false; // if the value already exists then we return false indicating that the value was already there in the set.
    }
    
    public boolean contains(String value) { // this methods checks if the set already contains a value or not.
        int index = hashCode(value) % buckets.length; // getting the index
        LinkedList < String > bucket = buckets[index]; // reaching out to the particular linked list and then assigning that value to a dummy variable bucket.  
        return bucket.contains(value);// if this dummy variable contains the value, we will return true. otherwise false. 
    }


}
