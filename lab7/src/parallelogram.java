
public class parallelogram extends Shape {
	private double base;
	private double height;
	
	public parallelogram(){
		
	}
	
	public parallelogram(String color, double base, double height){
		super(color);
		this.base = base;
		this.height = height;
	}
	
	public String toString(){
		String para = "Parallelogram[base=" + base + ",height=" + height + "," + super.toString() + "]";
		return para;
	}
	
	public double getArea(){
		double area = base*height;
		return area;
	}
	
	public double getArea(double base, double height){
		this.base = base;
		this.height = height;
		return getArea();
	}
}
