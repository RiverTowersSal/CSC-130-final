/* This class is used to give you a handy way to pass a pair of 2D coordinates as a single object. The behavior (methods) of the class should allow for robust options in the future. */

package Data;

public class Vector2D {
	// Fields
		// TODO: Add private class fields to store x and y values given in class constructor
		private int x1;
		private int y1;
	// Constructor
	public Vector2D(int x, int y){
		// TODO: Save the constructor parameters into class fields
		x1 = x;
		y1 = y;
	}
	
	// Methods
	public int getX(){
		// TODO: Remove my placeholder code below (which is there to prevent an error) and replace it with returning the value of your private field x
		return x1;
	}
	
	public int getY(){
		// TODO: Remove my placeholder code below (which is there to prevent an error) and replace it with returning the value of your private field y
		return y1;
	}
	
	public void setX(int newX){
		// TODO: Update the value of x to be the value in newX (Absolute assignment)
		x1 = newX;
	}
	
	public void setY(int newY){
		// TODO: Update the value of y to be the value in newY (Absolute assignment)
		y1 = newY;
	}
	
	public void adjustX(int adjustment){
		// TODO: Change the previous value of x by adding the adjustment to the previous value (Relative assignment)
		// Backward adjustments can be made by passing a negative number as an adjustment
		x1 = x1 + adjustment;
		
	}
	
	public void adjustY(int adjustment){
		// TODO: Change the previous value of y by adding the adjustment to the previous value (Relative assignment)
		// Backward adjustments can be made by passing a negative number as an adjustment
		y1 = y1 + adjustment;
	}
	
	
}
