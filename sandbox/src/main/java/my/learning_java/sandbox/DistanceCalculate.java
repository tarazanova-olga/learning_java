package my.learning_java.sandbox;

public class DistanceCalculate
{
	
	public static void main(String[] args)
	{
		Point p = new Point(5,2,6,4);
		System.out.println("Расстояие между точкой с координатами " + p.x1 + " и " + p.y1
		+ " и точкой с координатами " + p.x2 + " и " + p.y2 + " = " + p.distance());
	}
	
}
