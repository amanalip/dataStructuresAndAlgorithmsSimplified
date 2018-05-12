public class HashSetsWithSelfResizing {
    private String[] values; // here we are declaring a array of strings.
    private int hashCode(String value) { /* this is a method to convert the input data into a hash. 
        This is the hash function. It calculates the hash by calculating the length of the string. 
            for example hash for for aman is "4".*/
        
        return value.length();
    }
    private int currentSize = 0;
    private double loadFactor; /* loadfactor should be greater than currentsize/length of the hash set. 
    if this inequality changes, we increase the length of the hashset so that we can again increase the efficiency of searching.*/

    public boolean add(String value) {
        if (!contains(value)) {
            int index = hashCode(value) % buckets.length;
            LinkedList < String > bucket = buckets[index];
            bucket.addFirst(value);
            currentSize++; //increase the variable that keeps track of the total number of inputs/values
            double averageLoad = currentSize / (double) buckets.length;
            if (averageLoad > loadFactor) {
                reinsertAll(); // if the inequality reverses then we have to reinsert everything in the modified hashset
            }
            return true;
        }
        return false;
    }
    private void reinsertAll() {
        LinkedList < String > oldBuckets[] = buckets; /* here we will store the value of the hashset into another hashset 
        for reference purposes*/
        buckets = new LinkedList[buckets.length * 2]; // now we will increase the size of the hashset by a factor 2.
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList < String > (); // initialise each index to a linked list
        }
        for (LinkedList < String > bucket: oldBuckets) { /* for each linkedlist in the old bucket, each element in that 
            linked list is selected.*/
          //new hashcode is calculated, and added to the hashset. now we have the new hashset.
            for (String element: bucket) {
                int index = hashCode(element) % buckets.length
                LinkedList < String > newBucket = buckets[index];
                newBucket.addFirst(element);
            }
        }
    }
}
