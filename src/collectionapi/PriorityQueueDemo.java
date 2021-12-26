package collectionapi;

import java.util.PriorityQueue;
/**
 * = priority queues =
 * 
 * - Although jobs sent to a printer are generally placed on a queue,
 *   that might not always be the best thing to do.
 * - For instance, one job might be particularly important,
 *   so we might want to allow that job to be run as soon as the printer available.
 * 
 * - Conversely, when the printer finishes a job, and several 1-page jobs and one 100-page job are waiting,
 *   it might be reasonable to print the long job last,
 *   even if it is not the last job submitted.
 *   (Unfortunately, most systems do not do this, which can be particularly annoying at times.)
 * 
 * - Similarly, in a multiuser environment the operating system scheduler
 *   must decide which of several processed to run. 
 * - Generally, a process is allowed to run only for a fixed period of time.
 * 
 * - A poor algorithm for such a procedure involves use of a queue.
 * - Jobs are initially placed at the end of the queue.
 * - The scheduler repeatedly takes the first job from the queue,
 *   runs it until either it finished or its time limit is up,
 *   and places it at the end of the queue if it does not finish.
 *   
 * - Generally, this strategy is not appropriate because short jobs must
 *   wait and thus seem to take a long time to run.
 * - Clearly, users who are running are editor should not see a visible delay
 *   in the echoing of typed characters.
 *   
 * - Thus short jobs(that is, those using fewer resources) should have precedence over jobs
 *   that have already consumed large amounts of resources.
 * - Furthermore, some resource-intensive jobs, such as jobs run by the system administrator,
 *   might be important and should also have precedence.
 *   
 *   
 * 
 * - If we give each job a number to measure its priority, 
 *   then the smaller number(pages printed, resources used) tends to indicate greater importance.
 * - Thus we want to be able access the smallest item in a collection of items
 *   and remove it from the collection.
 * - To do so, we use the findMin and deleteMin operations.
 * - The data structure that supports these operations is the priority queue 
 *   and supports access of the minimum item only.
 *   
 *     insert-->            -----> deleteMin
 *           |priority queue |     findMin
 *           |_______________|
 *    
 *           The priority model:
 *           Only the minimum element is accessible.
 *   
 *   - The PriorityQueue is a class that implements the Queue interface,
 *   - Thus insert, findMin, and deleteMin are expressed via calls to add, elements, and remove.
 *   - The PriorityQueue can be constructed either with no parameters,
 *     a comparator, or another compatible collection.
 *     
 * - As the priority queue supports only the deleteMin and findMin operations,
 *   we might expect performance that is a compromise between the constant-time queue
 *   and the logarithmic time set.
 *   
 * - Indeed, this is the case.
 * - The basic priority queue supports all operations in logarithmic worst-case time,
 *   uses only an array, supports insertion in constant average time,
 *   is simple to implement, and is known as binary heap.
 * - An alternate implementation that supports an additional decreaseKey operation 
 *   is pairing heap.
 *   
 * - Because there are many efficient implementations of priority queues,
 *   it is unfortunate that the library designers did not choose to make PriotityQueue an interface.
 * - Nonetheless, the PriorityQueue implementation in Java 5 is sufficient for most priority queue applications.
 * 
 * - An import application of the priority queue is event-driven simulation.
 * - Consider, for example, a system such as a bank in which customers arrive and wait in line
 *   until one of K tellers is available.
 * - Customer arrival is governed by a probability distribution function,
 *   as is the service time
 *   (the amount of time it tales a teller to provide complete service to one customer).
 * - We are interested in statics such as how long on average a customer has to wait
 *   or how long a line might be.
 * 
 * - With certain probability distributions and values of K,
 *   we can compute these statics exactly.
 * - However, as K gets larger, the analysis becomes considerably more difficult,
 *   so the use of a computer to simulate the operation of the bank is appealing.
 * - In these way, the bank's officers can determine how many tellers are needed to
 *   ensure reasonably smooth service.
 *   
 * - An event-driven simulation consists of processing events.
 * - The 2 events here are
 * 
 *    (1)
 *    a customer arriving and
 *    (2)
 *    a customer departing, thus freeing up a teller.
 *   
 *   - At any point we have a collection of events waiting to happen.
 *   - To run the simulation, we need to determine the next event;
 *     this is the event whose time of occurrence is minimum.
 *   - Hence, we use a priority queue that extracts the event of minimum time to 
 *     process the event list efficiently. 
 *
 */

public class PriorityQueueDemo {
	
	public static <AnyType extends Comparable<? super AnyType>> void dumpPQ(String msg, PriorityQueue<AnyType> pq) {
		System.out.println(msg + ":");
		while(!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}
	
	// Do some inserts and removes (done in dumpPQ)
	public static void main(String[] args) {
		
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		
		minPQ.add(4);
		minPQ.add(5);
		minPQ.add(3);
		
		dumpPQ("minPQ", minPQ);

	}

}
