package collectionapi;
/**
 * = The List interface =
 * 
 * - The list is a collection of items in which the items have a position.
 * - The most obvious example of a list is an array.
 * - In an array, items are placed in position 0,1,etc.
 * 
 * - The List interface extends the Collection interface and abstracts the notion of a position.
 * - The interface in java.util adds numerous methods to the Collection interface.
 * - We are content to add the three methods in this program.
 * 
 *   get()
 *   set()
 *   iterator()
 * - The first 2 methods are get and set, which are similar to the methods that we have seen in ArrayList.
 * - The third method returns a more flexible iterator, the ListIterator.
 * 
 * - 
 * 
 *
 */

/**
 * List interface. Contains much less than java.util
 *
 */
public interface List<AnyType> extends Collection<AnyType>{
	
	AnyType get(int idx);
	AnyType set(int idx, AnyType newVal);
	
	/**
	 * Obtains a ListIterator object used to traverse 
	 * the collection bidirectionally.
	 * 
	 * @return an iterator positioned
	 *         prior to the requested element.
	 * @param pos the index to start the iterator.
	 *        Use size() to do complete reverse
	 *        Use 0 to do complete forward traversal.
	 * @throws IndexOutBoundsException if pos is not between 0 and size(), inclusive.               
	 *         
	 */
	ListIterator<AnyType> listIteraor(int pos);	
	

}
