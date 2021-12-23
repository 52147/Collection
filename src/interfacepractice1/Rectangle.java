package interfacepractice1;
/**
 * 
 * The Rectangle class, which implements the Stretchable interface.
 *
 */

public class Rectangle extends Shape implements Stretchable{
	private double length;
	private double width;
	
	public Rectangle(double len, double wid) {
		length = len;
		width  = wid;
	}
	public double area() {
		return length*width;
	}
	public String toString() {
		return "Rectangle : " + length + "" + width;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	@Override
	public void stretch(double factor) {
		// TODO Auto-generated method stub
		
	}
	
 
}
