package collectionapi;
/**
 * = the Collections class =
 * 
 * - Although we will not make use of the Collections class, it has 2 methods that are
 *   thematic of how generic algorithm for the Collections API are written.
 * - We write these methods in the Collections class implementation.
 * 
 *  
 *  - begins by illustrating the common technique of declaring a private constructor in classes
 *    that contain only static methods.
 *  - This prevents instantiation of the class.
 *  
 *  - It continues by providing the reverseOrder method.
 *  - This is a factory method that returns a Comparator that provides the 
 *    reverse of the natural ordering for Comparable objects.
 *  - The returned object is an instance of the ReverseComparator class.
 *  - In the ReverseComparator class, we use the compareTo method.
 *  - This is an example of the type of code that might be implemented with an anonymous class.
 *  
 *    
 *  
 *    
 *   
 *
 *
 */

/**
 * 
 * Instanceless class contains static methods that operate on collections.
 *
 */
public class Collections {
	
	// private constructor
	private Collections() {}
	
	/**
	 * Returns a comparator that imposes the reverse of the default ordering on a collection 
	 * of objects that implement the Comparable interface.
	 * @return the comparator
	 */
	public static <AnyType> Comparator<AnyType> reverseOrder(){
		return new ReverseComparator<AnyType>();
	}
	
	public static class ReverseComparator<AnyType> implements Comparator<AnyType>{
		public int compare(AnyType lhs, AnyType rhs) {
			return -(((Comparable)lhs).compareTo(rhs));
		}
	}
	
	static class DefaultComparator<AnyType extends Comparable <? super AnyType>>
	implements Comparator<AnyType>{

		@Override
		public int compare(AnyType lhs, AnyType rhs) throws ClassCastException {
			
			return 0;
		}
		
	}

}
