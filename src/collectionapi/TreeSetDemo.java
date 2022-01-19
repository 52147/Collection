package collectionapi;

/**
 * 
 * = The TreeSet class =
 * 
 * - The SortedSet is implemented by a TreeSet.
 * - The underlying implementation of the TreeSet is a balanced-binary search tree.
 * 
 * - By default, ordering uses the default comparator.
 * - An alternate ordering can be specified by providing a comparator to the constructor.
 *   - As an example, the code below illustrates how a SortedSet that stores strings is constructed.
 *   - The call to printCollection will output elements in decreasing sorted order.
 * 
 * - The SortedSet, like all sets, does not allow duplicates.
 * - Two items are considered equal if the comparator's compare method returns 0. 
 * 
 * 
 * - In section 5.6, we examined the static searching problem and saw that if
 *   the items are presented to us in sorted order, then we can support the find operation in logarithmic worst-case time.
 *   - This is static searching because, once we are presented with the items, 
 *     we can not add or remove items.
 *   - The SortedSet allows us to add and remove items. 
 *   
 * - We are hopping that the worst-case cost of the contains, add, and remove operations is O(log N)
 *   because that would match the bound obtained for the static binary search.   
 *     
 * - Unfortunately, for the simplest implementation of the TreeSet, this is not the case.
 * - The average case is logarithmic, but the worst case is O(N) and occurs quite frequently.
 * 
 * - However, by applying some algorithmic tricks,
 *   we can obtain a more complex structure that does indeed have O(log N) cost per operation.
 * - The Collections API TreeSet is guaranteed to have this performance,
 *   we discuss how to obtain it using the binary search tree and its variants, 
 *   and provide an implementation of the TreeSet, with an iterator.
 *   
 * - We mention in closing that although we can find the smallest and largest item in a SortedSet in O(log N) time.
 *   finding Kth smallest item, where K is a parameter, in not supported in the Collections API.
 * - However, it is possible to perform this operation in O(log N) time,
 *   while preserving the running time of the other operations, if we do more work.
 */

public class TreeSetDemo {
	
	public static void printCollection( Collection<String> c) {
		for(String str: c)
			System.out.println(str);
	}
	
	

	public static void main(String[] args) {
		
		Set<String> s = new TreeSet<String>(Collections.reverseOrder());
		s.add("joe");
		s.add("bob");
		s.add("hal");
		printCollection(s);

	}

}
