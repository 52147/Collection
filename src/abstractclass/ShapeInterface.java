package abstractclass;

/**
 * 
 * = Character graphics =
 * 
 * - Java has methods to draw graphics on your computer screen.
 * - Suppose, however, that the screen on the inexpensive device 
 *   you are designing for has no graphics capability, allowing only text output.
 *   
 * - In this case study, we will design three interfaces and three classes 
 *   that produce graphics on a screen by placing ordinary keyboard characters
 *   on each line to draw simple shapes.
 * - Our drawings will not be sophisticated, but we will be able explore the use of interfaces and inheritance in solving a problem.
 * 
 * - Let's begin by writing an interface that specifies the methods that our objects should have.
 * - Suppose the method drawHere draws the shape beginning at the current line
 *   and drawAt draws it after moving a given number of lines down from the current one.
 * 
 * - All shapes have some properties in common.
 *   - For example,
 *     each of the shape will have offset telling how far it is indented from the left edge of the screen.
 *   - We can include set and get methods for this offset.
 * 
 * - Each shape will also have a size, but the size of some shapes is described by a single number,
 *   while the size of others is determined by several numbers.
 * - Since the size will be specified according to the kind of shape,
 *   it isn't an attribute that all shapes will have in common.
 *   
 * - This interface contains an interface for the methods that all shapes will have.      
 *
 *
 * - Suppose we want to draw rectangles and triangles.
 * - The size of a rectangle is given as its width and height,
 *   each expressed as a number of characters.
 * - Because characters are taller than they are wide,
 *   a rectangle might look taller than we expect.
 *   - For example, 
 *     a 5 by 5 rectangle will not look square on the screen.
 *     
 * - Suppose we decide that a triangle will always point up, with its base at the bottom.
 * - After choosing the length of the base, and to make the other sides smooth,
 *   the slops of the sides are limited to what we get by indenting one character per line.
 * - So once the base is chosen, we have no choice regarding what the sides of the triangle will be.
 * 
 * - If we could be content to specify a shape's offset and size in its constructor alone,
 *   the interface we wrote would suffice.
 * - Since the size of a shape depends on the shape being drawn, we will define 2 more interface,
 *   one for rectangles and one for triangles.
 * - Note that both of them extend ShapeInterface.
 * 
 * 
 * A sample rectangle and triangle:
 * 
 * - A 5 by 4 rectangle:
 *  
 * <--------->-----
 *   Offset   |    |   
 *            |    |
 *            |    |
 *            -----
 *            
 * - Triangle whose size is determined by its base:
 *            
 *            
 *            
 *            ***************
 *            Base of size 15
 *            
 */

/**
 * 
 * Interface for simple shapes drawn in the screen using keyboard characters.
 *
 */
public interface ShapeInterface {
	/**
	 * Sets the offset for the shape.
	 */
	public void setOffset(int newOffset);

	/**
	 * Returns the offset for the shape.
	 */
	public int getOffset();

	/**
	 * Draws the shape at lineNumber lines down from the current line.
	 */
	public void drawAt(int lineNumber);

	/**
	 * Draws the shape at the current line.
	 */
	public void drawHere();
}
