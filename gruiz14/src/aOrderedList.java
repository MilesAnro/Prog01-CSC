import java.util.Arrays;
import java.util.NoSuchElementException;
/**
* Represent an ordered list of elements
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author God Miles Anro Ruiz
* @since 03/17/2024
*
*/
class aOrderedList<T extends Comparable<T>> {
    final int SIZE_INCREMENTS = 20;	//size of increments for increasing ordered list
    private T[] oList;				//the ordered list
    private int listSize;			//the size of the ordered list
    private int numObjects;			//the number of objects in the ordered list
    private int curr; 				//iterator current position

     /**
     * Constructor
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public aOrderedList() {
        this.oList = (T[]) new Car[listSize]; //Initialized the ordered list with initialize size
        this.listSize = SIZE_INCREMENTS; //Set the initial list size
        this.numObjects = 0; //Initialize the number of objects in the list
    }

     /**
     * Add a new element to the ordered list
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public void add(T newCar) {
        if (numObjects == oList.length) {
            oList = Arrays.copyOf(oList, oList.length + SIZE_INCREMENTS); //Increase the size, if needed
        }
  
        int index = 0; //Initialized the index for inserting the new element
        while (index < numObjects && oList[index].compareTo(newCar) < 0) {
            index++;
        }
        //Shifts elements to make space for the new element
        System.arraycopy(oList, index, oList, index + 1, numObjects - index);
        oList[index] = newCar;
        numObjects++;
    }
    
     /**
     * Returns the element at the specialized position in the list
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public T get(int index) {
        if (index < 0 || index >= numObjects) {
        	throw new IndexOutOfBoundsException("Index is out of bounds");
        } else {
            return oList[index];
        }
    }
    
     /**
     * Returns the number of elements in this list
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public int size() {
        return numObjects;
    }
    
     /**
     * Returns true if the array is empty and false otherwise
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public boolean isEmpty() {
        return numObjects == 0;
    }
    
    /**
     * Returns true if there are more elements to iterate over
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public boolean hasNext() { 
    	return curr < numObjects; }
    
     /**
     * Returns the next element in the iteration 
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public T next() {
        if (!hasNext()) {
        	throw new NoSuchElementException("No more elements.");
        }
        return oList[curr++];
    }

   
     /**
     * Removes the element at the specified position in this list
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public void remove(int index) {
        if (index < 0 || index >= numObjects) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
       for (int i = index; i < numObjects -1; i++) {
    	   oList[i] = oList[i+1];
       }
       numObjects--;
    }
    
     /**
     * Removes the last element returned by the iterator
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public void remove() {
        if (curr <= 0) {
            throw new IllegalStateException("last iteration removed");
        }
        this.remove(--curr);
    }
    
    
     /**
     * Returns a string representation of the ordered list
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numObjects; i++) {
            sb.append(oList[i]);
            if (i < numObjects - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
     /**
     * Resets the iterator to the beginning of the list
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public void reset(){
    	curr = 0; 
    	}

}
