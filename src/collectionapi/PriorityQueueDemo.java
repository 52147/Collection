package collectionapi;
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
 *
 */

public class PriorityQueueDemo {

	public static void main(String[] args) {
		

	}

}
