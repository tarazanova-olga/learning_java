package my.learning_java.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest
{
	@Test
	public void testPoint()
	{
	  Point p1 = new Point(5,6);
		Point p2 = new Point(6,4);
		
		Assert.assertEquals(p1.distancePoints(p2), 2.23606797749979);
		
		Assert.assertEquals(Math.round(p1.distancePoints(p2)), 2);
		
		Assert.assertTrue(Math.abs(p1.distancePoints(p2)-2.23) < 0.1);
		
		Point p3 = new Point(-5,0);
		Point p4 = new Point(-5,0);
		
		Assert.assertEquals(p3.distancePoints(p4), 0.0);
		
	}
	
}
