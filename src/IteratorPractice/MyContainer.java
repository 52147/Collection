package IteratorPractice;

/**
 *  = basic iterator design =
 *  
 *  First design:
 *    
 *    We outline the collection class and provide an iterator class, MyContaoner and MyContainerIterator, respectively.
 *    
 *    
 *    1. container class: 
 *    
 *    iterator()
 *    add()
 *    size()
 *    
 *    - The first iterator design uses only three methods.
 *    
 *    - The container class is required to provide an iterator method.
 *    - iterator returns an appropriate iterator for the collection.
 *    
 *    2. iterator class:   
 *     
 *    hasNext()
 *    next()
 *    
 *    - The iterator class has only 2 methods, hasNext and next.
 *    - hasNext returns true if the iteration has not been exhausted.
 *    - next returns the next items in the collection(and in the process, advances the current position).
 *    - This iterator interface is similar to the interface provided in the Collection API.
 *    
 *  
 *  
 * 
 * 3 methods in MyContainer class:
 * 
 *  - 1. iterator
 *  
 *    - The iterator method in class MyContainer simply returns a new iterator;
 *      notice that the iterator must have information about the container that it is iterating over.
 *    - Thus the iterator is constructed with a reference to the MyContainer.
 *  
 *  - 2. add
 *  - 3. size  
 *  
 *  
 *  
 *  = package visible =
 *  
 *  - The data member items and sizes are packaged visible, rather than being private.
 *  - This is necessary because these data members need to be accessed by MyContainerIterator.
 *  - MyContainerIterator constructor is also packaged visible, so that it can be called by MyContainer.
 *  
 *  
 *
 */

public class MyContainer {
	
	Object[] items; //package visible
	int size; //package visible

	public MyContainer() {
		items = null;
		size = 0;
	}

	public MyContainerIterator iterator() {
		return new MyContainerIterator(this); // return a new iterator with the information of container
	}

	public int size() {
		return size;
	}

	public void add(String string) {
		Object[] old = items;
		items = new String[20];
		for (int i = 0; i < size(); i++) {
			items[i] = old[i];
		}
		items[size++] = string;

	}
}
