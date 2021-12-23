package collectionapi;
/**
 * = collection api: containers and iterators =
 * 
 *   - This section describes the basics of the Collections API iterators
 *     and how they interact with containers.
 *   - We know that an iterator is an object that is used to traverse a collection of objects.
 *   - In the Collection API such a collection is abstracted by the Collection interface, 
 *     and the iterator is abstracted by the Iterator interface.
 *   
 *   - The Collection API iterators are somewhat inflexible, in that they provide few operations.
 *   - These iterators use an inheritance model.
 *   
 * = the Collection interface =
 * 
 *   - The Collection interface represents a group of objects, known as its elements.
 *   - Some implementation, such as lists, are unsorted; others, such as sets and maps, may be sorted.
 *     
 *   - Some implementation allow duplicate; other do not.
 *   - The Collection interface and the entire Collections API make use of generics.
 *   
 *   
 *   - All containers support the following operations:
 *   
 *     1. boolean isEmpty()
 *     - Return true if the container contains no elements and false otherwise.
 *     
 *     2. int size()
 *     - Return the number of elements in the container.
 *     
 *     3. boolean add(AnyType x)
 *     - Add item x to the container.
 *     - Returns true if this operation succeeds and false otherwise
 *       (e.g., if the container does not allow duplicate and x is already in the container).
 *        
 *     4. boolean contains(Object x)
 *     - Returns true if x is in the container and false otherwise.
 *     
 *     5. boolean remove(Object x)
 *     - Removes items x from the container. 
 *     - Return true if x was removed and false otherwise.
 *     
 *     6. void clear()
 *     - Makes the container empty.
 *     
 *     7. Object [] toArray()
 *     <OtherType> OtherType [] toArray (OtherType [] arr)
 *     - Returns an array that contains references to all items in the container.
 *     
 *     8. java.util.Iterator<AnyType> iterator()
 *     - Returns an Iterator that can be used to begin traversing all locations in the container.
 *     
 *  
 *  - Because Collection is generic, it allows objects of only a specific type(AnyType)
 *    to be in the collection.
 *  - Thus, the parameter to add is AnyType.
 *  - The parameter to contains and remove should AnyType also;
 *    however, for backward compatibility it is object.
 *  - Certainly, if contains or remove are called with parameter  
 *    that is not AnyType, the return value will be false.
 *  
 *  toArray()
 *    
 *  - The method toArray returns an array that contains references to the items
 *    that are in the collection.
 *  - In some cases, it can be faster to manipulate this array than to use an iterator
 *    to manipulate the collection;
 *    however, the cost of doing so is extra space.
 *  - The most common place where using the array would be useful is when the collection is being accessed
 *    several times or via nested loops.
 *  - If the array is being accessed only once, sequentially, 
 *    it is unlikely that using toArray will make things faster;
 *    it can make things slower while also costing extra space.
 *    
 *    
 *  - One version of toArray returns the array in a type that use Object[].
 *  - The other version allows the user to specify the exact type of the array
 *    by passing a parameter containing the array
 *    (thus avoiding the costs of casting during the subsequent manipulation)   
 *  - If the array is not large enough, a sufficiently large array is returned instead;
 *    however, this should never be needed.
 *  - The following snippet shows how to obtain an array from a Collection<String> coll;
 *     
 *     String [] theStrings = new String[coll.size];
 *     coll.toArray(theStrings);
 *     
 *     - At this point, the array can be manipulated via normal array index.
 *     - The one-parameter version of toArray is generally the one that you would want to use
 *       because the runtime costs of casting are avoided.
 *       
 *  iterator()
 *  
 *  - The iterator method returns an Iterator<AnyType>, 
 *    which can be use to traverse the collection.
 *    
 *    
 *  - The program below illustrates a specification of the Collection interface.
 *  - The actual Collection interface in java.util contains some additional methods.
 *  - By convention, all implementations supply both a zero-parameter constructor 
 *    that creates an empty collection 
 *    and a constructor that creates a collection that refers to the same elements
 *    as another collection.
 *  - This is basically a shallow-copy of a collection.
 *  - However, there is no syntax in the language that forces the implementation of these constructors.
 * 
 *  Iterable interface
 *     
 *  - The Collection interface extends Iterable, which means that enhanced for loop can be applied to it.
 *  - Recall that the Iterable interface requires the implementaion of an iterator method
 *    that returns a java.util.Iterator.   
 *  - We see the iterator method required by the Iterable interface.
 *  
 *  - However, we remark that we are taking advantage of covariant return types,
 *    because the return type for the iterator method is actually at our own class that
 *    extend java.util.Iterator.
 *    
 *  - The Collection API also codifies the notion of an optional interface method.
 *    - For instance,
 *      - suppose we want an immutable collection:
 *      - Once it is constructed, its state should never change.
 *      
 *    - An immutable collection appears incompatible with Collection,
 *    - since add and remove do not make sense for immutable collections.
 *          
 *  
 *    - However, there is an existing loophole:
 *      - Although the              
 *       
 * 
 *
 */

// A sample specification of the Collection interface
/**
 * 
 * Collection interface; the root of all 1.5 collections.
 *
 */
public interface Collection<AnyType> extends Iterable<AnyType>, java.io.Serializable{
	
	/**
	 * Returns the number of items in this collection.
	 */
	int size();
	
	/**
	 * Tests if this collection is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Tests if some item is in this collection.
	 */
	boolean contains(Object x);
	
	/**
	 * Adds an item to this collection.
	 */
	boolean add(AnyType x);
	
	/**
	 * Removes an item from this collection.
	 */
	boolean remove(Object x);
	
	/**
	 * Change the size of this collection to zero.
	 */
	void clear();
	
	/**
	 * Obtains an Iterator object used to traverse the collection.
	 */
	Iterator<AnyType> iterator();
	
	/**
	 * Obtains a primitive array view of the collection.
	 */
	<OtherType> OtherType [] toArray(OtherType[] arr);

}
 