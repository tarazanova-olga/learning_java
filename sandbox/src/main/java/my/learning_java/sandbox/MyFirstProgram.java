package my.learning_java.sandbox;

public class MyFirstProgram
{
	public static void main(String[] args)
	{
		Square s = new Square(5); //создаем новый объект - квадрат
		Rectangle r = new Rectangle(5,12); //создаем новый объект - прямоугольник
		hello("world");
		hello("olga");
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
		System.out.println("Площадь прямоугольника со сторонами " + r.a  + " и " + r.b + " = " + r.area());
		
	}
	public static void hello(String name)
	{
		System.out.println("Hello, " + name + "!");
	}
	
}