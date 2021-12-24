package collectionapi;

/**
 * - As an example of using the iterator, the routines print each element in any container.
 * - If the container is an ordered set, its elements are output in sorted order.
 * 
 * - The first implementation uses an iterator directly, 
 *   and the second implementation uses an enhanced for loop.
 *   
 * - The enhanced for loop is simply a compiler substitution.
 * - The compiler, in effect, generates the first version(with jave.util.Iterator) from the second.
 * 
 *
 */

public class Driver {

	// Print the contents of Collection c(using iterator directly)
	public static <AnyType> void printCollection(Collection<AnyType> c) {
		Iterator<AnyType> itr = c.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}
		System.out.println();
	}

	// Print the contents of Collection c(using enhanced for loop)
	public static <AnyType> void printCollection2(Collection<AnyType> c) {
		for (AnyType val : c)
			System.out.println(val + " ");
		System.out.println();
	}

	public static void main(String[] args) {

	}

}
