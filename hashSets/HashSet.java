// we will implement hashsets in this file
// this is a very naive implementaions. please find another file (HashSetWithSeparateChaining.java) in the same directory for a more sophisticated implementaions.
public class HashSet { // we are creating a classs of hashset.

    private String[] values; // here we are declaring a array of strings.
    private int hashCode(String value) { // this is a method to convert the input data into a hash. This is the hash function. It calculates the hash by calculating the length of the string. for example hash for for aman is "4".
        return value.length();
    }

    public boolean add(String value) { // this method adds the string into the set
        int index = hashCode(value) % values.length; // it first generates its hash code. we do modulo operation so that the index is always in the limits and we do not have an out of bounds issue.
        if (values[index] == null) { // value will be added only if the index is empty. If there is already a value in the index, the it would return false
            values[index] = value;
            return true;
        }
        return false;
    }
    
    public boolean contains(String value) { // this method checks if a value exists in the set.
        int index = hashCode(value) % values.length; // calculates the index of the value
        return value.equals(values[index]);// checks if the value exists by comparing the parameter passed with the value in the set with the help of .equals() string method.
    }

}
