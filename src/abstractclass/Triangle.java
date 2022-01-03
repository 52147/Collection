package abstractclass;
/**
 * - We can design the class Rectangle using the same techniques we used to design the class Rectangle.
 * - We will discuss only one part of the method drawHere for which the technical details might not be clear at first.
 * 
 * 
 * drawHere():
 * 
 * - The method drawHere divides its task into 2 subtasks:
 * 
 *   - Draw the inverted V for the top of the triangle,
 *     and draw the horizontal line for the bottom of the triangle.
 *     
 *   - Note that the entire shape is offset.
 *   - The indentation for the wide bottom of the shape is exactly this offset.
 *   - But going up from bottom to top, each line has a greater indentation.
 *   - Alternatively, moving down the lines from top to bottom--as the computer must--the indentation decreases by one character per line.
 *   - So if the indentation for the top of the triangle is given by the value of the int variable startOfLine,
 *     the first indentation can be performed by
 *                         
 *                         skipSpaces(startOfLine);
 *                         
 *     - We then write a single asterisk.
 *     - After writing the asterisk for the first line,
 *       we need to write 2 asterisks for each subsequent line.
 *     - We write a loop that decreases startOfLine by 1 on each iteration and
 *       executes a statement exactly like the previous call to skipSpaces.
 *     - We then write an asterisk and skip some more spaces before writing the second asterisk.
 *     - The size of the gap between the 2 asterisks on a line increases by 2
 *       as we move down from line to line.
 *     - If this gap is given by the value of the int variable insideWidth,
 *       the loop for drawing all of the inverted V expect for the top asterisk.
 * 
 * 
 **/

/**
 * - Class for drawing triangles on the screen using keyboard characters.
 * - A triangle points up.
 * - Its size is determined by the length of its base, which must be an odd integer.
 * - Inherits getOffset, setOffset, and drawAt from the class ShapeBasics.
 * 
 *
 */
public class Triangle extends ShapeBasics implements TriangleInterface{
	
	private int base;
	
	public Triangle() {
		super();
		base = 0;
	}
	
	public Triangle(int theOffset, int theBase) {
		super(theOffset);
		base = theBase;
	}
	
	/**Precondition: newBase is odd.*/
	public void set(int newBase) {
		base = newBase;
	}
	
	public void drawHere() {
		drawTop();
		drawBase();
	}
	
	private void drawBase() {
		
		skipSpaces(getOffset());
		for(int count = 0; count < base; count++)
			System.out.println('*');
		System.out.println();
	}
	
	private void drawTop() {
		
		// startOfLine == number of spaces to th first '*' on a line.
		// Initially set to the number of spaces before the topmost '*'.
		int startOfLine = getOffset() + base/2;
		skipSpaces(startOfLine);
		System.out.println('*'); // top '*'
		
	}
	
	private static void skipSpaces(int number) {
		for(int count = 0; count< number; count ++)
			System.out.println(' ');
	}

}
