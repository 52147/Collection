package interfacepractice2;
/**
 * = encapsulation and interface =
 * 
 *  - Encapsulation is a form of information hiding.
 *  - For encapsulation to be useful, a class definition must be given in such a way that a programmer can use the class
 *    without seeing the hidden details.
 *  - Encapsulation neatly divides a class definition into 2 parts, which will call
 *    1. the interface and 
 *    2. the implementation.
 *    
 *  1. The class interface:
 *    
 *     1. heading for the public methods
 *     2. name for the public constant of the class
 *     3. comments: how to use the public methods and public constants
 *    
 *    - The class interface tells programmers all they need to know to use the class in their programs.
 *    - The class interface consists of the headings for the public methods and public named constants of the class,
 *      along with comments that tell a programmer how to use these public methods and constants.
 *    
 *  2. The implementation:
 *  	
 *  	1. private constants
 *      2. private instance variables
 *      3. private methods
 *      4. public methods
 *    
 *     - The implementation of a class consists of all of the private elements of the class definition,
 *       principally the private instance variable of the class,
 *       along with the definitions of both the public methods and private methods.
 *       
 *   A well- encapsulated class definition:
 *   
 *       class definition:                    wall
 *                                              |
 *       Implementation:                <-> Interface                     <->  programmer who uses the class
 *       1. private instance variables      1. comments
 *       2. private constants               2. headings of public methods
 *       3. private methods                 3. public named constants
 *       4. bodies of public methods            |
 *                                              |
 *                                             wall
 *
 *
 * class interface related to an application programming interface(API):
 * 
 *   - The API for a class is essentially the same thing as the class interface for the class.
 * 
 * 
 * interface:
 * 
 *  - an interface name begins with an uppercase letter, just as class name do.
 *  - You store an interface in its own file, using a name that begins with the name of the interface, followed by .java.
 *    for example, the interface Measurable is in the file Measurable.java.
 *  - This interface provides a programmer with a handy summary of the method's specifications.
 *  - The programmer should be able to user these methods given only the information in the interface, without looking at the method bodies.
 *
 *  - An interface does not declare any constructors for a class.
 *  - Methods within an interface must be public, so you can omit public from their headings.
 *  - An interface can also define any number of public named constants.
 *  - It contains no instance variables and methods's bodies.
 *
 */


/**
 * An interface for methods that return the perimeter and area of an object.
 * 
 *
 */
public interface Measurable {
	/**Returns the perimeter*/
	public double getPerimeter();
	
	/**Returns the area.*/
	public double getArea();
	

}
