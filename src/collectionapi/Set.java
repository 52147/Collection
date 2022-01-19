package collectionapi;
/**
 * = sets =
 * 
 * - A set is a container that contains no duplicates.
 * - It supports all of the Collection methods.
 * - Most importantly, contains for a List is inefficient,
 *   regardless of whether the List is an ArrayList or LinkedList.
 * 
 * - A library implementation of Set is expected to efficiently support contains.
 * - Similarly, the Collection remove method (which has as a parameter a specified object, not a specified index)
 *   for a List is inefficient because it is implied that the first thing remove must do is to find the item being removed;
 *   essentially this makes remove at least as difficult as contains.
 *   
 * - For a Set, remove is expected to also be efficiently implemented.
 * - And finally, add is expected to have an efficient implementation.
 * - There is no Java syntax that can be used to specify that an operation must meet a time constraint or mat not contain duplicates;
 *   the code below illustrates that the Set interface does little more thatn declare a type.
 *   
 *   
 *
 */

/**
 * Set interface.
 *
 */
public interface Set<AnyType> extends Collection<AnyType> {
	
	/**
	 * Like contains, it checks if x is in the set.
	 * If it is, it returns the reference to the matching object; otherwise it returns null.
	 * @param x the object to search for.
	 * @return if contains(x) is false, the return value is null;
	 * otherwise, the return value is the object that causes contains(x) to return true.
	 */
	AnyType getMatch(AnyType x);

}
