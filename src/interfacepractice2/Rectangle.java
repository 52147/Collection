package interfacepractice2;
/**
 * = Implement a interface =
 * 
 *  - When you write a class that defines the methods declared in an interface,
 *    we say that the class implements the interface.
 *  - A class that implements an interface must define a body for every method that interface specifies.
 *  - It might also define methods not declared in the interface.
 *  
 *  - That is, an interface need not declare every method defined in a class.
 *  - In addition, a class can implement more that one interface.
 *  
 *  
 *  To implement an interface, a class must do 2 things:
 *   
 *   1. include the phrase:
 *   
 *      implements interface's name
 *      
 *      to implement more that one interface, just list all the interface names
 *      
 *      implements interface 1, interface 2
 *      
 *   2. Define each method declared in the interface(s)
 *      
 *      - In this way, a programmer can guarantee--and indicate to other programmers--that
 *        a class defines certain method.
 *      - Additionally, recall that Java does not allow a class to be derived form multiple parent classes.
 *      - However, a class can implement multiple interfaces.
 *      - This is a way to capture some of the behavior that would be possible with multiple inheritance.
 *      
 *  
 *  
 * 
 * 
 *
 */

/**
 * 
 * A class of rectangles.
 * Rectangle class implement the interface Measurable
 * Rectangle class must also implement the 2 methods getPerimeter() and getArea().
 * 
 *
 */
public class Rectangle implements Measurable{
	
	private double myWidth;
	private double myHeight;
	
	public Rectangle(double width, double height) {
		myWidth = width;
		myHeight = height;
				
	}
	
	public double getPerimeter() {
		return 2 * (myWidth + myHeight);
	}
	
    public double  getArea() {
    	return myWidth * myHeight;
    }

}
