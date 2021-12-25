package collectionapi;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 
 * - This class illustrates that we can use itr1 to traverse a list in the
 *   forward direction, and then once we reach the end, we can traverse the list
 *   backwards.
 * 
 * - It also illustrates itr2, which is positioned at the end, and simply
 *   processes the ArrayList in reverse. 
 * - Finally, it shows the enhanced for loop.
 * 
 *
 * 
 */

public class TestArrayList {

	public static void main(String[] args) {

		ArrayList<Integer> lst = new ArrayList<Integer>();
		lst.add(2);
		lst.add(4);
		lst.add(6);
		lst.add(8);
		lst.add(10); 

		ListIterator<Integer> itr1 = lst.listIterator(0);

		System.out.println("Forward: ");
		while (itr1.hasNext())
			System.out.println(itr1.next() + " ");
		System.out.println();

		System.out.println("Backward: ");
		while (itr1.hasPrevious())
			System.out.println(itr1.previous() + " ");
		System.out.println();

		System.out.println("Backward: ");
		ListIterator<Integer> itr2 = lst.listIterator(lst.size());
		while (itr2.hasPrevious())
			System.out.println(itr2.previous() + "");		
		System.out.println();

		System.out.println("Forward: ");
		for (Integer x : lst) // enhanced for loop
			System.out.println(x + " ");
		System.out.println();
		
		

		ArrayList<Integer> lst2 = new ArrayList<Integer>(lst);
		while (itr1.hasNext()) {
			int x = itr1.next();
			itr1.remove();
			System.out.println(x);

		}

		ListIterator<Integer> itr3 = lst2.listIterator(lst2.size());
		while (itr3.hasPrevious()) {
			int x = itr3.previous();
			itr3.remove();
			System.out.println(x);
		}

	}

}
