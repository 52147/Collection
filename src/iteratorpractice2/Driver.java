package iteratorpractice2;
/**
 * = MyContainerIterator is not used by MyContainer class = 
 * 
 * - This class demonstrates how the inheritance-based iterators are used.
 * - We see the declaration of itr: it is now a reference to an Iterator.
 * 
 * - There is no MyContainerIterator type in the main method.
 * - In fact that a MyContainerIterator exists is not used by any clients of MyContainer class.
 *   -> This is a very slick design and illustrates nicely the idea of 
 *      hiding an implementation and programming to an interface.
 *   -> The implementation can be made even slicker by use of nested classes, 
 *      and a Java feature known as inner class.    
 *
 */

public class Driver {

	public static void main(String[] args) {
		MyContainer v = new MyContainer();
		
		v.add("3");
		v.add("2");
		
		System.out.println("Contaoner contents: ");
		Iterator itr = v.iterator(); // itr -> a reference of Iterator interface // no use myContainerIterator type -> information hiding
		while(itr.hasNext())
			System.out.println(itr.next());

	}

}
