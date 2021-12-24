package collectionapi;

/**
 * = generic algorithm = 
 * 
 * - The Collection API provides a few general purpose algorithms that operate on all of the containers.
 * - These are static methods in the Collections class
 *   (note that this is a different class than the Collection interface).
 * 
 * - There are also some static methods in the Arrays class that manipulate arrays
 *   (sorting, searching, etc.)
 * - Most of those methods are overload--a generic version, 
 *   and once for each of the primitive types(except boolean)
 *   
 * - We examine only a few of the algorithms,
 *   with the intention of showing the general ideas that pervade the Collection API.
 *   
 * - Some of the algorithms make use of function objects.
 * 
 *  = Comparator function object =
 *  
 *  - Many Collection API classes and routines require the ability to order objects.
 *  - There are 2 ways to do this.
 *  
 *    1.
 *    - One possibility is that the objects implements the Comparable interface and provide a compareTo method.
 *  
 *    2.
 *    - The other possibility is that the comparison function is embedded as the compare method
 *    in an object that implements the Comparator interface.
 *    - Comparator is defined in java.util      
 *      
 *
 */

/**
 * 
 * Comparator function object interface.
 * 
 */
// The Comparator interface, originally defined in java.util and rewritten for this package.
public interface Comparator<AnyType> {
	
	/**
	 * Return the result of comparing lhs and rhs.
	 * @param lhs first object.
	 * @param rhs second object.
	 * @return <0 if lhs is less that rhs,
	 *          0 if lhs is equal to rhs,
	 *         >0 if lhs is greater than rhs.
	 * @throws ClassCastException if objects cannot be compared.
	 */
	int compare(AnyType lhs, AnyType rhs) throws ClassCastException;

}
