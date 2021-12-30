package collectionapi;
/**
 * =¡@the AbstractCollection class =
 * 
 * - Before we implement the ArrayList class, observe that some of the methods
 *   in the Collection interface can be easily implemented in terms of other.
 *   - For instance,  
 *     - isEmpty is easily implemented by checking if the size is 0.
 *     - Rather that doing so in ArrayList, LinkedList, and all the other concrete implementations,
 *       it would be preferable to do this once and use inheritance to obtain isEmpty.
 *     
 * - We could even override isEmpty if it turns out that for some collections
 *   there is a faster way of performing isEmpty that computing the current size.
 * 
 * - However, we cannot implement isEmpty in the Collection interface;
 *   this can only be done in an abstract class.
 * - This will be the AbstractCollection class.
 * - To simplify implementations, programmers designing new Collections classes
 *   can extend the AbstractCollection class rather than
 *   Implementing the Collection interface.
 *   
 * - The Collections API also defines additional classes such as AbstractList,
 *   AbstractSequentialList, and AbstractSet.
 * - We have chosen not to implement those,
 *   in keeping with our intention of providing a simplified subset of the Collections API/
 * - If, for some reason, you are implementing your own collections and
 *   extending the Java Collections API, 
 *   you should extend the most specific abstract class.
 *     
 * - In the code below, we see implementations of isEmpty, clear, and add.
 * - The first 2 methods have straightforward implementations.
 * - Certainly the implementation of clear is usable,    
 *   since it removes all items in the collections,,
 *   but there might be more efficient ways of performing the clear,
 *   depending on the type of collection being manipulated.
 *  
 * - Thus this implementation of clear serves as a default, but it is likely to be overridden.
 * - There is no sensible way of providing a usable implementation for add.
 * - So the 2 alternatives are to make add abstract
 *   (which is clearly doable, since AbstractCollection is abstract)
 *   or to provide an implementation that throws a runtime exception.
 *   
 * - We have down the latter, which matches the behavior in java.util.
 *   (Further down the road, this decision also makes it easier to create the class
 *    needed to express the values of map).  
 * 
 *   contains()
 *   remove()
 * - provides default implementations of contains and remove.
 * - Both implementations use a sequential search, so they are not efficient,
 *   and need to be overridden by respectable implementations of the Set interface.                         
 *      
 * 
 *   Object toArray()
 *   AnyType toArray()
 *   - contains the implementations of the 2 toArray methods.
 *   - The zero-parameter toArray is fairly simple to implement.
 *   - The one-parameter toArray makes use of a feature of Java known as reflection
 *     to create an array object that matches the parameter type
 *     in the case that the parameter is not large enough to store the underlying collection.
 *
 * = StringBuilder =
 * 
 * - The code also shows a respectable linear-time implementation of toString,
 *   using a StringBuilder to avoid quadratic running time.
 *   (StringBuilder is slightly faster than StringBuffer;
 *     it is preferable for single-threaded applications).
 * 
 * - To see why StringBuilder is needed,
 *   consider the following code fragment that builds a String with N A's:
 *   
 *   String result = "";
 *   for(int i = 0; i< N ; i++)
 *       result += 'A';
 *       
 *     - While there is no doubt that this fragment works correctly
 *       because String objects are immutable,
 *       each call to result += 'A' is rewritten as result = result + 'A',
 *       and once we see that, it is apparent that each String concatenation 
 *       creates a new String object.
 *    
 *    - As we get further into the loop, these String objects become more expensive to create.
 *    - We can estimate the cost of the i th String concatenation to be i,
 *      so the total cost is
 *      1 + 2 + 3 + ... + N, or O(N^2).
 *      If N is 100000, it is simple to write the code and see that the running time is significant.
 *     
 *    -Yet a simple rewrite results in a linear-time algorithm that executes in the blink of the eye:
 *    
 *      char [] theChars = new char[N];
 *      
 *      for(int i = 0 ; i < N ; i++)
 *          theChars[i] = 'A';
 *      
 *      String result = new String(theChars);
 *      
 *      - The use of an array of characters works only if we know the final size of the String.
 *      - Otherwise, we have to use something like ArrayList<char>.
 *      
 *      - A StringBuilder is similar in concept to an ArrayList<char>,
 *        with array doubling but with method names that are specific for String operations.
 *        
 *      - Using a StringBuilder, the code looks like
 *      
 *        StirngBuilder sb = new StringBuilder();
 *        for(int i = 0; i < N; i++)
 *            sb.append('A');
 *        String result = new String(sb);
 *        
 *        - This code is linear-time and runs quickly.
 *        
 *        - Some String concatenations, such as those in a single expression,
 *          are optimized by the compiler to avoid repeated creations of Strings.
 *        - But if your concatenations are intermingled with other statements,
 *          as is the case here, then you often can use a StringBuilder for more efficient code.
 *          
 *          - concatenations:
 *            the operation of joining 2 strings together. use + or concat().
 *
 */

