package my.learning_java.sandbox;

public class DistanceCalculate
{
	
	public static void main(String[] args)
	{
		Point p1 = new Point(5,6);
		Point p2 = new Point(6,4);
		
		System.out.println("Расстояие между точкой с координатами "+ p1.x + " и " + p1.y
		+ " и точкой с координатами " + p2.x + " и " + p2.y + " = " + p1.distancePoints(p2) + " расчет через метод" );
		
		System.out.println("Расстояие между точкой с координатами "+ p1.x + " и " + p1.y
		+ " и точкой с координатами " + p2.x + " и " + p2.y + " = " + distance(p1, p2) + " расчет через функцию" );
	}
	
	public static double distance(Point p1, Point p2)
  {
		return Math.sqrt(((p2.x-p1.x)*(p2.x-p1.x)) + ((p2.y - p1.y)*(p2.y - p1.y)));
						
  }

}
