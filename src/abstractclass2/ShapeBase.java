package abstractclass2;
/**
 * = Abstract class = 
 * 
 *  - When we wrote the class ShapeBasics, we did not plan to create objects of the class ShapeBascics.
 *  - Indeed, we designed it as a base class for other classes, such as the class Rectangle.
 *  
 *  - Although we do not really need to create objects of the class ShapeBasics,
 *    we can do so, as in the following statement:
 *    
 *      ShapeBasics shapeVariable = new ShapeBasics();
 *      
 *      - To make this statement valid, however, we needed to write a definition for the method drawHere in the class ShapeBasics.
 *      - The definition that we wrote is just a place holder; all it does is draw a single asterisk,
 *        just do something would happen if we invoked it.
 *      
 *      drawHere()  
 *      
 *      - We never intended to invoke the method drawHere of an object of the base class ShapeBasics.
 *      - Rather, we planned to use the method drawHere only with objects of derived classes,
 *        such as Rectangle and Triangle.
 *        
 *      - Instead of giving a contrived definition of a method that we plan to override in a derived class,
 *        however, we can declare the method to be abstract, as follows:
 *        
 *            public abstract void drawHere();
 *    
 *   - we write the keyword abstract in the method heading,
 *     follow the heading with a semicolon, and omit a method a body.
 *   - A abstract method must be overridden by any (nonabstract) derived class and given a definition.
 *      
 *   - Including an abstract method in a class is a way to force a derived class to define a particular method.
 *   - Java requires that if a class has at least one abstract method,
 *     the class must be declared to be abstract.
 *   - You do this by including the keyword abstract in the heading of the class definition,
 *     as in the following:
 *     
 *         public abstract class ShapeBase{}
 *         
 *     -  A class defined in this way is said to be an abstract class.
 *     - If a class is abstract, you can not create objects of that class;
 *       it can be used only as a base class for other classes.
 *     - For this reason, an abstract class is sometime called an abstract base class.    
 *     
 *  
 *  - In this program, we have revised the class ShapeBasics as an abstract class and named it ShapeBase.
 *  - If we had use this abstract class ShapeBasee in the previous case study, all of our derived class would work as before,
 *    even though we can not create objects of ShapeBase. 
 *    
 *  - Although the class ShapeBase is abstract not all of it method are abstract.
 *  - All the method definitions, except for the method drawHere, are exactly the same as in our original ShapeBasics.
 *  - They are full definitions and do not use the keyword abstract.
 *  - When it make sense to define a body for a method in an abstract class, it should be given.
 *
 *
 *  - That way, as much detail as possible is pushed into the abstract class,
 *    so that such detail need not be repeated in each derived class.
 *    
 *  
 *  - Why have abstract class?
 *  - They simplify your thinking.
 *  - We have already explained in the case study that we defined the class ShapeBasics 
 *    so we do not have to duplicate the definitions of methods such as 
 *    ShapeBasic, such as drawAt for every kind of shape.
 *  - But we also had to write a useless definition for the method drawHere.
 *  - A abstract class makes it easier to define a base class by relieving you of the obligation
 *    to write useless method definitions.
 *  - If a method will always be overridden, make it an abstract method-- 
 *    and so make the class abstract.
 *    
 *  - A abstract method serves a purpose, even though it is not given a full definition.
 *  - It servers as a place holder for a method that must be defined in all(nonabstract) derived classes.
 *  - Note that the method drawAt in this program includes an invocation of the method drawHere.
 *    - If the abstract method drawaHere were omitted, this invocation of drawHere would be illegal.
 *    
 *  
 *  - You might notice that an abstract class is very similar to an interface.
 *  - Both define methods and you can not make instances of either one.
 *  
 *  - However, you can define default methods for the derived classes in an abstract class
 *    and you can only specify the method heading in an interface.
 *    
 *  - Conceptually, an abstract class represents a conceptual view of an abstract entity in the problem.
 *  - An interface specifies functionality that a class must support.
 *  
 *  - An abstract class is a type
 *  
 *    - You can not create an object of an abstract class.
 *      - For example, given the abstract class ShapeBase, 
 *        the following statement is illegal:
 *        
 *        ShapeBase f = new ShapeBase(); // illegal
 *        
 *        - Nonetheless, it makes perfectly good sense to have a parameter of type ShapeBase.
 *        - Then an object of any of the derived class of ShapeBase can be plugged in for the parameter.
 *    
 *  
 */

/**
 * 
 * Abstract base class for drawing simple shapes on the screen using characters.
 *
 */
public abstract class ShapeBase implements ShapeInterface{
	
	private int offset;
	public abstract void draeHere();
	
	// constructor
	public ShapeBase() {
		offset = 0;
	}
	
	public ShapeBase(int theOffset) {
		offset = theOffset;
	}
	
	public void setOffset(int newOffset) {
		offset = newOffset;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public void drawAt(int lineNumber) {
		for(int count = 0; count < lineNumber; count++)
			System.out.println();
		drawHere();
	}
	
	

}
