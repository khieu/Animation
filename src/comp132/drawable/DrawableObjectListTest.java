package comp132.drawable;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrawableObjectListTest {
	private DrawableObjectList objList;
	@Before public void setUp(){
		objList = new DrawableObjectList();
	}
	@Test
	public void testAddObject() {
		objList.addObject(new DrawableRectangle(4, 5, 20, 30));
		objList.addObject(new DrawableRectangle(5, 6, 20, 20));
		objList.addObject(new DrawableLine(2, 3, 7, 9));
		Assert.assertEquals(3, objList.numObjects());
	}
	@Test
	public void testScaleAllObject(){
		DrawableRectangle newRect = new DrawableRectangle(4, 5, 20, 30);
		DrawableLine newLine = new DrawableLine(15,15, 30, 30);
		objList.addObject(newLine);
		objList.addObject(newRect);
		objList.scaleAllObjects(2);
		Assert.assertEquals(40, newRect.getWidth());
		Assert.assertEquals(60, newRect.getHeight());
	}	
	@Test
	public void testWrite(){
		DrawableRectangle newRect = new DrawableRectangle(4, 5, 20, 30);
		DrawableLine newLine = new DrawableLine(15,15, 30, 30);
		objList.addObject(newLine);
		objList.addObject(newRect);
		objList.write("Objects.txt");
	}
	@Test
	public void testConstructorReadFromFile() {
		objList.addObject(new DrawableRectangle(4, 5, 20, 30));
		objList.addObject(new DrawableRectangle(5, 6, 20, 20));
		objList.addObject(new DrawableLine(2, 3, 7, 9));
		objList.addObject(new DrawableCircle(2,5,15));
		objList.addObject(new DrawablePoint(25,24));
		objList.addObject(new DrawableString(10,20, "This is a string"));
		objList.write("objectList.txt");
		DrawableObjectList copy = new DrawableObjectList("objectList.txt");
		Assert.assertEquals(6, copy.numObjects());	
	}
	@Test
	public void testgetObject(){
		objList.addObject(new DrawableRectangle(4, 5, 20, 30));
		objList.addObject(new DrawableRectangle(5, 6, 20, 20));
		objList.addObject(new DrawableLine(2, 3, 7, 9));
		objList.addObject(new DrawableCircle(2,5,15));
		Assert.assertEquals("The java.awt.Color[r=0,g=0,b=0] line has 2 points: (2, 3) and (7, 9) ", objList.getObject(2).toString());
	}
	
	@Test
	public void testInterpolate(){
		objList.addObject(new DrawableRectangle(4, 5, 20, 30));
		objList.addObject(new DrawableRectangle(5, 6, 20, 20));
		objList.addObject(new DrawableLine(2, 3, 7, 9));
		objList.addObject(new DrawableCircle(2,5,15));
		objList.addObject(new DrawablePoint(25,24));
		objList.addObject(new DrawableString(10,20, "This is a string"));
		DrawableObjectList after = new DrawableObjectList();
		after.addObject(new DrawableRectangle(12, 15, 30, 50));
		after.addObject(new DrawableRectangle(5, 6, 20, 20));
		after.addObject(new DrawableLine(4, 9, 9, 11));
		after.addObject(new DrawableCircle(2,5,45));
		after.addObject(new DrawablePoint(75,72));
		after.addObject(new DrawableString(20,30, "This is a string"));
		DrawableObjectList between = objList.interpolate(after, .5);
		System.out.println(between.getObject(1));
		Assert.assertEquals(between.numObjects(), 6);
		
	}

}
