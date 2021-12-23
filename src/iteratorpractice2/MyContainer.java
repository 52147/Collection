package iteratorpractice2;
/**
 * = inheritance-based iterators and factories =
 * 
 *  - factory method:
 *    A factory method creates a new concrete instance but returns it using a reference to the interface type.
 * 
 *  - The iterator designed so far manages to abstract the concept of iteration into an iterator class.
 *  - This is good, because it means that if the collection changes from an array-based collection to something else.
 *  - The basic code does not need to change.
 *  
 *  - While this is a significant improvement, changes from an array-based collection to something else
 *    require that we change all the declarations of the iterator.
 *  
 *  
 *  - Our basic idea is to define an interface Iterator.
 *  - Corresponding to each different kind of container is an iterator that implements the Iterator protocol.
 *     
 *     - In our example, this gives 3 classes: 
 *       1. MyContainer
 *       2. Iterator
 *       3. MyContainerIterator
 *       
 *       - The relationship that holds is MyContainerIterator is a Iterator.
 *       - The reason we do this is that each container can now create an appropriate iterator,
 *         but pass it back as an abstract Iterator.
 * 
 *
 */
// The MyContainer class, design 2
public class MyContainer {
	
	Object [] items;
	int size;
	
	// In the revised MyContainer, the iterator method returns a reference to an Iterator object;
	// the actual type turns out to be a MyContainerIterator.
	// Since MyContainerIterator is a iterator, this is safe to do.
	// Because iterator creates and returns a new iterator object,
	// whose actual type is unknown, it is common know as a factory method.	
	public Iterator iterator() {
		return new MyContainerIterator(this);
	}
	
	public int size() {
		return size;
	}
	
	public void add (String element) {
		Object[] old = items;
		items = new String[20];
		
		for(int i = 0; i< size(); i++)
			items[i] = old [i];
		items[size++] = element;
	}

}
