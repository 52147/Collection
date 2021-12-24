package collectionapi;

/**
 * = the Collections class =
 * 
 * - Although we will not make use of the Collections class, it has 2 methods that are
 *   thematic of how generic algorithm for the Collections API are written.
 * - We write these methods in the Collections class implementation.
 * 
 *  
 *  - begins by illustrating the common technique of declaring a private constructor in classes
 *    that contain only static methods.
 *  - This prevents instantiation of the class.
 *  
 *  - It continues by providing the reverseOrder method.
 *  - This is a factory method that returns a Comparator that provides the 
 *    reverse of the natural ordering for Comparable objects.
 *  - The returned object is an instance of the ReverseComparator class.
 *  - In the ReverseComparator class, we use the compareTo method.
 *  - This is an example of the type of code that might be implemented with an anonymous class.
 *  
 *    
 *  max()
 *  - max method returns the largest elements in any collection.
 *  - The one-parameter max calls the two-parameter max by supplying the default comparator.
 *  
 *  - The funky syntax in the type parameter list is used to ensure that the type
 *    ensure of max generates Object(rather than Comparable).
 *  - This is important because earlier versions of Java used Object as the return type,
 *    and we want to ensure backward compatability.
 *    
 *  - The two-parameter max combines the iterator pattern with the function object pattern
 *    to step through the collection,
 *    and calls to the function object to update the maximum item.
 *    
 */

/**
 * 
 * Instanceless class contains static methods that operate on collections.
 *
 */
public class Collections {

	// private constructor
	private Collections() {
	}

	/**
	 * Returns a comparator that imposes the reverse of the default ordering on a
	 * collection of objects that implement the Comparable interface.
	 * 
	 * @return the comparator
	 */
	public static <AnyType> Comparator<AnyType> reverseOrder() {
		return new ReverseComparator<AnyType>();
	}

	public static class ReverseComparator<AnyType> implements Comparator<AnyType> {
		public int compare(AnyType lhs, AnyType rhs) {
			return -(((Comparable) lhs).compareTo(rhs));
		}
	}

	static class DefaultComparator<AnyType extends Comparable<? super AnyType>> implements Comparator<AnyType> {

		@Override
		public int compare(AnyType lhs, AnyType rhs) {

			return lhs.compareTo(rhs);
		}

	}

	/**
	 * Returns the maximum object in the collection, using default ordering.
	 * 
	 * @param coll the collection.
	 * @return the maximum object.
	 * @throws NoSuchElementException if coll is empty.
	 * @throws ClassCasrException     if objects in collection cannot be compared.
	 */
	public static <AnyType extends Object & Comparable<? super AnyType>> AnyType max(
			Collection<? extends AnyType> coll) {
		return max(coll, new DefaultComparator<AnyType>());
	}

	/**
	 * Return the maximum object in the collection.
	 * 
	 * @param coll the collection.
	 * @param cmp  the comparator.
	 * @return the maximum object.
	 * @throws NoSuchElementException if coll is empty
	 * @throws ClassCastException     if objects in collection cannot be compared.
	 */
	public static <AnyType> AnyType max(Collection<? extends AnyType> coll, Comparator<? super AnyType> cmp) {
		if (coll.size() == 0)
			throw new NoSuchElementException("No such element!");

		Iterator<? extends AnyType> itr = coll.iterator();
		AnyType maxValue = itr.next();

		while (itr.hasNext()) {
			AnyType current = itr.next();
			if (cmp.compare(current, maxValue) > 0)
				maxValue = current;
		}
		return maxValue;
	}

}
