package collectionapi;
/**
 * = implementing equals and hashCode =
 * 
 * - Overriding equals is very tricky when inheritance is involved.
 * - The contract for equals states that if p and q are not null, p.equals(q) should
 *   return the same value as q.equals(p).
 * - This does not occur in this program.
 * - In that example, clearly b.equals(c) return true, as expected.
 * - a.equals(b) also returns true, because BaseClass's equals method is used, 
 *   and that only compares the x components.
 * 
 * - However, b.equals(a) returns false, because DerivedClass's equals method is used,
 *   and the instanceof test will fail
 *   (a is not an instance of DerivedClass).
 *   
 *   
 * - There are 2 standard solution to this problem.
 * 
 *     1.  Not override equals below the base class:
 *     
 *     - One is to make the equals method final in BaseClass.
 *     - This avoids the problem of conflicting equals.
 *     
 *     2. require identically typed objects using getClass:
 *     
 *     - The other solution is to strengthen the equals test to require that the types are identical,
 *       and not simply compatible, since the one-way compatibility is what breaks equals.
 *   
 *  
 *   
 */

// An illustration of a broken implementation of equals
class BaseClass{
	private int x;
	
	public BaseClass(int i) {x = i;}
	
	public boolean equals(Object rhs) {
		// This is the wrong test(ok if final class)
		if(!(rhs instanceof BaseClass))
			return false;
		
		return x == ((BaseClass) rhs).x;
	}

}

class DerivedClass extends BaseClass{
	
	private int y;
	
	public DerivedClass(int i, int j) {
		super(i);
		y = j;
	}
	
	public boolean equals(Object rhs) {
		// This is the wrong test.
		if(!(rhs instanceof DerivedClass))
			return false;
		return super.equals(rhs) && y == ( (DerivedClass)rhs).y;
	}
}


public class WrongEqualsWithInheritance {
	
	public static void main(String[] args) {
		
		BaseClass a  = new BaseClass(5);
		DerivedClass b = new DerivedClass(5, 8);
		DerivedClass c = new DerivedClass(5, 8);
		
		System.out.println("b.equals(c): " + b.equals(c)); // return true
		System.out.println("a.equals(b): " + a.equals(b)); // return true
		System.out.println("b.equals(a): " + b.equals(a)); // return false, a is not an instance in DerivedClass
		
		
	}
	
	
}
