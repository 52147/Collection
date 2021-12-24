package collectionapi;
/**
 * = Iterator interface =
 * 
 * - an iterator is an object that allows us to iterate through all object in a collection.
 * 
 * - The Iterator interface in the Collections API is small and contains only 3 methods:
 * 
 *   1. boolean hasNext()
 *      - Returns true if there are more items to view in this iteration.
 *      
 *   2. AnyType next()
 *      - Returns a reference to the next object not yet seen by this iterator.
 *      - The object becomes seen, and thus advances the iterator.
 *      
 *   3. void remove()
 *      - Removes the last item viewed by next.
 *      - This can be called only once between calls to next.
 * 
 *            
 *            
 *  - Each collection defines its own implementation of the Iterator interface,
 *    in a class that is invisible to users of the java.util package.
 *  
 *  Problem:
 *    
 *  - The iterators also expect a stable container.
 *  - An important problem that occurs in the design of containers and iterators is to
 *    decide what happens if the state of a container is modified 
 *    while an iteration is in progress.
 *    
 *  - The Collections API takes a strict view:
 *  
 *    Any external structural modification of the container(adds, removes, and so on)
 *    will result in a ConcurrentModificationException by the iterator methods 
 *    when one of the methods is called.
 *  - In other words, if we have an iterator, and then an object is added to the container,
 *    and then we invoke the next method on the iterator,
 *    the iterator will detect that it is now invalid,
 *    and an exception will be thrown by next.
 *  
 *  remove() in iterator class:
 *  
 *  - This means that it is impossible to remove an object from a container 
 *    when we have seen it via an iterator, without invalidating the iterator.
 *  - This is one reason why there is a remove method in the iterator class.
 *  - Calling the iterator remove causes the last seen object to be removed from the container.
 *  - It invalidates all other iterators that are viewing this container,
 *    but not the iterator that performed the remove.
 *    
 *  - It is also likely to be more efficient that the container's remove method,
 *    at least for some collections.
 *    
 *  - However, remove cannot be called twice in a row.
 *  - Furthermore, remove preserves the semantics of next and hasNext,
 *    because the next unseen item in the iteration remains the same.  
 *    
 *  - This version of remove is listed as an optional method, 
 *    so the programmer needs to check that it is implemented.
 *  - The design of remove has been criticized as poor,
 *    but we will use it at one point in the text.
 * 
 */

/**
 * Iterator interface.
 */
// a sample specification of the Iterator interface.
// This iterator class extends the standard java.util version in order to allow the enhanced for loop to work.
public interface Iterator<AnyType> extends java.util.Iterator<AnyType>{
	/**
	 * Tests if there are items not yet iterated over.
	 */
	boolean hasNext();
	
	/**
	 * Obtains the next(as yet unseen) items in the collection.
	 */
	AnyType next();
	
	/**
	 * Remove the last item returned by next.
	 * Can only be called once after next.
	 */
	void remove();

}
