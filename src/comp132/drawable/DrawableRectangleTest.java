package comp132.drawable;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrawableRectangleTest {
	private DrawableRectangle newRect;
	@Before public void setUp(){
		newRect = new DrawableRectangle(4, 5, 20, 30);
	}
	@Test
	public void testConstructor() {
		Assert.assertEquals(20, newRect.getWidth());
		Assert.assertEquals(30, newRect.getHeight());
		Assert.assertEquals(4, newRect.getX());
		Assert.assertEquals(5, newRect.getY());
		
	}
	@Test
	public void testScale(){
		newRect.scale(0.5);
		Assert.assertEquals(10, newRect.getWidth());
		Assert.assertEquals(15, newRect.getHeight());
	}
	@Test
	public void testToString(){
		String result = "This java.awt.Color[r=0,g=0,b=0] rectangle has the width of 20 and the height of 30. Its initial uper left point is (4, 5)."; 
		Assert.assertEquals(result, newRect.toString());
	}
	@Test
	public void testConstructorReadFromFile() throws IOException{
		FileOutputStream fos = new FileOutputStream("aRectangle.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		newRect.write(dos);
		FileInputStream fis = new FileInputStream("aRectangle.txt");
		DataInputStream dis = new DataInputStream(fis);
		dis.readLine();
		DrawableRectangle copy = new DrawableRectangle(dis);
		Assert.assertEquals(newRect.toString(), copy.toString());
	}
	@Test
	public void testConstructorInterpolation(){
		DrawableRectangle obj0 = new DrawableRectangle(20,20, 40, 70);
		DrawableRectangle obj1 = new DrawableRectangle(40,40, 60, 90);
		DrawableRectangle between = new DrawableRectangle(obj0, obj1, .5);
		Assert.assertEquals(30, between.getX());
		Assert.assertEquals(30, between.getY());
		Assert.assertEquals(50, between.getWidth());
		Assert.assertEquals(80, between.getHeight());
		Assert.assertEquals(between.getColor(), obj0.getColor());
	}
	@Test
	public void testInterpolate() {
		DrawableRectangle obj0 = new DrawableRectangle(20,20, 40, 70);
		DrawableRectangle obj1 = new DrawableRectangle(40,40, 60, 90);
		DrawableRectangle between = (DrawableRectangle) obj0.interpolate(obj1, 0.5);
		Assert.assertEquals(30, between.getX());
		Assert.assertEquals(30, between.getY());
		Assert.assertEquals(50, between.getWidth());
		Assert.assertEquals(80, between.getHeight());
		Assert.assertEquals(between.getColor(), obj0.getColor());
	}
}
