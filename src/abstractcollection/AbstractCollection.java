package abstractcollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * *  
 * = Abstract class/method =
 * 
 *  - abstract class : A class that can not be constructed but serves to specify functionality of derived classes.
 *  - abstract method : A method that has no meaningful definition and thus is always defined in the derived class.
 * 
 * = interface (ultimate abstract class) =
 * 
 * - The interface in java is the ultimate abstract class.
 * - It only consists of public abstract methods and public static final filed.
 * 
 * - the difference between interface and abstract class :
 * 
 *   - Both provide a specification of what the subclasses must do
 *   - but interface is not allowed to provide any implementation details either in the form of data fields or implemented methods.
 *    
 *     -> the practical effect of this is that multiple interface suffer the same potential problems
 *        as multiple inheritance 
 *        because we can not have conflicting implementations.
 *        
 *        - thus, while a class may extends only one other class, it may implement more than one interface.
 *   
 * = Data structure =
 * 
 *  - Algorithms require the use of a proper representation of data to achieve efficiency.
 *  - this representation and operations that allowed for data are known as a data structure.
 *  - each data structure allows arbitrary insertion but differs in 
 *    how it allow access to member in the group.
 *  - common data structures store a collection of objects and then provide method to add a new object to,
 *    remove an existing from, or access a contained object in the collection.
 *  - Data structure allows is to achieve an important object-oriented program goal:
 *    component reuse.
 *    
 *    
 * = Collections API =
 * 
 * - Collections:
 * 
 *  - The Collections classes are ADT that can be used to create container objects
 *    to hold and manage access to a collection of other objects.
 *    
 * - API (application programming interface) :
 *  
 *   - The API is a library that provides a collection of data structures.
 *   - API comprises a collection of interfaces, classes, and packages.
 *   - it also provides some generic algorithms, such as sorting.
 *   - it makes heavy use of inheritance.
 *   - it helps us to build our application in reusability.
 *   - most of the the collections API resides in java.util.
 *  
 *   - API's example: 
 *   
 *     - java. net : have classes for networking
 *     - java.io : for various input/output functionality
 *     - when using API class or interface, you either need to write the whole path or use import statement     
 * 
 * - interface & implementation:
 * 
 *  - we are separating the interface of the interface of the Collections API from its implementation
 *    -> is part of objected-oriented principle -> encapsulation (information hiding)
 *    - the user of the data structure needs to see only the available operation, not the implementation.
 *    
 * 
 *  
 * 
 * = Abstract Data Type (ADT) =
 * 
 *  - is a specification for a set of data and the operations on the data.
 *  - This specification describe what the operations do but do not indicate how to store the data
 *    or how to implement the operation
 *  - Thus, ADT uses good information-hiding techniques.
 *  - it is a class with methods for organizing and accessing the data that ADT encapsulation  
 *  - EX: List, Bags, Collection
 *  
 * = Bags =
 * 
 *  - A bag is a collection of objects, where you can keep adding objects to the bag,
 *    but you can not remove them.
 *  - you can collect all the objects, and iterate through them.
 *  - you will bags normally when you program in Java.
 *  
 *  = AbstractCollection class =
 *  
 
 *  - The Abstract Collection implements some of the methods in the Collection interface.
 *  
 *    - For instance:
 *      - isEmpty is easily implemented by checking if the size is 0.
 *      - it would be preferable to do this once and use inheritance to obtain isEmpty.
 *        rather than doing so in ArrayList, LinkedList.
 *      - we cold even override is Empty if it turns out that for some collections there is a faster way of performing isEmpty.
 *      
 *      - However, we can not implement isEmpty in the Collection interface, this can only be done in the Abstract Collection class.
 *      
 *        - to simplify implementations, programmers designing new Collection class can extend the Abstract Collection class
 *           rather than implementing the Collection interface.
 *
 */


/**
 * 
 * = implement 3 methods =
 * 
 *  - we implements isEmpty, clear, add method.
 *  
 *  - 1. clear : removes all items in the Collection
 *  - 2. add : There is no sensible way of providing a usable implementation for add.
 *             So the two alternatives are to make add abstract (since AbstractCollection is abstract)
 *             or to provide an implementation that throws a runtime exception.
 *  
 * 
 *
 */
/**
 * 
 * AbstractCollection provides default implementations for some of the easy methods in the Collection interface.
 *
 */
public abstract class AbstractCollection<AnyType> implements Collection<AnyType> {
	
	/**
	 *  Tests if this collection is empty.
	 *  @return true if the size of this collection is zero.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	/**
	 * Change the size of this collection to zero.
	 */
	public void clear()	{
		Iterator<AnyType> itr = iterator();
		while(itr.hasNext()) {
			itr.next();
			itr.remove();
		}
	}
	
	/**
	 * Adds x to this collections.
	 * This default implementation always throws an exception.
	 * @param x this item to add
	 * @throws UnsupportedOperationException always.
	 */
	public boolean add (AnyType x) {
		throw new UnsupportOperationException();
	}
	
	/**
	 * Returns true if this collection contains x.
	 * If x is null, returns false.
	 * (This behavior may not always be appropriate.)
	 * @param x the item to search for.
	 * @return true if the x is not null and is found in this collection.
	 */
	public boolean contain(Object x) {
		if(x == null) {
			return false;
			
		}
		for(AnyType val : this)
			if (x.equals(val))
				return true;
		return false;
	}
	
	/**
	 * Removes non-null x from this collection.
	 * (This behavior may not always be appropriate.)
	 * @param x the item to remove.
	 * @return true if remove succeeds.
	 * 
	 */
	public boolean remove(Object x) {
		if (x == null) 
			return false;
		Iterator<AnyType> itr = iterator();
		while(itr.hasNext()) {
			if (x.equals(itr.next())) {
				itr.remove();
				return true;
			}
			return false;
		
		
		}
		
	
	
	/**
	 * Obtains a primitive array view of the collection.
	 * @return the primitive array view. 
	 */
	public Object [] toArray() {
		Object [] copy = new Object[size()];
		int i = 0;
		for (AnyType val : this)
			copy[i++] = val;
		return copy;
		
	}
	public <OtherType> OtherType [] toArray(OtherType[] arr) {
		int theSize = size();
		if (arr.length< theSize)
			arr = (OtherType[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), theSize);
		else if(theSize < arr.length)
			arr[theSize] = null;
	    Object [] copy = arr;
	    int i = 0;
	    
	    for(AnyType val : this )
	    	copy[i++] = val;
	    return copy;
	}
	
	/**
	 * Return a string representation of this collection.
	 */
	public String toString(){
		
		StringBuilder result = new StringBuilder("[");
		for (AnyType obj : this)
			result.append(obj + " ");
		
		result.append("]");
		
		return result.toString();
		
	}
	
	

}}
