package my.learning_java.sandbox;


public class Rectangle
{
	public double a;
	public double b;
	
	public Rectangle (double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	
	//функция для расчета площади прямоугольника, принимающая 2 параметра
	public double area()
	{
		return this.a * this.b;
	}
	
	
}
