package my.learning_java.sandbox;

public class MyFirstProgram
{
	public static void main(String[] args)
	{
		double len = 5;
		double a = 5;
		double b = 12;
		hello("world");
		hello("olga");
		System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));
		System.out.println("Площадь прямоугольника со сторонами " + a  + " и " + b + " = " + area(a,b));
		
	}
	public static void hello(String name)
	{
		System.out.println("Hello, " + name + "!");
	}
	
	//функция для расчета площади квадрата, принимающая 1 параметр
	public static double area(double l)
	{
		return l*l;
	}
		
	//функция для расчета площади прямоугольника, принимающая 2 параметра
	public static double area(double a, double b)
	{
		return a*b;
	}
}