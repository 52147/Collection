package iteratorpractice2;
/**
 * = Iterator interface =
 * 
 *  - The iterator interface, which serves simply to establish the protocol by which
 *    all subclasses of Iterator can be accessed.
 * 
 *  - There are only 2 changes to the implementation of MyContainerIterator.
 *  
 *    - First, the implements clause has been added.
 *    - Second, MyContainerIterator no longer needs to be a public class.
 *    
 *    
 *
 */

// The Iterator interface, design 2
public interface Iterator {
	
	boolean hasNext();
	Object next();

}
