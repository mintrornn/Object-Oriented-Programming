

public class ShapeTester {
	   public static void main(String[] args) {
	      Shape s1 = new Rectangle("red", 4, 5);
	      System.out.println(s1);  // Run Rectangle's toString()
	      System.out.println("Area is " + s1.getArea());  // Run Rectangle's getArea()

	      Shape s2 = new Triangle("blue", 4, 5);
	      System.out.println(s2);  // Run Triangle's toString()
	      System.out.println("Area is " + s2.getArea());  // Run Triangle's getArea()

	      Shape s3 = new Shape("blue");  // Upcast
	      System.out.println("--Test superclass method--");
	      System.out.println(s3);  // Run Triangle's toString()
	      System.out.println("Area is " + s3.getArea());  // Run Triangle's getArea()

	      Rectangle s4 = new Rectangle();  // Upcast
	      s4.setColor("green");
	      System.out.println("--Test overload method--");
	      System.out.println("Area is " + s4.getArea(5.0, 10.0));  // Run Rectangle's getArea()
	      System.out.println(s4);  // Run Rectangle's toString()

	      Triangle s5 = new Triangle();  // Upcast
	      s5.setColor("yellow");
	      System.out.println("--Test overload method--");
	      System.out.println("Area is " + s5.getArea(5.0, 10.0));  // Run Triangle's getArea()
	      System.out.println(s5);  // Run Triangle's toString()
	   
	      parallelogram s6 = new parallelogram();
	      s6.setColor("red");
	      System.out.println("--Test overload method--");
	      System.out.println("Area is " + s6.getArea(5.0, 10.0));  // Run Triangle's getArea()
	      System.out.println(s6);  // Run parallelogram's toString()

	      
	      parallelogram s7 = new parallelogram("black", 5, 10);
	      System.out.println(s7);  // Run parallelogram's toString()
	      System.out.println("Area is " + s7.getArea());  // parallelogram's getArea()
	   }
	}
