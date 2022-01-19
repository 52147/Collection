package collectionapi;
/**
 * 
 * = the HashSet class =
 * 
 * - In addition to the TreeSet, the Collections API provides a HashSet class 
 *   that implements the Set interface.
 * - The HashSet differs from the TreeSet in that it can not be used to enumerate items in sorted order,
 *   nor can it be used to obtain the smallest or largest item.
 *   
 * - Indeed, the items in the HashSet do not have to be comparable in any way.
 * - This means that the HashSet is less powerful than the TreeSet.
 * - If being able to enumerate the items in a Set in sorted order is not important, 
 *   then it is often preferable to use the HashSet because not having to maintain sorted order 
 *   allows the HashSet to obtain faster performance.
 *   
 * - To do so, elements placed in the HashSet must provide hints to the HashSet algorithms.
 * - This is done by having each element implements a special hashCode method.
 * 
 * - The code below illustrates the use of the HashSet.
 * - It is guaranteed that if we iterate through the entire HashSet,
 *   we will see each item once, but the order that the items are visited is unknown.
 * - It is almost certain that the order will not be the same as the order of insertion,
 *   nor will it be any kind of sorted order.
 *   
 * - Like all Sets, the HashSet does not allow duplicates.
 * - Two items are considered equal if the equals method says no.
 * - Thus, any object that is inserted into the HashSet must have a properly overridden equals method.
 * 
 * - It is essential that equals is overridden(by providing a new version that takes an Object as parameter)
 *   rather than overloaded.
 *   - overloaded: same method name but different parameters in the same class.
 *  
 *
 */

// An illustration of the HashSet, where items are output in some order
public class HashSetDemo {

	public static void main(String[] args) {


		Set<String> s = new HashSet<String>();
		s.add("joe");
		s.add("bob");
		s.add("hal");
		printCollection1(s);

	}
	
	// Print the contents of Collection c(using iterator directly)
	public static <AnyType> void printCollection1(Collection<AnyType> c) {
		Iterator<AnyType> itr = c.iterator();
		while(itr.hasNext())
			System.out.println(itr.next()+" ");
		System.out.println();
	}
	
	// Print the contents of Collection c(using enhanced for loop)
	public static<AnyType> void printCollection2(Collection<AnyType> c) {
		for(AnyType val : c )
			System.out.println(val + " ");
		System.out.println();
	}

}
