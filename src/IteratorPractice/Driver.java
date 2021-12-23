package IteratorPractice;

/**
 * = the iterator pattern =
 * 
 *  - The collection API makes heavy use of a common technique known as the iterator pattern.
 *  - So before we begin our discussion of the Collection API, we examine the ideas behind the iterator pattern.
 *  
 * 1. First way use an iterator object in the for loop to print the elements:
 *  
 *  
 *  - Consider the problem of printing the elements in a collection.
 *  - Typically, the collection is an array, so assuming that the object v is an array,
 *    its content are easily printed with code like the following:
 *    
 *      for(int i = 0; i< v.length;i++)
 *        Sysout.out.println(v[i]);
 *    
 *     -> In this loop, i is an iterator object, because it is the object that is used to control the iteration.
 *  
 *  - However, using the integer i as an iterator constrains the design:
 *    - We can only store the collection in an array-like structure.
 *  
 *    
 * 2. Second way use a iterator class that provide the iterator method to print the elements:
 * 
 * 
 * - A more flexible alternative is to design an iterator class that encapsulates a position inside of a collection.
 * - The iterator class provide methods to step through the collection.
 *          
 * - The key concept of programming to an interface:
 * 
 *   - We want the code that performs access of the container to be as independent of the type of the container as possible.
 *   - This is done by using only methods that are common to all containers and their iterators.
 *        
 * - There are many different possible iterator designs.
 * 
 *   - If we replace int i with IteratorType itr, then the loop above expresses
 * 
 *    for(itr = v.first(); itr.isValid(); itr.advance())
 *        Sysout.out.println(itr.getData());
 *        
 *   - This suggests an iterator class that contains methods such as isValid, advance, getData, and so on.
 *        
 * 	- We describe 2 designs, outside the Collection API context, that lead to the Collection API iterator design.
 *    
 *
 */

// A main method, to illustrate iterator design 1.
public class Driver {

	public static void main(String[] args) {
		
		MyContainer v = new MyContainer();
		
	
		v.add("2");
		v.add("3");
		v.add("4");
		v.add("5");
		v.add("6");
		v.add("7");
		v.add("8");
		v.add("9");
		v.add("10");

		
		System.out.println("Container contents : ");
		MyContainerIterator itr = v.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());

	}
		
	}

