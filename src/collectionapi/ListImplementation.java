package collectionapi;
/**
 * LinkedList vs. ArrayList
 * 
 * - There are 2 basic List implementations in the Collections API.
 * - One implementation is the ArrayList, which we have already seen.
 * - The other is a LinkedList, which stores items internally in a different manner than ArrayList,
 *   yielding performance trade-offs.
 * - A third version is Vector, which is like ArrayList, but is from an older library, and is present mostly for compatibility with legacy(old) code.
 * - Using Vector is no longer in vogue.
 * 
 * ArrayList:
 * 
 * - The ArrayList may be appropriate if insertions are performed only at the high end of the array(using add).
 * - The Array doubles the internal array capacity if an insertion at the high end would exceed the internal capacity.
 * 
 * - Although this gives good Big-Oh performance, especially if we add a constructor that 
 *   allows the caller to suggest initial capacity for the internal array,
 *   the ArrayList is a poor choice if insertions are not made at the end,
 *   because then we must move items out of the way.
 *   
 * LinkedList:
 * 
 * - In a linked list, we store items non contiguously rather than in the usual contiguous array.
 * - To do this, we store each object in a node that contains the object and a reference to the next node in the list.
 * - In this scenario, we maintain references to both the first and last node in the list.
 * 
 * - Now an arbitrary item can no longer be found in one access.
 * - Instead, we must scan down the list.
 * - This is similar to the difference between accessing an item on a one access or sequential.
 * 
 * - While this may appear to make linked lists less attractive than arrays,
 *   they still have advantages.
 *   
 *   - First, an insertion into the middle of the list does not require moving all of the items that follow the insertion point.
 *   - Data movement is very expensive in practice, and the linked list allows insertion with only a constant number of assignment statements.
 *   
 *   
 * - Comparing ArrayList and LinkedList, we see that insertions and deletions toward the middle of the sequence are
 *   are inefficient in the ArrayList but may be efficient for LinkedList.
 * 
 * - However, an ArrayList allows direct access by the index, but a LinkedList should not.
 * - It happens that in the Collections API, get and set are part of the List interface,
 *   so LinkedList supports these operations, but does so very slowly.
 * - Thus, the LinkedList can always be used unless efficient indexing is needed.
 * - The ArrayList may still be a better choice if insertions occur only at the end.
 * 
 * - To access items in the list, we need a reference to the corresponding node,
 *   rather than an index.
 * - The reference to the node would typically be hidden inside an iterator class.
 * 
 * - Because LinkedList performs adds and removes more efficiently,
 *   it has more operations than the ArrayList.
 * 
 * - Some of the additional operations available for LinkedList are the following:
 * 
 *   void addLast(AnyType element)
 *   Appends element at the end of this LinkedList
 *   
 *   void addFirst(AnyType element)
 *   Appends elements to the front of this LinkedList
 *   
 *   AnyType getFirst()
 *   
 *   AnyType element()
 *   Return the first element in this LinkedList.
 *   
 *   AnyType getLast()
 *   Returns the last element in this LinkedList
 *   
 *   AnyType removeFirst()
 *   
 *   AnyType remove()
 *   Removes and returns the first element from this LinkedList.
 *   
 *   AnyType removeLast()
 *   Removes and returns the last element from this LinkedList.
 *   
 *   
 * = running time for Lists =
 * 
 * - For some operations, ArrayList is a better choice than LinkedList, and for other operations the reverse is true.
 * - In this section, we will analyze the running times in terms of Big-Oh.
 * 
 * - Initially, we concentrate on the following subset of operations:
 *   
 *   add(at the end)
 *   add(at the front)
 *   remove(at the end)
 *   remove(at the front)
 *   get and set
 *   contains
 * 
 *  ArrayList costs:
 *  
 *  - For the ArrayList, adding at the end simply involves placing an item at the next available array slot,
 *    and incrementing the current size.
 *  - Occasionally we have to resize the capacity of the array, but as this is an extremely rare operation,
 *    one can argue that it does not affect the running time.
 *  - Thus the cost of adding at the end of an ArrayList does not depend on the number of items stored in the ArrayList
 *    and is O(1).
 *    
 * - Similarly, removing from the end of the ArratList simply involves decrementing the current size, and is O(1).
 * 
 * - get and set on the ArrayList become array indexing operations, which are typically taken to be constant-time, O(1) operations.
 *    
 * - Needless to say, when we are discussing the cost of a single operation on a collection,
 *   it is hard to envision anything better than O(1), constant time, per operation.
 * - To do better than this would require that as the collection gets larger, operations actually get faster which would be very unusual.
 * 
 * - However, not all operations are O(1) on an ArrayList.
 * - As we have seen, if we add at the front of the ArrayList, then every element in the ArrayList must be shifted one index higher.
 * - Thus if there are N elements in the ArrayList, adding at the front is an O(N) operation.
 * 
 * - Similarly, removing from the front of the ArrayList requires shifting all the elements one index lower,
 *   which is also an O(N) operation.
 * 
 * - And a contains on an ArrayList is an O(N) operation, because we potentially have to sequentially examine every item in the ArrayList.
 * 
 * LinkedList costs:
 * 
 * - If we look at the  LinkedList operations, we can see that adding at either the front or the end is an O(1) operation.
 * - To add at the front, we simply create a new node and add it at the front, updating first.
 * - This operation does not depend on knowing how many subsequent nodes are in the list.
 * - To add at the end, we simply create a new node and add it at the end, adjusting last.
 * 
 * - Removing the first item in the linked list is likewise an O(1) operation,
 *   because we simply advance first to the next node in the list.
 * - Removing the last item in the linked list appears to also be O(1), since we need to move last to the next-to-last node, and update a next link.
 * - However, getting to the next-to-last node is not easy in the linked list.
 * 
 * - In the classic linked list, where each node stores a link to its next node,
 *   having a link to the last node provides no information about the next-to-last node.
 *   
 * - The obvious idea of maintaining a third link to the next-to-last node doesn't work 
 *   because it too would need to be updated during a remove.
 * - Instead, we have every node maintain a link to its previous node in the list.
 * - This is known as a doubly linked list.
 * 
 * - In a doubly linked list, add and remove operations at either end take O(1) time.
 * - As we know, there is a trade-off, however, because get and set are no longer efficient.
 * - Instead of direct access through an array, we have to follow links.
 * - In some cases we can optimize by starting at the end instead of the front,
 *   but if the get or set is to an item that is near the middle of the list,
 *   it must take O(N) time.
 *   
 * - contains in a linked list is the same as an ArrayList:
 *   the basic algorithm is a sequential search that potentially examines every item,
 *   and thus is an O(N) operation.
 *   
 * comparison of ArrayList and LinkedList costs:
 * 
 *  - To see the differences between using ArrayList and LinkedList in a larger routine,
 *    we look at some methods that operate on a List.
 *  - First, suppose we construct a List by adding items at the end.
 *  
 * removing from and adding to the middle of a list:
 * 
 *  
 *  
 * 
 *   
 *   
 *   
 *
 */


