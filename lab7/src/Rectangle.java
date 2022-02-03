
/*
 * The Rectangle class, subclass of Shape
 */
public class Rectangle extends Shape {
   // Private member variables
   //add your code here
	private double length;
	private double width;
	
   // Constructors
   public Rectangle()
   {
	  //add your code here
	  length = 0;
	  width = 0;
   }
   public Rectangle(String color, double length, double width) {
      //add your code here
	   super(color);
	   this.length = length;
	   this.width = width;
   }

   @Override
   public String toString() {
      //add your code here
	   String rec = "Rectangle[length=" + length + ",width=" + width + "," +super.toString() + "]";
	   return rec;
   }

   // Override the inherited getArea() to provide the proper implementation
   @Override
   public double getArea() {
      //add your code here
	   double area = length*width;
	   return area;
	   
   }

   public double getArea(double length, double width) {
	   this.length = length;
	   this.width = width;
	   return getArea();
	   }

}
