package iteratorpractice2;
/**
 * - This class demonstrates how the inheritance-based iterators are used.
 * - We see the declaration of itr: it is now a reference to an Iterator.
 * 
 * 
 *
 */

public class Driver {

	public static void main(String[] args) {
		MyContainer v = new MyContainer();
		
		v.add("3");
		v.add("2");
		
		System.out.println("Contaoner contents: ");
		Iterator itr = v.iterator(); // itr -> a reference of Iterator interface
		while(itr.hasNext())
			System.out.println(itr.next());

	}

}
