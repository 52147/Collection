package collectionapi;
/**
 * 
 * Solution 2:  using getClass()
 * 
 * - In this example, a BaseClass and DerivedClass object would never be declared equal.
 * - This program shows a correct implementation.
 * 
 * - It contains the idiomatic test.
 * - getClass returns a special object of type Class(note the capital C) that represents information about any object's class.
 * - getClass is a final method in the Object class.
 * - If when invoked on 2 different objects it returns the same Class instance,
 *   then the 2 objects have identical types.
 *   
 *   
 *   
 * - When using a HashSet, we must also override the special hashCode method that is specified in Object;
 *   hashCode returns an int.
 * - Think of hashCode as providing a trusted hint of where the items are stored.
 * - If the hint is wrong, the item is not found, so if 2 objects are equal,
 *   they should provide identical hints.
 *   
 *   - The contract for hashCode is that if 2 objects are declared equal by the equals method,
 *     then the hashCode method must return the same value for them.
 *   - If this contract is violated, the HashSet will fail to find objects,
 *     even if equals declares that there is a match.
 *   - If equals declares the objects are not equal, the hashCode method should return a different value for them,
 *     but this not required.
 *   
 *   - However, it is very beneficial for HashSet performance
 *     if hashCode rarely produces identical results for unequal objects. 
 *   
 *
 *
 *
 */

// Correct implementation of equals

class BaseClass2{
	
	private int x;
	
	public BaseClass2(int i ) {x = i;}
	
	public boolean equals(Object rhs) {
		if(rhs == null || getClass() != rhs.getClass())
			return false;
		
		return x == ((BaseClass2) rhs).x;
	}
}

class DerivedClass2 extends BaseClass2{
	
	private int y;
	
	public DerivedClass2(int i, int j) {
		super(i);
		y = j;
	}
	public boolean equals(Object rhs) {
		
		// Class test not needed; getClass() is done in superclass equals
		return super.equals(rhs) && y == ((DerivedClass2)rhs).y;
	}
	
	
}
public class CorrectEqualsWithInheritance {
	
	

	public static void main(String[] args) {
		BaseClass2 a  = new BaseClass2(5);
		DerivedClass2 b = new DerivedClass2(5, 8);
		DerivedClass2 c = new DerivedClass2(5, 8);
		
		System.out.println("b.equals(c): " + b.equals(c)); // return true
		System.out.println("a.equals(b): " + a.equals(b)); // return false, require identically typed objects
		System.out.println("b.equals(a): " + b.equals(a)); // return false, a is not an instance in DerivedClass

	}

}
