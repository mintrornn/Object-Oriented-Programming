//Intr-orn Lertsupakitsin
//id: 6288089
//Section1

/*
 * DO NOT MODIFY THIS CLASS
 */
class Square extends Shape{
	double width;
	
	public Square(double width){
		super("green", "Square with width " + width);
		this.width = width;
	}
	
	public double getArea(){
		return width * width;
	}
}
