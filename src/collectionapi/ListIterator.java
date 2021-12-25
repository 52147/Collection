package collectionapi;
/**
 * = the ListIterator interface = 
 * 
 * - ListIterator is just like an Iterator, except that it is bidirectional.
 * - Thus we can both advance and retreat.
 * 
 * - Because of this, the listIterator factory method that creates 
 *   it must be given a value that is logically equal to the number of elements that
 *   have already been visited in the forward direction.
 *   
 * - If this value is zero, the ListIterator is initialized at the front,
 *   just like an Iterator.   
 * - If this value is the size of the List, the iterator is initialized to have processed all 
 *   elements in the forward direction.
 * - Thus in this state, hasNext returns false,
 *   but we can use hasPrevious and previous to traverse the list in reverse.
 *    
 */

/**
 * 
 * ListIterator interface for List interface.
 *
 * @param <T>
 */
public interface ListIterator<AnyType> extends Iterator<AnyType>{
	
	/**
	 * Test if there are more items in the collection when iterating in reverse.
	 * @return true if there are more items in the collection when traversing in reverse.
	 */
	boolean hasPrevious();
	
	/**
	 * Obtains the previous items in the collection.
	 * @return the previous (as yet unseen) item in the collection when traversing in reverse.
	 */
	AnyType previous();
	
	/**
	 * Remove the last item returned by next or previous.
	 * Can only be called once after next ot previous.
	 */
	void remove();

}
