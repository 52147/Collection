package interfacepractice1;

/**
 * = interface =
 *  
 *  - The interface looks like a class declaration, except it uses the keyword "interface".
 *  - It consists of a listing of the methods that must be implemented.
 *  
 *  - For example:
 *      
 *     -The Stretchable interface :
 *     
 *        - the Stretchable interface specifies one method that every subclass must implement : Stretch.
 *        - We do not have to specify that there methods are public and abstract,
 *           since these modifiers are required for interface methods, they can usually are omitted.
 *           
 *           
 * 
 *
 */

/**
 * 
 * Interface that defines stretch method to lengthen the longest dimension of a Shape.
 *
 */
public interface Stretchable {
	void stretch (double factor);

}
