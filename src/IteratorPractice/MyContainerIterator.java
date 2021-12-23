package IteratorPractice;

/**
 * = Iterator class =
 * 
 * An iterator class that steps through MyContainer.
 * 
 *  methods in Iterator class:
 * 
 *  - 1. hasNext : returns true if the iteration has not yet been exhausted.
 *  - 2. next : returns the next item in the collection (in the process, advances the current position.)
 *
 *  MyContainerIterator  (constructor)
 *  
 *   - The iterator keeps a variable(current) that represents the current position in the container, 
 *     and a reference to the container.
 *     
 *     
 *   - The implementation of the constructor and 2 method is straightforward.
 *   - The constructor initializes the container reference,
 *     hasNext simply compares the current position with the container size,
 *     and next uses the current position to index the array(and then advance the current position).
 *     
 *     
 *     
 *  The limitation of this iterator design:
 *  
 *    - The limitation of this iterator design is the relatively limited interface.
 *    - Observe that it is impossible to reset the iterator back to the beginning and 
 *       that the next method couples access of an item with advancing.
 *    - The next, hasNext design is what is used in the Java Collection API;
 *       many people feel that the API should have provided a more flexible iterator.
 *       
 *    - It is certainly possible to put more functionality in the iterator, 
 *       while leaving the MyContainer class implementation completely unchanged.
 *    - On the other hand, doing so illustrates no new principles.
 *     
 *      
 *
 */

// An iterator class that step through a MyContainer.
public class MyContainerIterator {
	
	private int current = 0;
	private MyContainer container;
	
	//package visible
	MyContainerIterator(MyContainer c){
		container = c;
	}
	
	public boolean hasNext() {
		return current<container.size;
	}
	public Object next() {
		return container.items[current++];
	}

}
