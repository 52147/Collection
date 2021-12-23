package collection;
/**
 * = the collection api =
 *  
 *  - Data structure:
 *  
 *  
 *    - Data structures allows us to achieve an important object-oriented program goal:
 *      component reuse.
 *    - When each data structures has been implement once it can be used over and over in various applications.
 *  
 *    - A data structure is a representation of data and the operations allows on that data.
 *    - Many, but by no means all, of the common data structures store a collection of objects and then provide methods to add a new object to,
 *      remove an existing object from, or access a contained object in the collection.
 *     
 *          
 *  - generic protocol of data structure:    
 *        
 *    - The code below illustrates a generic protocol that many data structures tend to follow.
 *    - We do not actually use this protocol directly in any code.
 *    - However, an inheritance-base hierarchy of data structures could use this class as a starting point.    
 *    
 *    - Then we give a description of the Collections API interface that is provided for these data structures,
 *    - By no means does the Collections API represent the best way of doing things.
 *    - However, it represents the one library for
 *      data structure and algorithms guaranteed to be available.
 * 
 *
 */

// Simple Container protocol
// A generic protocol for many data structure
public interface SimpleContainer<T> {
	
	void insert(T x);
	void remove(T x);
	T find(T x);
	
	boolean isEmpty();
	void makeEmpty();

}
