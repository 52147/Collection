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
 *   remove() 
 *   
 *   - One difficulty with the ListIterator is that the semantics for remove must change slightly.
 *   - The new semantics are that remove deletes from the List the last object returned
 *     as a result of calling either next or previous,
 *     and remove can only between calls to either next or previous.
 *   
 *   - To override the javadoc output that is generated for remove,
 *     remove is listed in the ListIterator interface.
 *   
 *   
 * - This interface is only a partial interface.
 * - There are some additional methods in the ListIterator that we do not discuss in the text,
 *   but which are used throughout as exercises.
 * - These methods include add and set,
 *   which allow the user to make changes to the List at the current location held by the iterator.
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
	 * Can only be called once after next or previous.
	 */
	void remove();

}
