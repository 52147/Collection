package collectionapi;
import java.util.ArrayList;
import java.util.ListIterator;

public class TestArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		lst.add(2);
		lst.add(4);
		
		ListIterator<Integer> itr1 = lst.listIterator(0);
		ListIterator<Integer> itr2 = lst.listIterator(lst.size());
		
		System.out.println("Forward: ");
		while(itr1.hasPrevious())
			System.out.println(itr1.previous() + " ");
		System.out.println();
		
		System.out.println("Backward: ");
		while(itr2.hasPrevious())
			System.out.println(itr2.previous() + " ");
		System.out.println();
		
		System.out.println("Forward: ");
		for(Integer x : lst)
			System.out.println(x + " ");
		System.out.println();

	}

}
