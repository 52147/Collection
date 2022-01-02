package abstractclass;
/**
 * - This Rectangle class will be a derived class of the class ShapeBasics.
 * - we want our class to implement RectangleInterface 
 * 
 * - When you have both an extends clause and an implements clause,
 *   the extends clause is always first.
 * - An easy way to remember the order of these 2 clauses is to notice
 *   that the keywords extends and implements are in alphabetical order.
 * 
 * - We need to decide what instance variable to add to those already in the class ShapeBasics.
 * - We also need to decide whether to override any method definitions in ShapeBasics.
 * 
 * - This Rectangle will be able to use the instance variable offset in the base class,
 *   but we need to have instance variables for the height and the width of the rectangle.
 *   
 * - Note that we do not list the instance variable offset within Rectangle.
 * - We know that Rectangle needs the usual constructors and a set method for the sides.
 * - Rectangle inherits the methods setOffset, getOffset, draeAt, and drawHere from the class ShapeBasics.
 * 
 * - However, we need to override the definition of the method drawHere so that it does indeed draw a rectangle.
 * - Do we need to override the method drawAt?
 *   - When we look at the method drawAt, we see that, as long as drawHere is correctly defined,
 *     the method drawAt will work fine for a rectangle or ant other shape.
 *     -> Polymorphism will ensure that the correct version of drawHere is called. 
 * 
 * constructor:
 * - Let's look first at a sample constructor, one that sets all instance variables to the values given as its arguments.
 * - But one instance variable, namely offset, is a private instance variable of the base class ShapeBasics,
 *   so we can not access it directly by name.
 * - However, we can either call the method setOffset or use super to call the base class constructor.
 * - We choose latter.
 * 
 * default constructor:
 * 
 * - The default constructor similarly calls the base class default constructor
 *   and sets the rectangle's dimensions to 0.
 * - We could omit an explicit call to super in the default constructor,
 *   and it would be called automatically anyway, but we leave it in for clarity.
 *
 * set():
 * 
 * - The method set, as specified in RectangleInterface, is straightforward,
 *   so let's examine the method drawHere, which depends heavily on the particulars of the shape it is drawing.
 *   
 * - We can use a technique knows as top-down design.
 * - In this technique, we break down the task to be performed into subtasks.
 *   - We have the following subtasks:
 *   
 *     Algorithm to draw a rectangle:
 *     1. Draw the top line.
 *     2. Draw the side lines.
 *     3. Draw the bottom line.
 *     
 *     
 *     - Note that not every way of choosing subtasks will work.
 *     - You might at first be tempted to draw the sides of the box in 2 subtasks.
 *	   - However, output must be produced one line after the other, 
 *       and you are not allowed to back up.
 *     - Thus, we must draw the 2 sides together so they will be side by side.
 *      
 *     - Although that was easy, it does postpone most of the work.
 *     - You still need to define the methods drawHorizontalLine and drawSides.
 *     - Because these are helping methods, they will be private methods.
 *     
 * draeHorizontalLine():
 * 
 *   - Algorithm:
 *     - 1. Display offset blank spaces.
 *     - 2. Display width copies of the character '-'.
 *     - 3. System.out.println();
 *     
 *   - The task of writing a specified numbers of blanks is done by another 
 *     helping method called skipSapces, which contains a simple loop.      
 * 
 * draeSides():
 * 
 * - Since each line is identical, we can treat the display of one of these lines as a subtask.
 * 
 * - Note that we display 2 fewer lines than the height.
 * - The top and bottom horizontal lines account for those extra 2 units of height.
 * 
 */

/**
 * - Class for drawing rectangles on the screen using keyboard characters.
 * - Each character is higher that it is wide, so these rectangles will look taller than you might expect.
 * - Inherits getOffset, setOffset, and drawAt from the class ShapeBasics.
 *
 */
public class Rectangle extends ShapeBasics implements RectangleInterface{
	
	private int height;
	private int width;
	
	// default constructor
	public Rectangle() {
		super();
		height = 0;
		width = 0;
	}
	
	public Rectangle(int theOffset, int theHeight, int theWidth) {
		super(theOffset);
		height = theHeight;
		width = theWidth;
	}
	
	public void set(int newHeight, int newWidth) {
		height = newHeight;
		width = newWidth;
	}
	
	public void drawHere() {
		drawHorizontalLine();
		drawSides();
		drawHorizontalLine();
	}
	
	public void drawHorizontalLine() {
		skipSpaces(getOffset());
		for(int count = 0 ; count < width; count ++)
			System.out.println('-');
		System.out.println();
	}
	
	private void drawSides() {
		for(int count = 0 ; count <(height - 2); count++)
			drawOneLineOfSides();
	}
	
	private void drawOneLineOfSides() {
		skipSpaces(getOffset());
		System.out.println('|');
		skipSpaces(width-2);
		System.out.println('|');
	}
	
	// Writes the indicated number of spaces.
	// the method skipSpaces was made static because it does not depend on an object.
	private static void skipSpaces(int number) {
		for(int count = 0; count < number; count++)
			System.out.println(' ');
	}

}
