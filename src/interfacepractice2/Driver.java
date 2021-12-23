package interfacepractice2;
/**
 * 
 * - A variable's type determines what method names can be used, 
 *   but the object the variable references determines which definition of the method will be used.
 * 
 * - dynamic binding and polymorphism apply to interface:
 * 
 *   - Dynamic binding applies to interfaces just as it does with classes.
 *   - The process enables objects of different classes to substitute for one another,
 *     if they have the same interface.
 *   - This ability--called polymmorphism--allows different objects to use different method actions for the same method name.
 */

public class Driver {
	/**
	 * An Interface as a Type:
	 * 
	 *  - An interface is a reference type.
	 *  - Thus, you can write a method that has a parameter of an interface type,
	 *    such as a parameter of type Measurable.
	 * @param figure
	 */	
	// invoke this display method, passing it an object of any class that implements the interface Measurable.
	public static void display(Measurable figure) {
		double perimeter = figure.getPerimeter();
		double area = figure.getArea();
		System.out.println("Perimeter = " + perimeter + "; area = " + area);
	}

	public static void main(String[] args) {
		/**
		 * - Even though the type of both variables is Measurable, the objects referenced by box and disc
		 *   have different definitions of getPerimeter and getArea.
		 * - The variable box references a Rectangle object; disc referenced a Circle object.
		 * 
		 * - The class Rectangle and Circle implement the same interface,
		 *   so we are able to substitute an instance of one for an instance of the other
		 *   when we  call the method display.
		 * - This is an example of polymorphism--the ability to substitute one object for another 
		 *   using dynamic binding.
		 * - These terms refer to the fact that the method invocation is not bound to the method definition
		 *   until the program executes.
		 * 
		 */
		Measurable box = new Rectangle(5.0, 5.0);
		Measurable disc  = new Circle(5.0);
		display(box);
		display(disc);
		
		/**	
		 * - code below is another example of polymorphism.
		 * - The two calls to display are identical, and the code within the method display is identical in both cases.
		 * - Thus, the invocations of getPerimeter and getArea within display are identical.
		 * 
		 * - Yet these invocations use different definitions for getPerimeyer and getArea,
		 *   and so the two invocations of display produce different output.
		 * 
		 */		
		Measurable m;
		Rectangle box1 = new Rectangle(5.0, 5.0);
		m = box1;
		display(m);
		
		Circle disc1 = new Circle(5.0);
		m = disc1;
		display(m);
		
		
		/**
		 * - A variable of an interface type can reference an object of a class that implements the interface,
		 *   but the object itself always determines which method actions to use for every method name.
		 * - The type of the variable does not matter.
		 * - What matter is the class name when the object was created, because java uses dynamic binding.
		 * 
		 * - You therefore need to be aware of how dynamic binding interacts with the java compiler's type checking.
		 * 
		 */
		Measurable a = new Circle(5.0);
		// We can assign an object of type Circle to a variable of type Measurable,
		// again because Circle implements Measurable.
		// However, we can use the variable to invoke only a method that is in the interface Measurable.
		// Thus, the invocation of getCircumference is illegal.
		//      System.out.println(a.getCircumference()); // illegal
		// because getCircumference is not the name of a method in the Measurable interface.
		// In this invocation, the variable m is of type Measurable,
		// but the object referenced by m is still an object of type Circle.
		//
		// Thus, although the object has the method getCircumference,
		// the compiler does not know this.
		// To make the invocation valid, you need a tyoe cast, such as the following:
		Circle c = (Circle)a;
		System.out.println(c.getCircumference() ); // legal
		
		

	}

}
