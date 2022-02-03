//Intr-orn Lertsupakitsin
//id: 6288089
//Section1

/*
 * DO NOT MODIFY THIS CLASS
 */
public class Circle extends Shape{
	double diameter;
	
	public Circle(double diameter){
		super("yellow", "Circle with diameter " + diameter);
		this.diameter = diameter;
	}
	
	public double getArea(){
		return Shape.PI * diameter * diameter;
	}
}