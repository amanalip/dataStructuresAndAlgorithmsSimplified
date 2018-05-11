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
  
}
