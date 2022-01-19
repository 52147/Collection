package collectionapi;

/**
 * 
 * - This program illustrates a SimpleStudent class in which 2 SimpleStudents are equal if they have the same name(and are both SimpleStudents).
 * - This could be overridden using the techniques in CorrectEqualsWithInheritence class,
 *   or this method could be declared final.
 *   
 * - If it was declare final, then the test that is present 
 *   allows only 2 identically typed SimpleStudents to be declared equal.
 * - If, with a final equals, we replace the test with an instanceof test,
 *   then any 2 objects in the hierarchy can be declared equal if their names match.
 *   
 * - The hashCode method simply uses the hashCode of the name field.
 * - Thus if 2 SimpleStudent objects have the same name(as declared by equals)
 *   they will have the same hashCode, since, presumably, 
 *   the implementation of String honored the contract for hashCode.
 *   
 *  - The accompanying test program is part of a larger test that illustrates all the basic containers.
 *  - Observe that if hashCode is unimplemented, all 3 SimpleStudent objects will be added to the HashSet
 *    because the duplicate will not be detected.
 * 
 * Time complexity:
 *  
 *  - It turns out that on average, the HashSet operations can be performed in constant time.
 *  - This seems like an astounding result because it means that the cost of a single HashSet operation
 *    does not depended on whether the HashSet contains 10 items or 10000 items.
 *    
 *        
 *
 */



/**
 * 
 * Test program for HashSet.
 *
 */
public class IteratorTest {

	public static void main(String[] args) {
		List<SimpleStudent> stud1 = new ArrayList<SimpleStudent>();
		
		stud1.add(new SimpleStudent("Bob", 0));
		stud1.add(new SimpleStudent("Joe", 1));
		stud1.add(new SimpleStudent("Bob", 2)); // duplicate
		
		// Will only have 2 items. if hashCode is implemented.
		// Otherwise will have 3 because duplicate will not be detected.
		Set<SimpleStudent> stud2 = new HashSet<SimpleStudent>(stud1);
		
		printCollection(stud1);  // Bob Joe Bob (unspecifief order)
		printCollection(stud2);  // 2 items in unspecified order

	}

}

/**
 * Illustrates use of hashCode/equals for use in HashSet.
 * Students are ordered on basis of name only. 
 */
class SimpleStudent implements Comparable<SimpleStudent>{
	
	String name;
	int id;
	
	public SimpleStudent(String n, int i) {
		name = n;
		id = i;
	}
	
	public String toString() {
		return name + " " + id;
	}
	
	public boolean equals(Object rhs) {
		if(rhs == null || getClass() != rhs.getClass())
			return false;
		
		SimpleStudent other = (SimpleStudent) rhs;
		return name.equals(other.name);
		
	}
	
	public int hashCode() {
		return name.hashCode();
	}

	
	
	
	
}
