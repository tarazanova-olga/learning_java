package my.learning_java.sandbox;

public class Square
{
	public double l;
	
	public Square (double len)
	{
		
		this.l=len;
	}
	
	//функция для расчета площади квадрата, принимающая 1 параметр
	public double area()
	{
		
		return this.l * this.l;
	}
}



