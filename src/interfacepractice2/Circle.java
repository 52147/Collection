package interfacepractice2;
/**
 * Circle class:
 * 
 * - Circle class and Rectangle can both implements the interface.
 * 
 * - Notice that Circle defines the method getCircimferemce in addition to the methods declared in the interface.
 * - It is usual for a class to define 2 methods that perform the same task.
 * 
 * - Doing so provides a convenience for programmers who use the class 
 *   but prefer a more familiar name for a particular method.
 * 
 * - Notice, however, that getCircumference calls getPerimeter instead of performing its own calculation.
 * - Doing so makes the class easier to maintain.
 *   - For example, if we ever discovered a problem with the statements in getPerimeter,
 *                  fixing it would also fix getCircumference. 
 */

/**
 * 
 * A class of circles.
 *
 */

public class Circle implements Measurable{
	
	private double myRadius;
	
	public Circle(double radius) {
		myRadius = radius;
	}
	
	public double getPerimeter() {
		return 2*Math.PI*myRadius;
	}
	
	// This method is not declared in the interface
	// Calls another method(getPerimeter()) instead of repeating its body
	public double getCircumference() {
		return getPerimeter();
	}
	
	public double getArea() {
		return myRadius*myRadius*Math.PI;
	}

}
