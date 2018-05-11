/*In the file HashSet.java, we will have a exception/error if another value of the same length/hash value goes to a place where another 
value exists. To solve this issue we will create an array of linkedList. Also known as Ragged Array(A two dimensional array with variable row lengths).
*/
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
    public boolean add(String value) {// in this method we add a value to the hashset.
        if (!contains(value)) { //sets don't allow repetition of values.
            int index = hashCode(value) % buckets.length; // finding the index of the hashcode. 
            LinkedList < String > bucket = buckets[index]; // we locate the index in the memory, we use it to get the appropriate linked list.
            bucket.addFirst(value); // we add the value at the front of that particular linked list
            return true;
        }
        return false; // if the value already exists then we return false indicating that the value was already there in the set.
    }
    

}