public class ListImplementation {
	
	/**
	 * adding items at the end:
	 * 
	 * - Irregardless of whether an ArrayList or LinkedLis is passed as a parameter,
	 *   the running time of makeList1 is O(N)
	 *   because each call to add, being at the end of the list, takes constant time.
	 * 
	 * @param lst
	 * @param N
	 */
	public static void makeList1(List<Integer> lst, int N) {
		lst.clear();
		for(int i = 0; i < N; i++)
			lst.add(i);
	}
	
	/**
	 *  Adding at the front:
	 *  
	 *  - if we construct a List by adding items at the front,
	 *    the running time is O(N) for a LinkedList, but O(N^2) for an ArrayList,
	 *    because in an ArrayList, adding at the front is an O(N) operation.
	 *  
	 * @param lst
	 * @param N
	 */
	public static void makeList2(List<Integer> lst, int N) {
		lst.clear();
		for(int i = 0; i < N; i++)
			lst.add(0, i);
	}
	
	/**
	 * compute the sum of the numbers in a List:
	 * 
	 * - the running time is O(N) for an ArrayList,
	 *   but O(N^2) for a LinkedList, because in a LinkedList, calls to get are O(N) operations.
	 * - Instead, use an enhanced for loop, which will be make the running time O(N) for ant List,
	 *   because the iterator will efficiently advance from one item to the next.  
	 *       
	 * @param lst
	 * @return
	 */
	public static int sum(List<Integer> lst) {
		int total = 0;
		
		for(int i = 0; i < N; i++)
			total += lst.get(i);
	}

}
