package collectionapi;
/**
 * = queues =
 * 
 * - Another simple data structure is the queue, 
 *   which restricts access to the least recently inserted item.
 * - In many cases being able to find and/or remove the most-recently inserted item is important.
 * - But in an equal number of cases, it is not only important,
 *   it is actually the wrong thing to do.
 * - In multiprocessing system, for example, when jobs are submitted to a printer,
 *   we expect the least recent or most senior job to be print first.
 * - This order is not only fair but it is also required to guarantee that the first job does not wait forever.
 * - Thus you can expect to find printer queues on all large systems.
 * 
 * 
 *   - The basic operations supported by queues are the following:
 *     - equeue, or insertion at the back of the line
 *     - dequeue, or removal of the item from the front of the line
 *     - getFront, or access of the item at the front of the line
 *     
 *     enqueue  -------  dequeue
 *     ------->  Queue   ------->
 *              -------  getFront  
 *         
 *         -> The queue model:
 *            input: enqueue
 *            output: getFront
 *            deletion: dequeue
 *            
 *    - This figure illustrates queue operations.
 *    - dequeue and getFront have been combined into one operation;
 *    - we do this by having dequeue return a reference to the item that it has removed.
 *    
 *            
 *    - Because the queue operation and the stack operations are restricted similarly,
 *      we expect that they should also take a constant amount of time per query.
 *    - This is indeed the case.
 *    - All of the basic queue operations take O(1) time.            
 *
 */

/**
 * 
 * Queue interface.
 *
 * @param <AnyType>
 */
public interface Queue<AnyType> extends Collection<AnyType>{
	
	/**
	 * Returns but does not remove the items at the "front" of the queue.
	 * @return the front item of null if the queue is empty.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	AnyType element();
	
	/**
	 * Returns and removes the item at the "front" of the queue.
	 * @return the front item.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	AnyType remove();

}
