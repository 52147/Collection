package abstractclass;
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
 *      - We never intended to invoke the method drawHere of an object of the base class ShapeBasics.
 *      - Rather, we planned to use the method drawHere only with objects of derived classes,
 *        such as Rectangle and Triangle.
 *        
 *      - Instead of giving a contrived definition of a method that we plan to override in a derived class,
 *        however, we can declare the method to be abstract, as follows:
 *        
 *            public abstract void drawHere();
 *    
 *  
 * 
 *
 */
public abstract class ShapeBase {

}