/**
 * 
 * AbstractCollection provides default implementations for some of the 
 * easy methods in the Collection interface.
 *
 */

// Sample implementation of AnsractCollection
public abstract class AbstractCollection<AnyType> implements Collection<AnyType> {
	
	/**
	 * Test if this collection is empty.
	 * @return true if the size of this collection is zero. 
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Change the size of this collection to zero.
	 */
	public void clear() {
		Iterator<AnyType> itr = iterator();
		
		while(itr.hasNext()) {
			itr.next();
			itr.remove();
		}
	}
	
	/**
	 * Adds x to this collections.
	 * This default implementation always throws an exception.
	 */
	public boolean add(AnyType x) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Return true if this collection contains x.
	 * If x is null, return false.
	 * (This behavior may not always be appropriate.)
	 * @param x the item to search for.
	 * @return true if x is not null and is found in this collection. 
	 */
	public boolean contains(Object x) {
		if(x == null)
			return false;
		for(AnyType val : this)
			if(x.equals(val))
				return true;
		return false;
	}
	
	/**
	 * Removes non-null x from this collection.
	 * (This behavior may not always be appropriate.)
	 * @param x the item to remove.
	 * @return true if remove succeeds.
	 */
	public boolean remove(Object x) {
		if(x == null)
			return false;
		Iterator<AnyType> itr = iterator();
		
		while(itr.hasNext()) {
			if(x.equals(itr.next()))
				itr.remove();
			return true;
		}
		return false;
	}
	
	/**
	 * Obtains a primitive array view of the collections.
	 * @return the primitive array view.
	 */
	public Object [] toArray() {
		Object [] copy = new Object[size()];
		
		int i = 0;
		for(AnyType val: this)
			copy[i++] = val;
		return copy;
	}
	
	public <OtherType> OtherType [] toArray ( OtherType [] arr) {
		int theSize = size();
		if(arr.length < theSize)
			arr = (OtherType []) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), theSize);
		else if(theSize < arr.length)
			arr[theSize] = null;
		Object[] copy = arr;
		
		Iterator<AnyType> itr = iterator();
		
		for(int i = 0 ; i < theSize; i++)
			copy[i] =itr.next();
		
		return arr;
		
	}
	
	/**
	 * Return a string representation of the collection
	 */
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		
		for(AnyType obj : this)
			result.append(obj + " ");
		result.append("[");
		
		return result.toString();
	}
	
	/**
	 * Return true if items in other collection are equal to items in this collection.
	 * (same order, and same according to equals).
	 */
	public final boolean equals(Object other) {
		
		if(other == this)
			return true;
		if(!(other instanceof Collection))
			return false;
		
		Collection rhs = (Collection) other;
		if(size() != rhs.size())
			return false;
		
		Iterator<AnyType> lhsItr = this.iterator();
		Iterator rhsItr = rhs.iterator();
		
		while(lhsItr.hasNext())
			if(!isEqual(lhsItr.next(), rhsItr.next()))
				return false;
		return true;
	}
	
	/**
	 * Return the hashCode.
	 */
	public final int hashCode() {
		int hashVal = 1;
		for(AnyType obj : this)
			hashVal = 31 * hashVal + (obj == null ? 0 : obj.hashCode());
		return hashVal;
	}
	 
	/**
	 * Return true if 2 objects are equal;
	 * works if objects can be null.
	 */
	private boolean isEqual(Object lhs, Object rhs) {
		if(lhs == null)
			return rhs == null;
		return lhs.equals(rhs);
	}
	
	

}
