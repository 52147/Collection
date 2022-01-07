package abstractclass;
/**
 *    
 * - We now have our specifications,
 *   so we can try to write some Java statements that use our drawing methods.
 *   - For example,
 *     we could draw an 8 by 4 rectangle on the current line, offset 5 spaces, as follows:
 *     
 *     RectangleInterface box = new Rectangle(5, 8, 4);
 *     box.drawHere();
 *     
 * - We then could revise the size and indentation of the object box and
 *   draw it after moving down the screen by 2 lines, as follows:
 *   
 *   box.set(5,5);
 *   box.setOffset(10);
 *   box.drawAt(2);
 *   
 * - Our specifications seem reasonable, so we'll now go on to some implementation issues.
 * - Let's write a base class named ShapeBasics that implements ShapeInterface.
 * - Later we can derive the classes Rectangle and Triangle from this base class.
 * - We saw that the only common attribute is the offset,
 *   so the class ShapeBasics will have only the following instance variable:
 *   
 *   private int offset;
 *   
 * - Our interface specifies the class's methods, so we need only define them
 *   and add some appropriate constructors.
 *   
 *   
 *   drawAt()
 *   - The method drawAt has one parameter of type int,
 *     whose value indicates the number of blank lines to be inserted before the drawing of the shape.
 *   
 *   drawHere()
 *   - The shape is  drawn by a call to drawHere.
 *   - The method drawHere indents a number of spaces on the screen
 *     equal to the offset and then write an asterisk on the screen.
 *   - This simple output is just you can have something to test.
 *   
 *   - You do not intend to use this version of drawHere in any application.
 *   - You will override the definition of drawHere when you define classes for rectangles and triangles.
 *        
 *
 */

/**
 * 
 * Class for drawing simple shapes on the screen using keyboard characters. The
 * class will draw an asterisk in the screen as a test.
 * 
 * It is not intended to create a "real" shape, but rather to be used as a base
 * class for other classes of shapes.
 * 
 *
 */
public class ShapeBasics implements ShapeInterface {
	private int offset;

	public ShapeBasics() {
		offset = 0;
	}

	public ShapeBasics(int theOffset) {
		offset = theOffset;
	}

	public void setOffset(int newOffset) {
		offset = newOffset;
	}

	public int getOffset() {
		return offset;
	}

	public void drawAt(int lineNumber) {
		for (int count = 0; count < lineNumber; count++)
			System.out.println();
		drawHere();
	}

	public void drawHere() {
		for (int count = 0; count < offset; count++)
			System.out.print(' ');
		System.out.println('*');
	}
}
