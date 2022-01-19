package collectionapi;

/**
 * = Sorted Set =
 * 
 * - A SortedSet is a Set that maintains(internally) its items in sorted order.
 * - Objects that are added into the SortedSet must either be comparable,
 *   or a Comparator has to be provided when the container is instantiated.
 *   
 * - A SortedSet supports all of the Set method, but its iterator is guaranteed to step through items
 *   in its sorted order.
 * - The SortedSet also allows us to find the smallest and largest item.
 * - The interface for our subset of SortedSet in shown below.
 * 
 *
 */

/**
 * SortedSet interface.
 *
 */

public interface SortedSet<AnyType> extends Set<AnyType> {
	
	/**
	 * Return the comparator used by this SortedSet.
	 * @return the comparator or null if the default comparator is used.
	 */
	Comparator<? super AnyType> comparator();
	
	/**
	 * Find the smallest item in the set.
	 * @return the smallest item.
	 * @throws NoSuchElementException if the set is empty.
	 */
	AnyType first();
	
	/**
	 * Find the largest item in the set.
	 * @return the largest item.
	 * @throws NoSuchElementException if the set is empty
	 */
	AnyType last();

}
