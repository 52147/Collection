package collectionapi;
/**
 * = binary search =
 * 
 * - The Collection API implementation of the binary search is the static method
 *   Arrays.binarySearch.
 * - There are actually 7 overloaded versions--one for each of the primitive types except boolean,
 *   plus 2 more overloaded versions that work on Objects
 *   (one works with a comparator, one uses the default comparator).
 * - We will implement the Object versions(using generics); the other seven are mindless copy-and-paste.
 * 
 * - For binary search the array must be sorted; if it is not,
 *   the results are undefined
 *   (verifying that the array is sorted would destroy the logarithmic time bound for the operation).
 * 
 * - If the search for the item is successful, the index of the match is returned.
 * - If the search is unsuccessful, we determine the first position that contains a larger item,
 *   add 1 to this position, and then return the negative of the value.
 * - Thus, the return value is always negative, because it is at most -1
 *   (which occurs if the item we are searching for is smaller than all other items)
 *   and is at least -a.length-1
 *   (which occurs if the item we are searching for is larger than all other items).
 *   
 *   
 *  implementation:
 *   
 *  - As was the case for the max routines, the two-parameter binarySearch calls the three-parameter binarySearch.
 *  
 *  - The two-parameter version does not use generics.
 *  - Instead, all types are Object.
 *  
 *  - But our generic implementation seems to make more sense.
 *  - The three-parameter version is generic in Java5.
 *  
 *  
 *  = Sorting =
 *  
 *  - The Collection API provides a set of overloaded sort methods in the Arrays class.
 *  - Simply pass an array of primitives, or an array of Objects that implement Comparable,
 *    or an array of Objects and a Comparator.
 *  - We have not provided a sort method in our Array class.
 *  
 *   void sort(Object [] arr)
 *   - Rearranges the elements in the array to be in sorted order,
 *     using the natural order.
 * 
 *   void sort(Object [] arr, Comparator cmp)
 *   - Rearranges the elements in the array to be in sorted order,
 *     using the order specified by the comparator
 *     
 *  - These method have been written as generic methods.
 *  - The generic sorting algorithms are required to run in O(N log N) time.
 *
 */
/**
 * 
 * Instanceless class that contains static methods to manipulate arrays.
 *
 */
// implementation of the binarySearch method in Arrays class
public class Arrays {
	private Arrays() {}
	
	/**
	 * Search sorted array arr using default comparator
	 */
	public static <AnyType extends Comparable<AnyType>> int binarchSearch(AnyType [] arr, AnyType x) {
		return binarySearch(arr, x, new Collections.DefaultComparator<AnyType>());
	}
	
	/**
	 * Performs a search on sorted array arr using a comparator.
	 * If arr is not sorted, results are undefined.
	 * @param arr the array to search
	 * @param x the object to search for.
	 * @param cmp the comparator
	 * @return if x is found, returns the index where it is found.
	 *         otherwise, the return value is a negative number equal to -(p+1),
	 *         where p is the first position greater than x.
	 *         This can range from -1 down to -(arr.length+1).
	 * @throws ClassCastException if items are not comparable.        
	 */
	public static <AnyType> int binarySearch(AnyType [] arr, AnyType x, Comparator<? super AnyType> cmp) {
		int low = 0, mid = 0;
		int high = arr.length;
		
		while(low<high) {
			mid = (low+high)/2;
			if(cmp.compare(x, arr[mid])>0)
				low = mid + 1;
			else
				high = mid;
		}
		if(low == arr.length || cmp.compare(x, arr[low]) != 0)
			return -(low + 1);
		return low;
	}

}
